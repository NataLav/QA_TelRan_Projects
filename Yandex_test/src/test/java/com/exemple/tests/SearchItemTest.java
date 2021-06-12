package com.exemple.tests;

import com.exemple.model.Item;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void testItem() throws InterruptedException {
        /*
        Зайти в расширенный поиск
        //Применить условия поиска

        В поисковую строку ввести запомненное значение.
        Найти и проверить, что наименование товара соответствует запомненному значению.
         */

        //Перейти на Яндекс Маркет
        app.mainPage().GoToMarket(By.cssSelector("[data-id='market']"));

        app.marketItem().switchToNextTab();

        //Выбрать раздел  Компьютеры
        app.marketHeader().selectComputersDepartment(By.cssSelector("[href*='/catalog--kompiuternaia-tekhnika']"));

        //Выбрать раздел Планшеты
        app.marketItem().filterItem(new Item()
                .setItemType("planshety")
                .setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));

        app.marketHeader().pause(3000);

        //Запомнить второй элемент в результатах поиска
        String item = app.marketItem().getItemNameFromListByOrder(2);
        System.out.println(item);

        String itemName = app.marketItem().getItemNameFromListByOrder(2);
        app.marketHeader().searchItemFromSearchBox(itemName);

        app.marketHeader().pause(3000);

        String foundItemName = app.marketItem().getItemNameFromListByOrder(1);

        Assert.assertEquals(foundItemName,itemName);

    }


}
