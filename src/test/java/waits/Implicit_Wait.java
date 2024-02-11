package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.util.concurrent.TimeUnit;

public class Implicit_Wait extends Hooks {

    @Test
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
}
