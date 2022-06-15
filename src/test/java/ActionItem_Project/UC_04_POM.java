package ActionItem_Project;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class UC_04_POM extends Reusable_Annotations_Class {
    //UC_04:As a user, I want to be able to see if anything was entered, so that I can find a branch

    @Test(priority = 1)
    public void EnterBlank() {
        driver.navigate().to("https://www.schwab.com");
        BaseClass.schwabHomePage().clickFindABranch();
        BaseClass.schwabFindABranchPage().enterZipCity("");
        BaseClass.schwabFindABranchPage().clickButton();

    }//end of test 1

    @Test(dependsOnMethods = "EnterBlank")
    public void CaptureBranchName() {
        BaseClass.schwabFindABranchPage().captureErrorAndPrintIt();

    }//end of Test 2

}//end of java class
