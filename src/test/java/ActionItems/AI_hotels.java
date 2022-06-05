package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AI_hotels {
    public static void main(String[] args) throws InterruptedException {

        //call chromedriver with manager
        WebDriverManager.chromedriver().setup();
        //setup chrome options arguments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        //go to fideliscare site
        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(3000);

        //type your destination on search field
        try{
            WebElement searchField = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
            //searchField.clear();
            searchField.click();
            WebElement searchFieldEnter = driver.findElement(By.xpath("[@id='location-field-destination']"));
            searchFieldEnter.sendKeys("Florida");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unable to locate search field " + e);
        }//end of search field exception
/*
        //click on first dropdown suggestion link
        try{
            driver.findElements(By.xpath("//*[@data-stid='location-field-destination-result-item-button']")).get(1).click();
        } catch (Exception e) {
            System.out.println("Unable to click first suggested link " + e);
        }//end of first suggested link exception

        //enter check in date on check in field
        try{
            WebElement checkIn = driver.findElement(By.xpath("//*[@id='d1-btn']"));
            checkIn.click();
            WebElement checkInDate = driver.findElement(By.xpath("//*[@aria-label='Jul 4, 2022 selected, current check in date.']"));
            //checkIn.clear();
            //checkIn.sendKeys((CharSequence) checkInDate);
            checkInDate.click();
        } catch (Exception e) {
            System.out.println("Unable to check in date " + e);
        }//end of check in date exception

        //enter check out date on check out field
        try{
            WebElement checkOut = driver.findElement(By.xpath("//*[@id='d2-btn']"));
            checkOut.click();
            WebElement checkOutDate = driver.findElement(By.xpath("//*[@aria-label='Jul 8, 2022 selected, current check out date.']"));
            checkOutDate.click();
        } catch (Exception e) {
            System.out.println("Unable to check out date " + e);
        }//end of check out date exception

 */

    }//end of main method
}//end of java class
