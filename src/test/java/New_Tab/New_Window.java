package New_Tab;


import base.Hooks;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class New_Window extends Hooks {
    @Test
    public void newWindow(){

        driver.switchTo().newWindow(WindowType.WINDOW);//switch to the new tab
        driver.navigate().to("https://www.pro-techalliance.com/");//after switching to the new tab...navigate to this url

    }

}
