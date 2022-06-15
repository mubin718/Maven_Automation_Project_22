package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchwabHomePage extends Reusable_Annotations_Class {

    ExtentTest logger;

    public SchwabHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;

    }//end of constructor method

    @FindBy(xpath = "//*[text()='Find a Branch']")
    WebElement findABranch;

    public void clickFindABranch() {
        Reusable_Actions_POM_Loggers.clickAction(driver, findABranch, logger, "Click On Find a Branch");
    }//end of click method


}//end of java class
