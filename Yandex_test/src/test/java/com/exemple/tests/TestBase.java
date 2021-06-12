package com.exemple.tests;

import com.exemple.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    WebDriver wd;
    @BeforeClass
    public void setUp() {
        app.init();
    }

    @AfterClass(enabled = false)
    public void tearDown() {
        app.stop();
    }


}
