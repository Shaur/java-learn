package ru.javalearn.maven.utils;

import ru.javalearn.maven.entity.RSSItem;
import ru.javalearn.maven.entity.RSSList;
import ru.javalearn.maven.entity.Setting;
import ru.javalearn.maven.entity.Settings;

import javax.xml.bind.JAXB;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 18.05.16
 */
public class RssUtil {
    public static RSSList loadRssItems(String urlString) throws IOException {
        URL url = new URL(urlString);
        return JAXB.unmarshal(url.openStream(), RSSList.class);
    }

    public static Map<Setting, RSSItem> getItemsBySettings(List<RSSItem> items, Settings settings) {
        Map<Setting, RSSItem> downloadMeta = new HashMap<>();
        for(RSSItem item : items) {
            String title = item.getTitle();
            for(Setting setting : settings.getSettings()) {
                if (!title.contains(setting.getName()))
                    continue;
                if(!title.contains(setting.getQuality()))
                    continue;

                downloadMeta.put(setting, item);
            }
        }

        return downloadMeta;
    }
}
