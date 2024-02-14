package Roland.www.saucedemo.com;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login_Page extends Hooks {
String baseUrl = "https://www.saucedemo.com/";
@Test
 public void home_Page_Verification (){

 driver.get(baseUrl); // Launch the Url https://www.saucedemo.com/
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit Wait 10s

 System.out.println("Our Current Url is : " + driver.getCurrentUrl()); // Get Url from the WebApp and print it
 System.out.println("Our Current Title is : " + driver.getTitle()); // Get The Title from the WebApp and print

String Actual_Url = driver.getCurrentUrl(); // Declare Actual_Url and assigned value
String Expected_Url = "https://www.saucedemo.com/"; // Declare Expected_Url and assigned value

 Assert.assertEquals( Actual_Url,  Expected_Url );
 if (Expected_Url.equals(Actual_Url))
 {
  System.out.println(" Assert Passed .  .  .  Current Url " ); //  After verification with the Assertion from the WebApp and print

 }


 String Actual_Title = driver.getTitle(); // Declare Actual_Title and assigned value
 String Expected_Title = "Swag Labs"; // Declare Expected_Title and assigned value

 Assert.assertEquals( Actual_Title,  Expected_Title );
 if (Expected_Title.equals(Actual_Title)) // If condition for double Verification
 {
  System.out.println(" Assert Passed .  .  .  Current Title " ); //  After verification with the Assertion from the WebApp and print

 }

 // List  all login_credentials below
List<WebElement> login_credentials =  driver.findElements(By.xpath("//div[@class='login_credentials_wrap-inner']//div[@id=\"login_credentials\"]//br"));

 System.out.println("How many Login credentials we have : ? . . ." + login_credentials.size());

 for(WebElement e : login_credentials) {
  System.out.println(e.getText());
 }


WebElement Accepted_Username =driver.findElement(By.xpath("//div[@id='login_credentials']//h4[1]"));
 System.out.println( Accepted_Username.getText()+ " standard_user " );




}


 @Test
 public void login_With_Invalid_Password (){

  // Capture , clear and typing Username
  WebElement Username = driver.findElement(By.xpath("//input[@id='user-name']"));
  Username.clear(); // clear everything before type
  Username.sendKeys("standard_user"); // Type standard_user

  // Print Value
  System.out.println(" Typing the : "  + Username.getAttribute("placeholder") + ": standard_user");

  // Capture , clear and typing Password

  WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
  Password.clear();// clear everything before type
  Password.sendKeys("secret_s1987ce");// Type secret_sauce
  System.out.println(" Typing the : "  + Password.getAttribute("placeholder")+ ": secret_sauce");



// verification of Login and click

  WebElement Login_btr = driver.findElement(By.xpath("//input[@id='login-button']"));
  System.out.println("Login Button is-Displayed ? :" +  Login_btr.isDisplayed());  // True

  WebDriverWait waitLogin_btr = new WebDriverWait(driver, Duration.ofSeconds(10));

  Login_btr=waitLogin_btr.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-button']")));
  Login_btr.click(); // Click on Login Button
  System.out.println(" Click to the : "  + Login_btr.getAttribute("value"));


 }



 @Test
 public void login_With_Invalid_Username (){

  // Capture , clear and typing Username
  WebElement Username = driver.findElement(By.xpath("//input[@id='user-name']"));
  Username.clear(); // clear everything before type
  Username.sendKeys("standard_2098er"); // Type standard_user

  // Print Value
  System.out.println(" Typing the : "  + Username.getAttribute("placeholder") + ": standard_user");

  // Capture , clear and typing Password

  WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
  Password.clear();// clear everything before type
  Password.sendKeys("secret_sauce");// Type secret_sauce
  System.out.println(" Typing the : "  + Password.getAttribute("placeholder")+ ": secret_sauce");



// verification of Login and click

  WebElement Login_btr = driver.findElement(By.xpath("//input[@id='login-button']"));
  System.out.println("Login Button is-Displayed ? :" +  Login_btr.isDisplayed());  // True

  WebDriverWait waitLogin_btr = new WebDriverWait(driver, Duration.ofSeconds(10));

  Login_btr=waitLogin_btr.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-button']")));
  Login_btr.click(); // Click on Login Button
  System.out.println(" Click to the : "  + Login_btr.getAttribute("value"));


 }


 @Test
 public void login_With_Valid_Credentials () {

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
   System.out.println(" Assert Passed .  .  .  Products Menu " ); //  After verification with the Assertion from the WebApp and print

  }



   //Logout from the WebApp

  driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
  driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();

 }



// @Test
// public void logOut (){
//
//  // Logout from the WebApp
//
//  driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
//  driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
//
// }


}
