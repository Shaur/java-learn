package ru.javalearn.maven.service;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import com.turn.ttorrent.common.Torrent;
import org.apache.commons.io.IOUtils;
import ru.javalearn.maven.entity.RSSItem;
import ru.javalearn.maven.entity.RSSList;
import ru.javalearn.maven.entity.Setting;
import ru.javalearn.maven.entity.Settings;
import ru.javalearn.maven.utils.RssUtil;
import ru.javalearn.maven.utils.SettingsUtil;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 18.05.16
 */
public class ScheduledService {
    private static final String RSS_URL = "http://www.lostfilm.tv/rssdd.xml";
    private static Settings settings;
    private static ScheduledExecutorService checkUpdatesTime;


    public ScheduledService() {
        settings = SettingsUtil.loadSettings();
        checkUpdatesTime = new ScheduledThreadPoolExecutor(4);
    }

    public void run() {
        checkUpdatesTime.scheduleAtFixedRate(() -> {
            System.out.println("Run service");
            try {
                RSSList rssList = RssUtil.loadRssItems(RSS_URL);
                Map<Setting, RSSItem> map = RssUtil.getItemsBySettings(rssList.getItems(), settings);
                for(Setting key : map.keySet()) {
                    URL url = new URL(map.get(key).getLink());
//                    ReadableByteChannel rbc = Channels.newChannel(url.openStream());
//                    FileOutputStream fos = new FileOutputStream(key.getName() + ".torrent");
//                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                    //Files.copy(url.openStream(), Paths.get(key.getName() + ".torrent"), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Torrent copy");
                    URLConnection request = url.openConnection();
                    request.setRequestProperty("Cookie", "usess=e7cfe3f502419609a2d5d0021560597b");
                    Files.copy(request.getInputStream(), Paths.get(key.getName() + ".torrent"), StandardCopyOption.REPLACE_EXISTING);
                    File source = new File(key.getName() + ".torrent");
                    File target = new File(key.getPath());
                    target.mkdirs();
                    byte[] torrentFileBytes = IOUtils.toByteArray(Files.newInputStream(Paths.get(source.getPath())));
                    Torrent torrentFile = new Torrent(torrentFileBytes, false);

                    SharedTorrent sharedTorrent = new SharedTorrent(torrentFile, target);
                    Client client = new Client(
                            // This is the interface the client will listen on (you might need something
                            // else than localhost here).
                            InetAddress.getLocalHost(),

                            // Load the torrent from the torrent file and use the given
                            // output directory. Partials downloads are automatically recovered.
                            sharedTorrent);

                    client.addObserver((observable, data) -> {
                        Client client1 = (Client) observable;
                        float progress = client1.getTorrent().getCompletion();
                        System.out.println(progress);
                    });

                    client.download();
                }

            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.HOURS);
    }
}
