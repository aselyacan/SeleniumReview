import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {

    // 1. Amazon.com'a gideceğiz.
// 2. Arama kutusuna "baby stroller"
// 3. 2. Sıradaki ürüne tıklayacağız.
// 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
// 5. Ürünün ortalama puanını (5 üzerinden) alacağız.

    @Test
    public void amazonTest1(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http:amazon.com");

        WebElement serchBox=driver.findElement(By.id("twotabsearchtextbox"));
        serchBox.sendKeys("baby stroller");
        serchBox.submit();

        WebElement ikinciUrun=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikinciUrun.click();
       // WebElement toplamIkicinciFiyat=driver.findElement(By.xpath("/html/body/div[7]/div/div[1]/div/table/tbody/tr[5]/td[3]/span"));
       // System.out.println(toplamIkicinciFiyat.getText());
       //tem.out.println(ortalamaPuan.getText());

        driver.navigate().to("http:google.com");
        WebElement googleSearch=driver.findElement(By.name("q"));
        googleSearch.sendKeys("Kemal Ozden");
        googleSearch.submit();
        WebElement resultat=driver.findElement(By.id("result-stats"));
        System.out.println(resultat.getText());



    }



}
 