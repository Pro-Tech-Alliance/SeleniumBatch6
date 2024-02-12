package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Fluent_Wait extends Hooks {

    @Test
    public void fluentWait(){
        // Declare and initialise a fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        //Specify the timeout of the wait
        .withTimeout(Duration.ofSeconds(8))
        //specify polling time
        .pollingEvery(Duration.ofSeconds(2))
        //specify what exceptions to ignore
        .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.id("login-button"));
            }
        });
    }
}
