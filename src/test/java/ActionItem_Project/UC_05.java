package ActionItem_Project;

import ReusableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UC_05 {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;


    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html", true);
    }//end of before suite annotation

    //UC_07:As a user, I want to share this page via email, so that I can help my family find a branch

    @Test(priority = 1)
    public void EnterZipCode() {
        logger = reports.startTest("EnterZipCode");
        driver.navigate().to("https://www.schwab.com");
        //click on find a branch
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()='Find a Branch']", logger, "Find a branch");
        //enter zip code in search field
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='txtAddr']", "11218", logger, "Zip code");
        //click the zip code in search field button
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id='btn_loc']", logger, "Click on button");
        reports.endTest(logger);

    }//end of test 1

    @Test(dependsOnMethods = "EnterZipCode")
    public void shareResults() {
        logger = reports.startTest("ShareResult");
        //click on share via email button
        Reusable_Actions_Loggers.clickAction(driver, "//*[@title='Share by Email']", logger, "Click email");
        //enter name in via email dropdown
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='sender_name']","Kobe Bryant", logger, "Email name");
        //enter user email
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='sender_email']","kb24@gmail.com",logger,"Email username");
        //enter recipient email
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='recipients']","mj23@gmail.com",logger,"Recipient email");
        //click on send
        //Reusable_Actions_Loggers.clickAction(driver,"//*[@id='Send']",logger,"Send button");

        reports.endTest(logger);
    }//end of test 2

    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite


}//end of java class
