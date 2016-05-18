package ru.javalearn.maven.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 18.05.16
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "settings")
public class Settings {
    @XmlElement(name = "setting")
    private List<Setting> settings;

    public List<Setting> getSettings() {
        return settings;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }
}
