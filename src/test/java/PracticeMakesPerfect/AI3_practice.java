package PracticeMakesPerfect;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AI3_practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> hobby = new ArrayList<>();
        hobby.add("playing golf");
        hobby.add("soccer");
        hobby.add("playing baseball");
        hobby.add("hockey");
        hobby.add("playing basketball");

        for (int i = 0; i < hobby.size(); i++) {
            driver.navigate().to("https://www.bing.com");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobby.get(i));
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
            Thread.sleep(3000);
            String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //String[] arrayResult = searchResult.split(" ");
            //System.out.println("My search number for the hobby of " + hobby.get(i) + " is " + arrayResult[0]);
            String sub1 = searchResult.substring(0, 10);
            //int sub1 = searchResult.indexOf(' ',0);

            System.out.println("My search number for the hobby of " + hobby.get(i) + " is " + sub1);


        }//end of for loop

    }//end of main method

}//end of java class
