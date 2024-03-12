package screenhot;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Full_screenshot extends Hooks {
    @Test
    public static void fullScreenshot() throws IOException {
        File scrFile = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./FullScreen_LoginPage_screenshot.png"));
    }
    @Test
    public static void fullPageScreenshot() throws IOException {
        // Take a full-page screenshot
//        Screenshot screenshot = new AShot().takeScreenshot(driver);ShootingStrategies
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(2f), 1000)).takeScreenshot(driver);

//                takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File("./screenshots/FullPage_Screenshot.png"));

    }
}
