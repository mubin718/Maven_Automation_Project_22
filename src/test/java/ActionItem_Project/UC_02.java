package ActionItem_Project;

import ReusableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UC_02 {

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

    //UC_02:As a customer, I want to enter a city, so that I can find a branch

    @Test(priority = 1)
    public void EnterCity(){
        logger = reports.startTest("EnterCity");
        driver.navigate().to("https://www.schwab.com");
        //click on find a branch
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()='Find a Branch']", logger, "Find a branch");
        //enter city in search field
        Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='txtAddr']", "NYC", logger, "City");
        //click the city in search field button
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='btn_loc']",logger,"Click on button");
        reports.endTest(logger);

    }//end of test 1

    @Test(dependsOnMethods = "EnterCity")
    public void CaptureBranchName(){
        logger= reports.startTest("Capture the branch name");
        String result = Reusable_Actions_Loggers.getTextAction(driver,"//*[@class='address']",logger,"Branch Name");
        System.out.println("Branch name is " + result);
        logger.log(LogStatus.INFO,"Branch name is " + result);

        reports.endTest(logger);

    }//end of test 2

    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite


}//end of class
