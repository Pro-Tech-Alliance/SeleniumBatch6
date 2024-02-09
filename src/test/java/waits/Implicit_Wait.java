package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;


public class Implicit_Wait extends Hooks {
    @Test
    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement element = driver.findElement(By.id("user-name"));

        element.isEnabled();


    }





}
