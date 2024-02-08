package base.browserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestingWithChrome {

    public  static void main(String[] arg){
//set up the browser driver
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
       /*

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(("start-maximized"));
        chromeOptions.addArguments("--incognito");
*/
        WebDriver driver = new ChromeDriver();//to open the browser


        //writing the test case
       driver.get("https://google.com");//navigate to url
       driver.quit();

    }

}
