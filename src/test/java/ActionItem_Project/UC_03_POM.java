package ActionItem_Project;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class UC_03_POM extends Reusable_Annotations_Class {
    //UC_03:As an investor, I want to enter a state, so that I can find a branch

    @Test(priority = 1)
    public void EnterState() {
        driver.navigate().to("https://www.schwab.com");
        BaseClass.schwabHomePage().clickFindABranch();
        BaseClass.schwabFindABranchPage().enterZipCity("New York");
        BaseClass.schwabFindABranchPage().clickButton();

    }//end of test 1

    @Test(dependsOnMethods = "EnterState")
    public void CaptureBranchName() {
        BaseClass.schwabFindABranchPage().captureBranchNameAndPrintIt();

    }//end of Test 2

}//end of java class
