package lv.javaguru.java2.domain;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public class Group {

    private long groupId;
    private String name;
    private String description;


    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long userId) {
        this.groupId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Group(String name, String description) {
        setName(name);
        setDescription(description);
    }
    public Group() {

    }
}
