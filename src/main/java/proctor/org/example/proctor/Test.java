package proctor.org.example.proctor;

import ru.abtestingframework.core.ABEngine;

import java.net.UnknownHostException;

/**
 * Created by Matveyenka_D on 14.07.2014.
 */
public class Test {

    public static void main(String[] args) throws UnknownHostException {
        String pageName = "testPage1";
        ABEngine.addPageForTest(pageName);
        ABEngine.increment(pageName);
    }
}
