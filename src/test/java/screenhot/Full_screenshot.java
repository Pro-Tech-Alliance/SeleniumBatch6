package screenhot;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Full_screenshot extends Hooks {
    @Test
    public static void fullScreenshot() throws IOException, AWTException {

        File scrFile = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./FullScreen_LoginPage_screenshot.png"));



        }











    }






