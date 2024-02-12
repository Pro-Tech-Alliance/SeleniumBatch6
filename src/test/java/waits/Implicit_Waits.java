package waits;

import base.Hooks;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Implicit_Waits extends Hooks {




    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Test
    public void implicit_Wait (){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


        driver.get(baseUrl);


    }




}
