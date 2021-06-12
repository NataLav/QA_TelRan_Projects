package com.exemple.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd= wd;
    }

    public void GoToMarket(By locator) {
        click(locator);
    }

   /* public void type(String locator, String text ) {
        click(locator);
        wd.findElement(By.cssSelector(locator)).click();
        wd.findElement(By.cssSelector(locator)).clear();
        if (text! = null) {
            wd.findElement(By.cssSelector(locator)).sendKeys(text);
        }
    }

    */

    public void type(String locator, String text) {
        //click(locator);
        wd.findElement(By.cssSelector(locator)).click();
        wd.findElement(By.cssSelector(locator)).clear();
        if(text!=null) {
            wd.findElement(By.cssSelector(locator)).sendKeys(text);
        }
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }
}
