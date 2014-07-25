package proctor.org.example.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import proctor.org.example.db.MongoDB;

public class DaoBase {

    private static DB db;

    protected DBCollection dbCollection;

    static {
        db = MongoDB.getMongo().getDB("site");
    }

    public DaoBase(String collectionName) {
        this.dbCollection = db.getCollection(collectionName);
    }
}
