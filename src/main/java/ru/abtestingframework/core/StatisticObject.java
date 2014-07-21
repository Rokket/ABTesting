package ru.abtestingframework.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для генерации статистики посещаемости переданных в конструктор страниц
 */
public class StatisticObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Double> pagesMap = new HashMap<String, Double>();

    /**
     * Constructor of statistic object
     *
     * @param pageNames list names of pages
     */
    public StatisticObject(String... pageNames) {
        for (String pageName : pageNames) {
            pagesMap.put(pageName, 0d);
        }
    }

    public Map<String, Double> getPagesMap() {
        return pagesMap;
    }
}
