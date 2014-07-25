package proctor.org.example.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import proctor.org.example.entity.User;

public class UserDao extends DaoBase {

    private static final String USER_COLLECTION_NAME = "user";

    public UserDao() {
        super(USER_COLLECTION_NAME);
    }

    public User getUserNyName(String userName) {
        User user = null;
        DBObject dbObject = dbCollection.findOne(new BasicDBObject().append("name", userName));
        if (dbObject != null) {
            user = new User();
            user.fillEntityFromDBObject(dbObject);
        }

        return user;
    }
}
