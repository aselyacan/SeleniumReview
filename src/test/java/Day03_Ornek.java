import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Ornek {

    // 1. DropDown'da Books kategorisini seçelim.
// 2. Arama kutusuna JAVA yazalım.
// 3. Toplam sonuç sayısını ekrana yazdıralım.
// 4. İlk sıradaki ürüne tıklayalım.
// 5. Back to results linki varsa, testimiz TRUE yoksa FALSE
    //      pass        fail

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get("http://amazon.com");
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);
        System.out.println(select.getOptions().size());

        select.selectByIndex(5);
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("JAVA");
        WebElement submit=driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        // WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //        aramaKutusu.sendKeys("JAVA" + Keys.ENTER);



        WebElement  ilkurun=driver.findElement(By.linkText("Effective Java"));
        ilkurun.click();


        WebElement backToResult=driver.findElement(By.linkText("Back to results"));
       boolean varMi= backToResult.isDisplayed();
        Assert.assertTrue(varMi);// true gelirse  test basarili



    }

}
