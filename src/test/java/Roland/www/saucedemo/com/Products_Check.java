package Roland.www.saucedemo.com;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Products_Check extends Hooks {


    String baseUrl = "https://www.saucedemo.com/";

    @Test
    public void products_Check_AddTo_Cart (){


        driver.get(baseUrl); // Launch the Url https://www.saucedemo.com/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit Wait 10s



        // Capture , clear and typing Username
        WebElement Username = driver.findElement(By.xpath("//input[@id='user-name']"));
        Username.clear(); // clear everything before type
        Username.sendKeys("standard_user"); // Type standard_user

        // Print Value
        System.out.println(" Typing the : " + Username.getAttribute("placeholder") + ": standard_user");

        // Capture , clear and typing Password

        WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
        Password.clear();// clear everything before type
        Password.sendKeys("secret_sauce");// Type secret_sauce
        System.out.println(" Typing the : " + Password.getAttribute("placeholder") + ": secret_sauce");


// verification of Login and click

        WebElement Login_btr = driver.findElement(By.xpath("//input[@id='login-button']"));
        System.out.println("Login Button is-Displayed ? :" + Login_btr.isDisplayed());  // True

        WebDriverWait waitLogin_btr = new WebDriverWait(driver, Duration.ofSeconds(10));

        Login_btr = waitLogin_btr.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-button']")));
        Login_btr.click(); // Click on Login Button
//  System.out.println(" Click to the : " + Login_btr.getAttribute("value"));




        // Assertion to verify , if we are on Products_Page
        WebElement Products = driver.findElement(By.xpath("//span[@class='title']"));
        System.out.println( "Is the Products Menu Is_Displayed ? : " + Products.isDisplayed());

        if (Products.isDisplayed()) // If condition for double Verification
        {
            System.out.println(" Assert Passed .  .  .  Products Menu "); //  After verification with the Assertion from the WebApp and print

        }

            // Verify number of products available on WebApp
        List<WebElement> All_img  = driver.findElements(By.xpath("//div[@id=\"inventory_container\"]//div[@class=\"inventory_item_img\"]"));
        System.out.println("Number of products available is : " + All_img.size());


        // Verify number of products price bar available on WebApp
        List<WebElement> pricebar  = driver.findElements(By.xpath("//div[@class=\"pricebar\"]//div"));
        System.out.println("Number of products available is : " + pricebar.size());
        System.out.println("Number of products available is : " + pricebar.contains("Add to cart"));


        List<WebElement> inventory_item_name = driver.findElements(By.xpath("//div[@class=\"inventory_item_name \"]"));
        System.out.println("inventory_item_name size is : "  +  inventory_item_name.size()); // Check all size of products name
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click(); // Click on Sauce Labs Backpack Product

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        System.out.println("Current Url is : " + driver.getCurrentUrl()); // New Url after click

        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"))
                .isDisplayed(); // Verify ,if image is displayed

        WebElement product_Name = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));
        System.out.println("Product name is : " +  product_Name.getText());


        // Explicit wait before click on Add to cart
        WebElement btr = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        btr =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")));
        btr.click();

        driver.navigate().refresh();

        // Click on shopping_cart_badge
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        System.out.println("Current Url is : " + driver.getCurrentUrl()); // New Url after click

        driver.findElement(By.xpath("//button[@id='checkout']")).click(); // Click on Checkout button
        driver.findElement(By.id("last-name")).sendKeys("Roland"); // Type Last Name
        driver.findElement(By.id("first-name")).sendKeys("John");  // First Name

        driver.findElement(By.id("postal-code")).sendKeys("00237");// Enter postal-code

        driver.findElement(By.xpath("//input[@id='continue']")).click();
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        WebElement Checkout_Status = driver.findElement(By.xpath("//span[@class='title']"));
        String Actual =Checkout_Status.getText();
        Assert.assertEquals(Actual , "Checkout: Complete!");
        System.out.println(" Assert Passed .  .  . " ); //  After verification with the Assertion from the WebApp and print

        driver.findElement(By.xpath("//img[@alt='Pony Express']")).isDisplayed();

        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
        System.out.println(" Home Page Url is " + driver.getCurrentUrl());

        // Logout from the WebApp
        WebDriverWait wait_time = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement Menu_Button = wait_time.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-burger-menu-btn")));

    }

//
//@Test
//public void close_quit (){
//   // Logout from the WebApp
//
// WebElement Menu = driver.findElement(By.cssSelector("#react-burger-menu-btn"));
//
// WebDriverWait wait_time = new WebDriverWait(driver,Duration.ofSeconds(10));
// WebElement Menu_Button = wait_time.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-burger-menu-btn")));
//
// Menu.click();
//
//
//  driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
//
//
// driver.close();
// driver.quit();
//
//}





}
