package proctor.org.example.entity;

import com.mongodb.DBObject;

public class User extends EntityBase<User> {

    private String id;

    private String name;

    private String password;

    private boolean isActive;

    @Override
    public void fillEntityFromDBObject(DBObject dbObject) {
        this.id = (String) dbObject.get("_id");
        this.name = (String) dbObject.get("name");
        this.password = (String) dbObject.get("password");
        this.isActive = (Boolean) dbObject.get("isActive");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
