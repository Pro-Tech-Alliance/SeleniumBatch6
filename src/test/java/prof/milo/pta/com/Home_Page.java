package prof.milo.pta.com;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Home_Page extends Hooks {
    @Test
    public void homePage(){
///verifying we are on the home page using the welcome text element located by xapth
        //Explixit Wait
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//*[@id=\"block-2901c6d2976a18d1f38d\"]/div/div/h1")));
        String welcomeText=element.getText();
        System.out.println(welcomeText);
        Assert.assertEquals(welcomeText,"START YOUR CAREER WITH A LEAP");

        //verify the service button
        driver.findElement(new By.ByXPath("/html/body/div[1]/main/article/section[1]/div[2]/div/div/div/div[4]/div/div/div/a"))
                .click();
        String currentURL = driver.getCurrentUrl();
        String pageTitle = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://www.pro-techalliance.com/services");
        Assert.assertEquals(pageTitle,"Services — Pro-Tech Alliance");


    }
}
