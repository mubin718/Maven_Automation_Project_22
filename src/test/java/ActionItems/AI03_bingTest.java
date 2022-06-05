package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI03_bingTest {
    public static void main(String[] args) throws InterruptedException {
        //call chromedriver with manager
        WebDriverManager.chromedriver().setup();
        //setup chrome options arguments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        //capture search number and print following hobbies using for loop with bing.com
        ArrayList<String> hobby = new ArrayList<>();
        hobby.add("playing golf");
        hobby.add("soccer");
        hobby.add("playing baseball");
        hobby.add("hockey");
        hobby.add("playing basketball");

        for (int i = 0; i < hobby.size(); i++) {
            //go to bing
            driver.navigate().to("https://www.bing.com");
            Thread.sleep(3000);
            //locate element for search field and type keyword for each hobby
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobby.get(i));
            //submit on bing
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
            Thread.sleep(3000);
            //capture the bing search and print it
            String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            String[] arrayResult = searchResult.split(" ");
            System.out.println("My search number for the hobby of " + hobby.get(i) + " is " + arrayResult[0]);


        }//end of for loop

        //quit driver
        driver.quit();

    }//end of main method

}//end of java class
