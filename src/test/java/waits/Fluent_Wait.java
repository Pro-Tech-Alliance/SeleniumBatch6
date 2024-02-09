package waits;


import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Fluent_Wait extends Hooks {
    @Test
    public  void fluent_wait() {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        // Wait for the username input field to be visible
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        // Insert the username
        usernameInput.sendKeys("standard_user");

        // Wait for the password input field to be visible
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        // Insert the password
        passwordInput.sendKeys("secret_sauce");

        // Locate and click the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginButton.click();

        //Wait for the display of Logo to validate login
        WebElement logoImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo")));
        logoImage.isDisplayed();
        System.out.println();
        System.out.println("You are logged in");




    }

}

