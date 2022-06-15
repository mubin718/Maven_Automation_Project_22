package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchwabFindABranchPage extends Reusable_Annotations_Class {

    ExtentTest logger;

    public SchwabFindABranchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;

    }//end of constructor method

    @FindBy(xpath = "//*[@id='txtAddr']")
    WebElement enterZipCityState;

    @FindBy(xpath= "//*[@id='btn_loc']")
    WebElement clickLocateButton;

    @FindBy(xpath= "//*[@class='address']")
    WebElement branchName;

    @FindBy(xpath="//*[@class='error-content']")
    WebElement errorMessage;

    @FindBy(xpath="//*[@title='Share by Email']")
    WebElement clickEmailButton;

    @FindBy(xpath="//*[@id='sender_name']")
    WebElement enterNameForEmail;

    @FindBy(xpath="//*[@id='sender_email']")
    WebElement enterUserEmail;

    @FindBy(xpath="//*[@id='recipients']")
    WebElement enterRecipientEmail;

    public void enterZipCity(String uservalue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver,enterZipCityState,uservalue,logger,"Enter ZipCityState");

    }//end of enter zip/city/state method

    public void clickButton(){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickLocateButton,logger,"Click on Locate Button");

    }//end of click locate button method

    public void captureBranchNameAndPrintIt(){
        String result = Reusable_Actions_POM_Loggers.getTextAction(driver,branchName,logger,"Branch Name");
        System.out.println("Branch name is " + result);

    }//end of capture

    public void captureErrorAndPrintIt(){
        String result = Reusable_Actions_POM_Loggers.getTextAction(driver,errorMessage,logger,"Error Message");
        System.out.println("Error message is " + result);

    }//end of capture error method

    public void clickEmail(){
        Reusable_Actions_POM_Loggers.clickAction(driver,clickEmailButton,logger,"Click Email Button");
    }//end of click email button method

    public void enterEmailName(String uservalue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver,enterNameForEmail,uservalue,logger,"Email Name");
    }//end of click email name method

    public void enterUserEmail(String uservalue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver,enterUserEmail,uservalue,logger,"Email Username");
    }//end of enter user email method

    public void enterRecipient(String uservalue){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver,enterRecipientEmail,uservalue,logger,"Recipient Email");
    }//end of enter recipient email


}//end of java class
