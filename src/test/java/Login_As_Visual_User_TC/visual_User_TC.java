package Login_As_Visual_User_TC;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import screenhot.Full_screenshot;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class visual_User_TC extends Hooks {


    @Test
    public void login() throws InterruptedException, IOException, AWTException {
        Visual_User_Tc_Pom visual = new Visual_User_Tc_Pom(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        //Inputs user name
        visual.setUserName("visual_user");

        //Inputs password
        visual.setPassword("secret_sauce");

        //clicks login button
        visual.setLoginButton();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title")));
        //Get the product text
        visual.setProductElement();
        System.out.println("Product displayed");
        // System.out.println(productText);

        //visual.setVerificationPoint();
        System.out.println();
        // driver.findElement(By.cssSelector("aa[id='item_4_title_link'] div[class='inventory_item_name"));

        //Verifying presence of Bull Dog Element
        visual.setBullDogImage();
        System.out.println("Image is displayed");

        // visual.setBackPackImg();
        // System.out.println("Pack is displayed");

        //Validate the price tag value
        wait.until(ExpectedConditions.visibilityOf(visual.priceTag));
        visual.setPriceTag();

        //Validate Item description
        visual.itemDesc.isDisplayed();
        String itemDescriptionText = visual.itemDesc.getText();
        System.out.println(itemDescriptionText);
        Assert.assertEquals(itemDescriptionText,"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        System.out.println("Description Text displayed");




        //Validating ADD to cart button
        wait.until(ExpectedConditions.elementToBeClickable(visual.addToCartButton));
        System.out.println("Element is clickable");
        visual.shoppingCart.isDisplayed();
        visual.shoppingCart.click();
        visual.continueShopping.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(visual.continueShopping)).click();
        System.out.println("Back to shopping");

        //Add and Remove element to cart
        visual.addToCartButton.click();
        Thread.sleep(1000);
        visual.shoppingCart.click();
        wait.until(ExpectedConditions.visibilityOf(visual.removeEle)).click();
        System.out.println("Element is has been removed");
        visual.continueShopping.click();


        //Locate and validate Bike Element
        visual.bikeImage.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(visual.bikeImage));
        visual.bikeImage.click();
        driver.navigate().back();

        wait.until(ExpectedConditions.elementToBeClickable(visual.inventoryElement));
        String inventoryTitle = visual.inventoryElement.getText();
       assert  inventoryTitle.equals("Sauce Labs Bike Light");
        System.out.println("Title displayed");
        visual.inventoryElement.click();




        String bikeTitle = visual.bikeItemTitle.getText();
        Assert.assertEquals(bikeTitle, "Sauce Labs Bike Light");
       // assert bikeTitle.equals("Sauce Labs Bike Light");
        visual.bikeImage.click();



        Full_screenshot.fullScreenshot();



/*
        Thread.sleep(2000);
        Boolean removeButton = visual.removeEle.isDisplayed();



        if (visual.removeEle.isDisplayed()){
            visual.removeEle.click();
            driver.navigate().back();
        }else {
            Thread.sleep(1000);
            driver.navigate().back();
            System.out.println("This nav executed");


        }

 */


        /*

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./LoginPage_screenshot.png"));
        //screenshot an element
        WebElement loginButtom = driver.findElement(By.id("login-button"));
        scrFile = loginButtom.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./screenshots/loginButton.png"));

         */




    }


}
