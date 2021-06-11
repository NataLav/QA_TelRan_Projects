package com.telran.wikipedia.tests;

import com.telran.wikipedia.app.AppManager;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {
    protected static AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();

    }

//    @AfterClass(enabled = false)
//    public void tearDown() {
//        app.stop();
//    }
}
