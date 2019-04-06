package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RestaurantsPage {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    WebDriverWait wait;

    public RestaurantsPage(WebDriver driver, ExtentReports report, ExtentTest test) {
        this.driver = driver;
        this.report = report;
        this.test = test;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    
    
    @FindBy(xpath = "//div[text()[contains(.,'ADD')]]/parent::div")
    List<WebElement> addBtn;

    @FindBy(xpath = "//*[text()[contains(.,'Customisable')]]/parent::div") 
            List<WebElement> customizableAddBtn;
    
    @FindBy(xpath = "//div[2]/div/div[2]/div/div/div[3]/div[2]/div[2]") 
    WebElement addmoreBtn;

    @FindBy(xpath = "//span[text()[contains(.,'Add Item')]]/parent::div")
    WebElement addItemBtn;

    @FindBy(xpath = "//div[text()[contains(.,'Checkout')]]")
    WebElement checkOutBtn;

    // This will add food item that do not have an option of customization
    public void clickOnAddFoodItem() {
        	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*div[text()[contains(.,'ADD')]]/parent::div")));
    	      addBtn.get(0).click();
    	      addmoreBtn.click();
    	      addBtn.get(2).click();
    	      addBtn.get(5).click();
    	      addBtn.get(7).click();  	      
        	 test.log(LogStatus.INFO, "Added Food item to Card");
             
           
    }

   
    public void clickOnCheckoutBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Checkout')]")));
        checkOutBtn.click();
        test.log(LogStatus.INFO, "Clicked on Checkout");
    }

    public void addFoodItemAndCheckout() {
        clickOnAddFoodItem();
        clickOnCheckoutBtn();
    }

   

}
