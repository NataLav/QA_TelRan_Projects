package com.telran.wikipedia.app;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(AppiumDriver driver) {
        super(driver);
    }


    public void goToReadingList() {
        tap(By.xpath("//*[@content-desc='My lists']"));
        tap(By.id("item_title"));
    }
}
