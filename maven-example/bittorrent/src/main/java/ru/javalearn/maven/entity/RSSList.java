package ru.javalearn.maven.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by OOGIS RG.
 * Yury Glamazdo <glamazdo@oogis.ru>
 * 18.05.16
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rss")
public class RSSList {

    @XmlElementWrapper(name = "channel")
    @XmlElement(name = "item")
    private List<RSSItem> items;

    public List<RSSItem> getItems() {
        return items;
    }

    public void setItems(List<RSSItem> items) {
        this.items = items;
    }
}
