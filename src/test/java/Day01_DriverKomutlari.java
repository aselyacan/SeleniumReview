import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_DriverKomutlari {






    @Test
    public void test1(){

        WebDriverManager.chromedriver().setup();//chrome driver i junit de kurduk
        WebDriver driver=new ChromeDriver(); //chrome driver olusturuldu
        driver.manage().window().maximize();//tam ekran yaptik driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        driver.navigate().back();//sayfadan geri gelmek icin
        driver.navigate().to("http://amazon.com");// bu sayfaya git demek
        driver.navigate().forward();//ileri gider
        driver.navigate().refresh();

        //driver`i kapatmak icin kullanilir
        driver.quit();// tum pencereleri kapatmak icin
        //driver close ise acik olan tek pencereyi kapatmak icin
       // driver.close();

        //sendKeys() bir webelemente yazi gonderme
        //getText() bir webelemenin icerdigi yaziyi  almak icin
        //click() webelemente tiklayabiliriz
        //sumbit() yazilan yaziyi gondermek (bir nevi enter) gorevi  formu gondermek icin html de
        //Keys.ENTER enter butonuna  tiklamak ickn


    }

}
