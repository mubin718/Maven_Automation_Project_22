package ActionItems;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class AI05_UHC {
    public static void main(String[] args) throws InterruptedException {

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Kobe");
        firstName.add("Michael");
        firstName.add("Lebron");

        //call for loop
        for (int i = 0; i < firstName.size(); i++) {

            //navigate to uhc
            driver.navigate().to("https://www.uhc.com");

            //verify home page title contains Health Insurance plans
            Reusable_Actions.verifyTitle(driver, "Health insurance plans");

            //click on find a doctor link
            Reusable_Actions.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a Doctor");

            //click on Sign in
            Reusable_Actions.clickAction(driver, "//*[@aria-label='Sign in menu']", "Sign in");

            //click on Medicare Plan?
            Reusable_Actions.clickAction(driver, "//span[text()='Medicare plan?']", "Medicare Plan?");

            //switch to new tab
            Reusable_Actions.switchToTabByIndex(driver, 1);

            //click on Register Now
            Reusable_Actions.clickByIndexAction(driver, "//*[@ng-if='!registrationCTA']", 3, "Register Now");

            //Enter first name


            Reusable_Actions.sendKeysAction(driver, "//*[@id='firstName']", firstName.get(i), "First Name");

            //enter last name
            ArrayList<String> lastName = new ArrayList<>();
            lastName.add("Bryant");
            lastName.add("Jordan");
            lastName.add("James");

            Reusable_Actions.sendKeysAction(driver, "//*[@id='lastName']", lastName.get(i), "Last Name");

            //select birth month by calling selectByText
            ArrayList<String> birthMonth = new ArrayList<>();
            birthMonth.add("August");
            birthMonth.add("February");
            birthMonth.add("December");

            Reusable_Actions.selectDropDown(driver, "//*[@id='dob_month_input']", birthMonth.get(i), "Birth Month");

            //enter birth day
            ArrayList<String> birthDay = new ArrayList<>();
            birthDay.add("24");
            birthDay.add("23");
            birthDay.add("06");

            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_day']", birthDay.get(i), "Birth Day");

            //enter birth year
            ArrayList<String> birthYear = new ArrayList<>();
            birthYear.add("1978");
            birthYear.add("1963");
            birthYear.add("1984");

            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_year']", birthYear.get(i), "Birth Year");

            //enter zip code
            ArrayList<String> zipCode = new ArrayList<>();
            zipCode.add("90004");
            zipCode.add("60007");
            zipCode.add("44101");

            Reusable_Actions.sendKeysAction(driver, "//*[@id='zipCode']", zipCode.get(i), "Zip Code");

            //enter member id
            ArrayList<String> memberId = new ArrayList<>();
            memberId.add("098");
            memberId.add("765");
            memberId.add("4321");

            Reusable_Actions.sendKeysAction(driver, "//*[@id='memberId']", memberId.get(i), "Member Id");

            //click on continue button
            Reusable_Actions.clickAction(driver, "//*[@id='submitBtn']", "Continue button");

            //capture error and print
            String errorMessage = Reusable_Actions.getTextAction(driver, "//*[@id='plainText_error']", "Error message");
            System.out.println("My error message is " + errorMessage);

            driver.close();

            //switch to parent tab
            Reusable_Actions.switchToTabByIndex(driver, 0);

        }//end of for loop


    }//end of main method
}//end of java class