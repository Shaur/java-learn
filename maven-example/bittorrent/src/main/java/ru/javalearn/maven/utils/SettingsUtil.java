package ru.javalearn.maven.utils;

import ru.javalearn.maven.entity.Settings;

import javax.xml.bind.JAXB;
import java.io.File;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 18.05.16
 */
public class SettingsUtil {
    public static Settings loadSettings() {
        ClassLoader classLoader = (new SettingsUtil()).getClass().getClassLoader();
        File file = new File(classLoader.getResource("settings.xml").getFile());
        return JAXB.unmarshal(file, Settings.class);
    }
}
