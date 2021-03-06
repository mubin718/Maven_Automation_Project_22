package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) {

        //set up you chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();

        //go to Google home page
        driver.navigate().to("https://www.google.com");
        //maximize the driver
        driver.manage().window().fullscreen(); //for mac use window().fullscreen();
        //locate element for search field and type keyword 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        //submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        //capture the google search and print it
        String searchResult= driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //System.out.println("Result is " + searchResult);
        String[] arrayResult = searchResult.split(" ");
        System.out.println("My search number is " + arrayResult[1]);

        //quit the driver
        driver.quit();

    }//end of main method

}//end of java class
