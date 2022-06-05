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

public class UC_06 {
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

    //UC_13:As a user, I want to see complimentary workshops, so that I may attend one for my financial interests
    @Test(priority = 1)
    public void FindWorkshop() {
        logger = reports.startTest("EnterZipCode");
        driver.navigate().to("https://www.schwab.com");
        //click on find a branch
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()='Find a Branch']", logger, "Find a branch");
        //click on complimentary workshop page
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='find-workshops']",logger,"Click on workshop");
        //enter zip code
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@id='searchworkshops']","11218",logger,"Zip Code");
        //click on find button
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='localbtn submit']",logger,"Find button");

        reports.endTest(logger);

    }//end of test 1

    //capture first workshop
    @Test(dependsOnMethods = "FindWorkshop")
    public void CaptureWorkshopName(){
        logger= reports.startTest("CaptureWorkshop");
        String result = Reusable_Actions_Loggers.getTextAction(driver,"//*[@class='event-location']",logger,"Workshop name");
        System.out.println("Workshop is " + result);
        logger.log(LogStatus.INFO,"Workshop is " + result);

        reports.endTest(logger);

    }//end of test 2

    //verify title of page using reusable verifyTitle method
    @Test(dependsOnMethods = "CaptureWorkshopName")
    public void VerifyTitle(){
        logger= reports.startTest("VerifyTitle");
        Reusable_Actions_Loggers.verifyTitle(driver,logger,"Seminars on Finance, Retirement, Investing, and Trading | Charles Schwab");

        reports.endTest(logger);

    }//end of test 3

    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of after suite


}//end of java class
