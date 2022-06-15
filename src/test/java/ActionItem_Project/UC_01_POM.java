package ActionItem_Project;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class UC_01_POM extends Reusable_Annotations_Class {

    //UC_01:As a customer, I want to enter a zip code, so that I can find a branch
    @Test(priority = 1)
    public void EnterZipCode(){
        driver.navigate().to("https://www.schwab.com");
        BaseClass.schwabHomePage().clickFindABranch();
        BaseClass.schwabFindABranchPage().enterZipCity("11218");
        BaseClass.schwabFindABranchPage().clickButton();

    }//end of test 1

    @Test(dependsOnMethods = "EnterZipCode")
    public void CaptureBranchName(){
        BaseClass.schwabFindABranchPage().captureBranchNameAndPrintIt();
    }//end of Test 2


}//end of java class
