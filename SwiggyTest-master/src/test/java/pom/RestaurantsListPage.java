package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RestaurantsListPage {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    public RestaurantsListPage(WebDriver driver, ExtentReports report, ExtentTest test) {
        this.driver = driver;
        this.report = report;
        this.test = test;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id='open_filter']//a[contains(@href , '#filter_')]")
    List<WebElement> filterRestaurants;

    @FindBy(xpath = "//div[@id='root']/div[1]/div[1]/div/div/div[2]/div[2]")
    List<WebElement> listOfRestaurants;

    @FindBy(xpath = "//*[text()[contains(.,'Bite Me')]]//ancestor::a")
    WebElement FavoutiteRestuarant;

    @FindBy(xpath = "//*[text()[contains(.,'outlets near you')]]/parent::div/following-sibling::div/a")
    List<WebElement> listOfOutlets;

    //This will click the first available restaurant in current selected location
    public void clickOnFirstAvailableRestaurant() {
        for (int i = 0; i<listOfRestaurants.size(); i++){
            if (listOfRestaurants.get(i).equals(filterRestaurants.get(i))){
                listOfRestaurants.get(i).click();
                test.log(LogStatus.INFO, "Clicked on Restaurant");
                break;
            }

        }
    }
    
    public void clickOnMySearchedRestaurant(String restaurantName) {
       
            if (FavoutiteRestuarant.getText().contains(restaurantName)){
            	FavoutiteRestuarant.click();
                test.log(LogStatus.INFO, "Clicked on Restaurant");
                
            }

        }
    


    //This will click the first outlet from the given multiple outlets
    public void clickOnFirstOutlet(){
        listOfOutlets.get(0).click();
    }

    

}
