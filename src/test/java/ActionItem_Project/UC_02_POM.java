package ActionItem_Project;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class UC_02_POM extends Reusable_Annotations_Class {
    //UC_02:As a customer, I want to enter a city, so that I can find a branch

    @Test(priority = 1)
    public void EnterCity() {
        driver.navigate().to("https://www.schwab.com");
        BaseClass.schwabHomePage().clickFindABranch();
        BaseClass.schwabFindABranchPage().enterZipCity("NYC");
        BaseClass.schwabFindABranchPage().clickButton();

    }//end of test 1

    @Test(dependsOnMethods = "EnterCity")
    public void CaptureBranchName() {
        BaseClass.schwabFindABranchPage().captureBranchNameAndPrintIt();
    }//end of Test 2


}//end of java class
