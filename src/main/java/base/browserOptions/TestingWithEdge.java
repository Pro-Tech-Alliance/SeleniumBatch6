package base.browserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class TestingWithEdge {

    public  static void main(String[] arg){

        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/main/java/drivers/msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(("start-maximized"));
        edgeOptions.addArguments("--incognito");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://opensource-demo.orangehrmlive.com");

    }
}
