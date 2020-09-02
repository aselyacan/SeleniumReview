import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

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
    public void isDisplayed(){
            driver.get("http://the-internet.herokuapp.com/dynamic_controls");
            //*[.="Dynamic Controls"]
            //h4
            WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));

            boolean gorunuyorMu = baslik.isDisplayed(); // true false
            System.out.println("Gorunuyor mu : " + gorunuyorMu);




    }

    @Test
    public void isSelected(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement secimELement=driver.findElement(By.xpath("//input[@type='checkbox']"));

        //eger bir webelement seciliyse True , degilse  false return eder
        boolean seciliMi1=secimELement.isSelected();
        System.out.println("Secili mi :"+seciliMi1);


        secimELement.click();
        boolean seciliMi2=secimELement.isSelected();
        System.out.println("Secili mi :"+seciliMi2);

        if (secimELement.isSelected()){
            // eğer seçili ise burayı
            System.out.println("Lutfen secim yapiniz");
            secimELement.click();
        }else {
            // değilse burayı kullanırsınız.
            System.out.println("zaten secili ...");
        }


    }

    @Test
    public void isEnable(){

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputKutusu=driver.findElement(By.xpath("//input[@type='text']"));

        boolean aktifMi=inputKutusu.isEnabled();//true oder false== burada false cikti cunku  tiklanmadi

        System.out.println("Aktif mi :"+aktifMi);


        // butona tiklanma yapildi
        WebElement enableButtonu=driver.findElement(By.xpath("//*[.='Enable']"));
        enableButtonu.click();

        // java codelari calisirken , istediginiz satirda  istedgimiz saniye kadar bekletebiliriz
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean   aktifMi2=inputKutusu.isEnabled();
        System.out.println("Aktif mi 2: "+aktifMi2);

    }

}
