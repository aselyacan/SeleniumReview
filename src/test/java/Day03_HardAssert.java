import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {



    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Ignore
    public void test1(){
        driver.get("http://amazon.com");
        System.out.println("Title amazon "+driver.getTitle());
        String baslik=driver.getTitle();

       //Hard ASSERT  BU
       // Assert.assertTrue(baslik.contains("kar"));

        // contains - bir string ifadenin içerisinde diğer bir string ifadenin
        //            geçip geçmediğini kontrol ediyordu.
        // "Merhaba Dünya !" -> contains("Dünya") TRUE FALSE
        //Assert kullanma sebebimiz  selnium if else ile butun testleri Pass olarak algiliyor onun icin assert kullaniyor

        if (baslik.contains("kar")){
            System.out.println("Geciyor :"+baslik);
        }else {
            System.out.println("Gecmiyor :"+baslik);
        }

        boolean iceriyorMu= baslik.contains("car");
        Assert.assertTrue(iceriyorMu);//true oldugunu dogrula   ve eger true ise  test dogrudur ...


    }

    @Test
    public void test2(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        // Sayfa başlığında Google kelimesinin geçmemesi durumunu kontrol ediyor.
        // Eğer GOOGLE kelimesi yoksa TEST BAŞARILI.
        // Eğer GOOGLE kelimesi varsa TEST BAŞARISIZ.
        boolean falseMu = baslik.contains("Google");
        Assert.assertFalse(falseMu); // FALSE

        //olumsuz bir durumu test ederken  false
        //olumlu bir durumu test ederken true tercih edilir
    }

    @Test
    public void test3(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        //Assert.assertEquals iki tane degeri esit olup olmagini kontroleder (string,boolean,array, int ...)
        //actual deger ile expected deger ayni mi
        Assert.assertEquals("Amazon.com",baslik);//false

        //bizim beklentimiz  =Amazon.com
        //actual durum= ise  sitede ki durum


    }

    @Test
    public void softAssertTest(){

    }




}
