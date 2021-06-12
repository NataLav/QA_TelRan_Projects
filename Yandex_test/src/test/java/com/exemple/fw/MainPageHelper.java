package com.exemple.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageHelper extends HelperBase {

    public MainPageHelper(WebDriver wd) {
        super(wd);
    }

    public void GoToMarket(By locator) {
        click(locator);
    }
}
