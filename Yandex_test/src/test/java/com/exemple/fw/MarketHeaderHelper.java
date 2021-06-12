package com.exemple.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketHeaderHelper extends HelperBase {

    public MarketHeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void selectComputersDepartment(By locator) {
        click(By.cssSelector("#pokupki"));
        click(locator);
    }


    public void searchItemFromSearchBox(String itemName) {
        type(("#header-search"), itemName);
        click(By.cssSelector("[type=submit]"));
    }
}
