package screenhot;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class Full_screenshot extends Hooks {
    @Test
    public static void fullScreenshot() throws IOException {
        File scrFile = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./FullScreen_LoginPage_screenshot.png"));

    }
}
