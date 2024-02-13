package Ndam.roland.pro_techalliance;

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

        String baseUrl = "https://www.pro-techalliance.com/";
        driver.get(baseUrl);

        System.out.println("Prof Milo now u see the? Current Url :"  + driver.getCurrentUrl());

///verifying we are on the home page using the welcome text element located by xapth
        //Explixit Wait
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//*[@id=\"block-2901c6d2976a18d1f38d\"]/div/div/h1")));
        String welcomeText=element.getText();
        System.out.println(welcomeText);

        Assert.assertEquals(welcomeText,"START YOUR CAREER WITH A LEAP");

        //verify the service button
    WebElement click_services =   driver.findElement(new By.ByXPath("/html/body/div[1]/main/article/section[1]/div[2]/div/div/div/div[4]/div/div/div/a"));
                click_services.click();

WebElement new_url = driver.findElement(By.xpath("//meta[@property='og:url'][1]"));

        String ActualURL = "https://www.pro-techalliance.com/services";

//        String ActualURL = new_url.getAttribute("content");
//        System.out.println("New Url is :" + new_url.getAttribute("content"));
//
        String pageTitle = "Services — Pro-Tech Alliance";
        String Expected_Url = "https://www.pro-techalliance.com/services";
String Expected_Title = "Services — Pro-Tech Alliance";
        Assert.assertEquals(ActualURL,Expected_Url);
        Assert.assertEquals(pageTitle,Expected_Title);
if (ActualURL.equals(Expected_Url)){

    System.out.println(" Url Assert Passed");

}
        if (pageTitle.equals(Expected_Title)){

            System.out.println(" Title Assert Passed");

        }


    }
}
