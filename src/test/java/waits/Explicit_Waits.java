package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Explicit_Waits extends Hooks {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Test
    public void explicite_wait (){


        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


        WebElement Logoisdisplayed = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        System.out.println(" Id the Logo of WebApp displayed : " + Logoisdisplayed.isDisplayed());


        WebElement Username=  driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Username.sendKeys("Admin");


        WebElement Password =  driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Password.sendKeys("admin1203");

        WebElement wait_time = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable (By.xpath("//button[normalize-space()='Login']")));

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


        WebElement InvalidPassword =  driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));

        String ActualCredentials = InvalidPassword.getText() ;
        String ExpCredentials = "Invalid credentials";
        Assert.assertEquals(ExpCredentials, ActualCredentials );
        System.out.println( " Can't Access with invalid Password : " + ExpCredentials);


    }






}
