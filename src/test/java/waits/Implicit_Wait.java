package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Implicit_Wait extends Hooks {
    @BeforeMethod
    public void beforeEachMethod(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(priority = -1)
    public void loginWithCorrectCredentials() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //explicitly wait for inventory page to load
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("header_container")));

        //Verify that we are on the inventory page
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //sleep
        Thread.sleep(3000);
    }
    @AfterMethod
    public void goBackToHomepage(){
        driver.navigate().back();
    }

}
