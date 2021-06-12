package com.exemple.fw;

import com.exemple.model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MarketItemHelper extends HelperBase {

    public MarketItemHelper(WebDriver wd) {
        super(wd);
    }

    public void filterItem(Item item) {
        click(By.cssSelector("[href*='/catalog--"+ item.getItemType() +"']"));

        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        //Задать параметр поиска от 20000 до 35000 рублей.
        type("#glpricefrom", item.getPriceFrom());
        type("#glpriceto", item.getPriceTo());
        //Выбрать производителя “Apple”
        click(By.xpath("//*[text()='"+ item.getBrand() +"']"));
    }


    public void switchToNextTab() { //перейти в открывшееся окно, обойти всплывающие окна
        List<String> availableTabs = new ArrayList<>(wd.getWindowHandles());//весь список всплывающих окон. гет отвечает за то, чтобы мы получили доступное окно
        if(!availableTabs.isEmpty()){
            wd.switchTo().window(availableTabs.get(1));
        }
    }
    public String getItemNameFromListByOrder(int numberObject) {
        return wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet']["+numberObject+"]//h3")).getText();
    }
}
