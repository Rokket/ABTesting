package proctor.org.example.entity;

import com.mongodb.DBObject;

public abstract class EntityBase<ENTITY extends EntityBase<ENTITY>> {

    public abstract void fillEntityFromDBObject(DBObject dbObject);
}
