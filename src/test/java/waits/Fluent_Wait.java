package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Fluent_Wait extends Hooks {
    @Test
    public void loginWithWrongCredentials(){
        //fill input form
        driver.findElement(By.id("user-name")).sendKeys("Neville");
        driver.findElement(By.id("password")).sendKeys("Akwo");
        driver.findElement(By.id("login-button")).click();

        // get error message wrapper
        WebElement errorMessageWrapper = driver.
                findElement(By.cssSelector("#login_button_container .error-message-container"));

        // explicitly wait for errorMessageWrapper to be display
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    errorMessageWrapper.isDisplayed();
                    return true;
                });

        // Verify the displayed text
        String expectedText = errorMessageWrapper.getText();
        String actualText = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expectedText,actualText);
    }


}
