package com.telran.cheaptrip.tests;

import com.telran.cheaptrip.pages.MainPageHelper;
import com.telran.cheaptrip.util.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTripTests extends TestBase {

    MainPageHelper mainPageHelper;

    @BeforeMethod
    public void initTest() {
        mainPageHelper = PageFactory.initElements(driver, MainPageHelper.class);
    }

    @Test
    public void fillInTripForm() throws InterruptedException {
        mainPageHelper.fillInFromTypeForm("Berlin");
        Thread.sleep(100);
        mainPageHelper.fillInToTypeForm("Moscow");
        Thread.sleep(100);
        mainPageHelper.clickOnLetsGoButton();
        WebElement tripContainer = driver.findElement(By.cssSelector("ion-row.md.hydrated"));
        Assert.assertTrue(mainPageHelper.isElementPresent(tripContainer));
    }

    @Test(dataProvider = "fillInTripFromTripsCSVFile", dataProviderClass = DataProviders.class)
    public void fillInTripFormFromTripsCSVFile(String from, String to) {
        mainPageHelper.fillInFromTypeForm(from);
        mainPageHelper.fillInToTypeForm(to);
        mainPageHelper.clickOnLetsGoButton();
        WebElement tripContainer = driver.findElement(By.cssSelector("ion-row.md.hydrated"));
        Assert.assertTrue(mainPageHelper.isElementPresent(tripContainer));
    }

    @Test(dataProvider = "usingDBCityCSVFile", dataProviderClass = DataProviders.class)
    public void fillInTripFormFromDBCityCSVFile(String from, String to) {
        mainPageHelper.fillInFromTypeForm(from);
        mainPageHelper.fillInToTypeForm(to);
        mainPageHelper.clickOnLetsGoButton();
        WebElement tripContainer = driver.findElement(By.cssSelector("ion-row.md.hydrated"));
        Assert.assertTrue(mainPageHelper.isElementPresent(tripContainer));
    }

    @Test
    public void testIfSumOfTripIsCorrect() throws InterruptedException {
        mainPageHelper.fillInFromTypeForm("Berlin");
        Thread.sleep(100);
        mainPageHelper.fillInToTypeForm("Moscow");
        Thread.sleep(100);
        mainPageHelper.clickOnLetsGoButton();
        mainPageHelper.unfoldTripPanel();
        Assert.assertTrue(mainPageHelper.checkSumOfTrip());
    }
}
