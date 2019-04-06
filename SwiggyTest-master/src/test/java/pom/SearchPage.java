package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    public SearchPage(WebDriver driver, ExtentReports report, ExtentTest test){
        this.driver = driver;
        this.report = report;
        this.test = test;
        PageFactory.initElements(driver, this);

    }
    
    @FindBy(linkText = "Search")
    WebElement Searchicon;

    @FindBy(css = ".\\_2BJMh")
    WebElement SearchBox;
    
    public void SearchRestaurant(String RestaurantName)
    {
    	Searchicon.click();
    	SearchBox.sendKeys(RestaurantName);
    	
    }
}