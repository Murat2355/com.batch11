package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsIntro {

    /*
      1. Bir class oluşturun: LocatorsIntro
      2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
         a. http://a.testaddressbook.com adresine gidiniz.
          b. Sign in butonuna basin
         c. email textbox,password textbox, and signin button elementlerini locate ediniz..
         d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
         i. Username : testtechproed@gmail.com
         ii. Password : Test1234!
         e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
         f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
         doğrulayin(verify).
         3. Sayfada kac tane link oldugunu bulun.
      */
// 1. Bir class oluşturun: LocatorsIntro
    // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Casper\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.navigate().to("http://a.testaddressbook.com");


        //b. Sign in butonuna basin
        //<a id="sign-in" class="nav-item nav-link" data-test="sign-in" href="/sign_in">Sign in</a>
        //locater Sign in e gitmek icin:1.yol en cok tercih edilen id ile
        //WebElement signInLinki = driver.findElement(By.id("sign-in"));
        //signInLinki.click();
        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();

        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        emailTextBox.sendKeys("testtechproed@gmail.com");
        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("Test1234!");
        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // i. Username : testtechproed@gmail.com
        //         ii. Password : Test1234!


        WebElement kullaniciAdi=driver.findElement(By.className("navbar-text"));
        if (kullaniciAdi.isDisplayed()){
            System.out.println("kullanici adi testtechproed@gmail.com PASS");
        } else {
            System.out.println("kullanici adi testtechproed@gmail.com FAILED");
        }
        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
        //         doğrulayin(verify).
        WebElement adresLinki = driver.findElement(By.linkText("Addresses"));
        if (adresLinki.isDisplayed()){
            System.out.println("Adres Linki gorundu testi PASS");
        }else{
            System.out.println("Adres Linki gorundu testi FAİLED");
        }
        WebElement signOutText = driver.findElement(By.linkText("Sign out"));
        if (signOutText.isDisplayed()){
            System.out.println("Sign out gorundu testi PASS");
        }else{
            System.out.println("Sign out gorundu testi FAİLED");
        }

        // 3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkListesi =  driver.findElements(By.tagName("a"));
        System.out.println("sayfada " + linkListesi.size() + " adet link var.");

        driver.close();




    }

}
