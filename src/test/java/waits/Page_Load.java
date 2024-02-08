package waits;

import base.Hooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class Page_Load extends Hooks {
@Test
  public void loginPage(){

      driver.get("https://www.facebook.com/");
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("JBL Speaker");
      driver.findElement(By.id("nav-search-submit-button")).click();

  }

}
