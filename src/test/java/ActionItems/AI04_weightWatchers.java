package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI04_weightWatchers {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
//set chrome options arguments
        ChromeOptions options = new ChromeOptions();
//set the condition to incognito mode
        options.addArguments("incognito");
//set the condition to maximize/fullscreen your driver
//        options.addArguments("start-maximized");
//for mac use full screen
        options.addArguments("start-fullscreen");
//define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //create zip code array list
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11219");
        zipCode.add("90004");
        zipCode.add("33139");

        for (int i = 0; i < zipCode.size(); i++) {

//navigate to mortgage calculator
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(3000);

            //click on Attend dropdown on top of left of the page
            try {
                WebElement attendDrop = driver.findElement(By.xpath("//*[@data-e2e-name='attend']"));
                attendDrop.click();
            } catch (Exception e) {
                System.out.println("Unable to locate Attend dropdown " + e);
            }//end of Attend dropdown exception

            //click on Unlimited workshops from the dropdown
            try {
                WebElement unlimitedWorkshop = driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']"));
                unlimitedWorkshop.click();
            } catch (Exception e) {
                System.out.println("Unable to locate Unlimited workshops " + e);
            }//end of unlimited dropdown exception

            //on next page click on studio link
            try {
                WebElement studioLink = driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']"));
                studioLink.click();
            } catch (Exception e) {
                System.out.println("Unable to locate Studio Link " + e);
            }//end of studio link exception

            //clear the search field and enter you zip codes
            try {
                WebElement searchField = driver.findElement(By.xpath("//*[@id='location-search']"));
                searchField.clear();
                searchField.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to locate Search Field " + e);
            }//end of search field exception

            //click on search button
            try {
                WebElement searchButton = driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']"));
                searchButton.click();
            } catch (Exception e) {
                System.out.println("Unable to locate Search button " + e);
            }//end of search button exception

            //click on specific link for the studios
            try {
                if (i == 0) {
                    driver.findElements(By.xpath("//*[@class= 'linkContainer-1NkqM']")).get(1).click();
                } else if (i == 1) {
                    driver.findElements(By.xpath("//*[@class= 'linkContainer-1NkqM']")).get(2).click();
                } else if (i == 2) {
                    driver.findElements(By.xpath("//*[@class= 'linkContainer-1NkqM']")).get(0).click();
                }//end of condition

            } catch (Exception e) {
                System.out.println("Unable to locate Studio Links " + e);
            }//end of studio link exception

            //print studio address
            try {
                String studioAddy = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                Thread.sleep(1000);
                System.out.println("The address for the studio is " + studioAddy);
            } catch (Exception e) {
                System.out.println("Unable to locate studio address " + e);
            }//end of print studio address exception

            //scroll to bottom of the page to studio schedule
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                WebElement studioSchedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", studioSchedule);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to locate studio schedule " + e);
            }//end of scroll to bottom of the page to studio schedule exception

            //capture the entire table with all hours/days and print
            try {
                String entireTable = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                Thread.sleep(1000);
                System.out.println("The full available schedule for this location is " + entireTable);
            } catch (Exception e) {
                System.out.println("Unable to locate entire table and print it " + e);
            }//end of capture entire table with all hours/days and print exception


        }//end of for loop


    }//end of main method
}//end of java class
