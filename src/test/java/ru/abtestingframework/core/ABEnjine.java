package ru.abtestingframework.core;

import com.mongodb.DBObject;
import org.junit.Test;

public class ABEnjine {

    @Test
    public void findPageTest() {
        DBObject page = ABEngine.findPage("testPage1");
        System.out.println(page);
    }
}
