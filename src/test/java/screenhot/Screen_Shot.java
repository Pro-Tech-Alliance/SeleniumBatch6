package screenhot;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screen_Shot extends Hooks {
    @Test
    public static void screeShot() throws IOException {

      //  capture screenshot of the page


        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test*='password']")).sendKeys("secret_sauce");
        //capture reenshot of page
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./LoginPage_screenshot.png"));

        //screen shot an element
        WebElement loginButtom =driver.findElement(By.id("login-button"));
        scrFile = loginButtom.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./loginButton.png"));

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        assert driver.getCurrentUrl().contains("/inventory.html");
       String getProductText= driver.findElement(By.className("title")).getText();
       assert getProductText.equals("Products");

        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./StandardUserLoggedIN_screenshot.png"));


    }
}
