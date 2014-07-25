package proctor.org.example.db;

import com.mongodb.Mongo;

import java.net.UnknownHostException;

public final class MongoDB {

    private static Mongo mongo;

    static {
        init();
    }

    private static void init() {
        try {
            mongo = new Mongo();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private MongoDB() {
    }

    public static Mongo getMongo() {
        return mongo;
    }
}
