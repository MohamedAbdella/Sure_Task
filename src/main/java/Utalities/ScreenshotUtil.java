package Utalities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Generate a timestamp to avoid overwriting files
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // Take the screenshot
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Define the destination where the screenshot will be saved
            String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + timestamp + ".png";
            // Copy the screenshot to the destination
            FileUtils.copyFile(source, new File(destination));
            System.out.println("Screenshot taken: " + destination);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
