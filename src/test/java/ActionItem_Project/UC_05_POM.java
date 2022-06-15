package ActionItem_Project;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import org.testng.annotations.Test;

public class UC_05_POM extends Reusable_Annotations_Class {
    //UC_07:As a user, I want to share this page via email, so that I can help my family find a branch
    @Test(priority = 1)
    public void EnterZipCode() {
        driver.navigate().to("https://www.schwab.com");
        BaseClass.schwabHomePage().clickFindABranch();
        BaseClass.schwabFindABranchPage().enterZipCity("11218");
        BaseClass.schwabFindABranchPage().clickButton();

    }//end of test 1

    @Test(dependsOnMethods = "EnterZipCode")
    public void shareResults(){
        BaseClass.schwabFindABranchPage().clickEmail();
        BaseClass.schwabFindABranchPage().enterEmailName("Kobe Bryant");
        BaseClass.schwabFindABranchPage().enterUserEmail("kb24@gmail.com");
        BaseClass.schwabFindABranchPage().enterRecipient("mj23@gmail.com");

    }//end of test 2

}//end of java class
