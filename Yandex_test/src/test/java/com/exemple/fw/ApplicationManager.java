package com.exemple.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    MainPageHelper mainPage;
    MarketHeaderHelper marketHeader;
    MarketItemHelper marketItem;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public MainPageHelper mainPage() {
        return mainPage;
    }

    public MarketHeaderHelper marketHeader() {
        return marketHeader;
    }

    public MarketItemHelper marketItem() {
        return marketItem;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            //System.setProperty("driver.browser.geckodriver", "");
            wd = new FirefoxDriver();
        }
        //wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        openSite("https://yandex.ru/");

        mainPage = new MainPageHelper(wd);
        marketHeader = new MarketHeaderHelper(wd);
        marketItem = new MarketItemHelper(wd);
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void stop() {
        wd.quit();
    }


}
