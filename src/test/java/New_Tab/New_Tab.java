package New_Tab;

import base.Hooks;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class New_Tab extends Hooks {
    @Test
    public void newTab() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);//switch to the new tab


    }

}
