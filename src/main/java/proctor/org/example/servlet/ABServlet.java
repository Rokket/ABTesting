package proctor.org.example.servlet;

import ru.abtestingframework.core.ABEngine;
import ru.abtestingframework.core.StatisticObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ABServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatisticObject statisticObject = new StatisticObject("IntegerPage", "testPage1", "testPage");
        ABEngine.createStatistic(statisticObject);
        System.out.println("");
    }
}
