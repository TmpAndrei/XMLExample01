package org.andryushin;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tags {
    @XmlAttribute
    private int id;
    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    private LinkedList<Tag> tags;
    @XmlTransient
    private String group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Tag> getTags() {
        return tags;
    }

    public void setTags(LinkedList<Tag> tags) {
        this.tags = tags;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", tags=" + tags +
                '}';
    }
}
