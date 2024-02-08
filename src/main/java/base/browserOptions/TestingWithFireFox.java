package base.browserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestingWithFireFox {


    public  static void main(String[] arg){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/drivers/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(("--start-maximized"));
        firefoxOptions.addArguments("--incognito");

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();
        driver.quit();
    }


}
