package Login_As_Visual_User_TC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Visual_User_Tc_Pom {

    //User name Element
    WebDriver driver;
    @FindBy(css = "#user-name")
    WebElement userName;

    //Password Element
    @FindBy(css = "[data-test*='password']")
    WebElement password;

    //Login Button
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    //Product Text Element
    @FindBy(css = ".title")
    WebElement productElement;

    //Verification point Element
    @FindBy(linkText = "Sauce Labs Backpack")
    WebElement verificationPoint;

    //BullDogImage Element
    @FindBy(id = "item_4_img_link")
    WebElement bullDogImage;

    //Item Price Tag Element
    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")
    WebElement priceTag;

    //Item description Element
    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    WebElement itemDesc;


    //Item Bull Dg Add to cart button Element
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    //Shopping cart Element
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCart;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeEle;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    @FindBy(id = "item_0_img_link")
    WebElement bikeImage;

    @FindBy(id = "item_0_title_link")
    WebElement bikeItemTitle;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement inventoryElement;


    public Visual_User_Tc_Pom(WebDriver d) {

        driver = d;
        PageFactory.initElements(d, this);

    }

    public void setUserName(String value) {
        userName.sendKeys(value);
    }

    public void setPassword(String value) {
        password.sendKeys(value);
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public void setProductElement() {

        String productText = productElement.getText();
        assert productText.equals("Products");

    }

    public void setVerificationPoint() {
        String text = verificationPoint.getText();
        assert text.equals("Sauce Labs Backpack");

    }

    public void setBullDogImage() throws InterruptedException {
        bullDogImage.isDisplayed();
        bullDogImage.click();
        Thread.sleep(1000);
        driver.navigate().back();

    }

    public void setPriceTag() {
        String price = priceTag.getText();
        assert price.equals("$29.99");
        System.out.println(price);

    }

    public void setAddToCartButton() {
        addToCartButton.isDisplayed();

    }


}
