package ru.abtestingframework.entity;

import com.mongodb.DBObject;

import java.io.Serializable;

public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer count;

    public Page() {
    }

    public Page(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public static Page getInstanceFromDBObject(DBObject dbObject) {
        Page page = new Page();
        page.name = (String) dbObject.get("name");
        page.count = (Integer) dbObject.get("count");

        return page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
