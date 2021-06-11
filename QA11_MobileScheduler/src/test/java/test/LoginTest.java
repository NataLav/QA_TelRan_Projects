package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin(){
        app.user().login("nata1234@gmail.com", "Nata12345678");
       Assert.assertTrue(app.event().isElementPresent(By.id("sort_options")));
    }

}
