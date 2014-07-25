package ru.abtestingframework.core;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.*;

/**
 * Основной класс с функционалом для реализации A/B testing
 */
public final class ABEngine {

    private static final ResourceBundle CONFIG_BUNDLE = ResourceBundle.getBundle("abconfig");

    /**
     * It's configuration value that will be used in web pages which need to be tested
     */
    public static final String PATTERN_VALUE = CONFIG_BUNDLE.getString("pattern_value");

    private static DBCollection pageCollection;

    static {
        init();
    }

    private static void init() {
        try {
            Mongo mongo = new Mongo(getMongoURL());
            DB db = mongo.getDB("pagesDB");
            pageCollection = db.getCollection("page");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static String getMongoURL() {
        return CONFIG_BUNDLE.getString("db_url");
    }

    private ABEngine() {
    }

    /**
     * Добавляет страницу в БД для возможности проведения A/B testing к ней. По умолчанию количество отосланных запросов
     * со страницы равно 0
     *
     * @param pageName название страницы
     */
    public static void addPageForTest(String pageName) {
        DBObject dbObject = getPageQueryByName(pageName);
        dbObject.put("count", 0);
        pageCollection.insert(dbObject);
    }

    /**
     * Увеличивает посещаемость страницы на единицу (если данной страницы не существует, она создается)
     *
     * @param pageName название страницы
     */
    public static void increment(String pageName) {
        DBObject incrementQuery = new BasicDBObject();
        incrementQuery.put("$inc", new BasicDBObject().append("count", Integer.valueOf(1)));
        pageCollection.update(getPageQueryByName(pageName), incrementQuery, true, false);
    }

    /**
     * Находит объект страницы в БД по названию этой страницы
     *
     * @param pageName название страницы
     * @return объект страницы из БД
     */
    public static DBObject findPage(String pageName) {
        DBObject findQuery = getPageQueryByName(pageName);
        return pageCollection.findOne(findQuery);
    }

    /**
     * Создает статистику по страницам, установленым в <code>statisticObject</code>. Статистика ведется по процентному
     * соотношению между общей посещаемости всех страниц и конкретной страницы.
     *
     * @param statisticObject объект для создания статистики с установленным страницами
     */
    public static void createStatistic(StatisticObject statisticObject) {
        Map<String, Double> pagesMap = statisticObject.getPagesMap();
        List<DBObject> pageDBObjects = getPageDBObjectsByName(pagesMap.keySet());
        if (pagesMap.size() == pageDBObjects.size()) {
            int pagesCount = getPagesCount(pageDBObjects);
            for (DBObject dbObject : pageDBObjects) {
                Double percent = ((Integer) dbObject.get("count")) / (double) pagesCount * 100;
                pagesMap.put((String) dbObject.get("name"), Math.floor(percent * 100) / 100);
            }
        }
    }

    private static int getPagesCount(List<DBObject> pageDBObjects) {
        int count = 0;
        for (DBObject dbObject : pageDBObjects) {
            count += (Integer) dbObject.get("count");
        }

        return count;
    }


    private static List<DBObject> getPageDBObjectsByName(Set<String> pagesName) {
        DBObject query = new BasicDBObject();
        query.put("name", new BasicDBObject().append("$in", pagesName));
        DBCursor cursor = pageCollection.find(query);
        List<DBObject> pageDBObjects = new LinkedList<DBObject>();
        while (cursor.hasNext()) {
            pageDBObjects.add(cursor.next());
        }

        return pageDBObjects;
    }

    private static DBObject getPageQueryByName(String pageName) {
        DBObject findQuery = new BasicDBObject();
        findQuery.put("name", pageName);
        return findQuery;
    }
}
