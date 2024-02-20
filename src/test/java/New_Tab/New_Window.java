package New_Tab;

import base.Hooks;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class New_Window extends Hooks {

    @Test
    public void newWindow(){
        driver.switchTo().newWindow(WindowType.WINDOW);//switch to the new window
        driver.navigate().to("https://www.google.com/");// after switching to new window, navigate to this url

    }
}
