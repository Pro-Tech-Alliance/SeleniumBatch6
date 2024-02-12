package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class Implicit_waits extends Hooks {

    @Test
    public void loginPage(){

        driver.get("https://www.facebook.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.id("nav-search-submit-button")).click();

    }







}
