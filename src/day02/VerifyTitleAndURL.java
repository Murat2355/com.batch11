package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class VerifyTitleAndURL {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Casper\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().window().maximize();

        String actualResult = driver.getTitle();
        String expectedResult = "google";

        if (actualResult.equals(expectedResult)){
            System.out.println("Page Title testi PASS");
        }else{
            System.out.println("Page Title testi FAILED");
            System.out.println("Actual Page Title : actualResult ");
        }


        driver.navigate().to("https://youtube.com");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "wwww.youtube.com";
        if (actualURL.equals(expectedURL)){
            System.out.println("URL testi Pass");
        }else{
            System.out.println("URL testi FAILED");
            System.out.println("Actual URL : +actualURL");
        }
        driver.close();


    }
}
