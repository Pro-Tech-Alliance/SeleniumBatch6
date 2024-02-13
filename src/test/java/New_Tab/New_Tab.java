package New_Tab;

import base.Hooks;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class New_Tab extends Hooks {
    @Test
    public void newTab() throws InterruptedException {
///sdgergthttseh5h5h5
        //rthh
        driver.switchTo().newWindow(WindowType.TAB);//switch to the new tab
        driver.navigate().to("https://www.google.com/");//after switching to the new tab...navigate to this url

    }

}
