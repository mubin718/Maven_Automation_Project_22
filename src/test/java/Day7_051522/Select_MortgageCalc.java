package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_MortgageCalc {
    public static void main(String[] args) throws InterruptedException {
        //call chromedriver with manager
        WebDriverManager.chromedriver().setup();
        //setup chrome options arguments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        //go to mortgagecalculator site
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
        //select start month fom the dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define select command
        //Select dropDown = new Select(startMonth);
        //select by visible text
        //dropDown.selectByVisibleText("Jun");

        //clicking on dropdown and its value if the dropdown tag is not under select tag
        startMonth.click();
        //click on the value of the start month
        driver.findElement(By.xpath("//*[text()='Jun']")).click();


        //select loan type from dropdown
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        //define select command
        //Select loanTypeDropdown = new Select(loanType);
        //select by visible text
        //loanTypeDropdown.selectByVisibleText("FHA");

        loanType.click();
        driver.findElement(By.xpath("//*[text()='FHA']")).click();


    }//end of main method
}//end of java class
