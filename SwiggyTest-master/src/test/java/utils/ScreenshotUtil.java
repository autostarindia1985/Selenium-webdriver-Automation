package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + ".png";
        String directory = "c:\\temp\\";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = directory + fileName;
        File destinationFile=new File(destination);
        //FileUtils.copyFile(sourceFile, destinationFile);
        FileUtils.copyFile(sourceFile, new File("c:\\tmp\\screenshot.png"));

        return destination;
    }
    
    public static void takeScreenshot1(WebDriver driver, String fileName) throws IOException {
    	//Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileName);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
    }
}