package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    public WebDriver driver;
@BeforeTest
    public void setup() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/config.properties");
        properties.load(file);

        String browserType = properties.getProperty("browser").toLowerCase().trim();
        String url = properties.getProperty("baseUrl").trim();
        String operatingSystem = properties.getProperty("operatingSystem").trim();

        switch (browserType){

            case "chrome":
                if (operatingSystem.equals("windows")){
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/windows/chromedriver.exe");
                } else if (operatingSystem.equals("macOs")) {
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/macOS/chromedriver");
                }
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                if (operatingSystem.equals("windows")){
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/java/drivers/windows/geckodriver.exe");
                } else if (operatingSystem.equals("macOs")) {
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/java/drivers/macOS/geckodriver");
                }
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/main/java/drivers/msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new EdgeDriver(edgeOptions);
                break;
        }
                driver.get(url);
                driver.manage().window().maximize();

    }
@AfterTest
    public void tearDown(){
        //driver.quit();
}


}
