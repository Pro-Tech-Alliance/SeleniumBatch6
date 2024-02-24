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
/*
        File scrFile = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./FullScreen_LoginPage_screenshot.png"));

 */

        // Create a Robot instance
        Robot robot = new Robot();

        // Capture the entire screen
        Rectangle screenShotRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenShotImage = robot.createScreenCapture(screenShotRect);

        // Get the URL of the current page
        String currentUrl = driver.getCurrentUrl();

        // Insert the URL text onto the Screenshot Image
        BufferedImage combinedImage = new BufferedImage(screenShotImage.getWidth(), screenShotImage.getHeight() + 20, BufferedImage.TYPE_INT_ARGB);
        combinedImage.createGraphics().drawImage(screenShotImage, 0, 0, null);
        combinedImage.createGraphics().drawString("URL: " + currentUrl, 5, screenShotImage.getHeight() + 15);

        // Save the captured screenshot to a file
        File screenshotFile = new File("./screenshots/full_screen_screenshot.png");
        ImageIO.write(combinedImage, "png", screenshotFile);

        System.out.println("Screenshot captured successfully.");



        }











    }






