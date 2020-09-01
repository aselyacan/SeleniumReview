import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
    public class Day_02_Xpath {

       static  WebDriver driver;

        @BeforeClass
        public static void setUp(){
            WebDriverManager.chromedriver().setup();
            //driver nesnesi olusturduk
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);






        }



        @Test
        public void test1(){

            driver.get("http://a.testaddressbook.com/");
            //
            WebElement signInlinki=driver.findElement(By.linkText("Sign in"));
            signInlinki.click();
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

            List<WebElement> linkler=driver.findElements(By.xpath("//a"));
            for(WebElement  w:linkler){

                System.out.println(w.getText());
         }

            WebElement emailBox=driver.findElement(By.cssSelector(".form-control"));
            WebElement passwordBox=driver.findElement(By.cssSelector("#session_password"));
            WebElement signIn=driver.findElement(By.cssSelector(".btn.btn-primary"));//css de her kelimeden sonra bosluga . konur
            emailBox.sendKeys("testtechproed@gmail.com");
            passwordBox.sendKeys("Test1234!");
            signIn.click();

            WebElement tumyazilar=driver.findElement(By.tagName("body"));
            System.out.println(tumyazilar.getText());


            List<WebElement> kelimeler=driver.findElements(By.xpath("//*"));
            for (WebElement w:kelimeler){
                System.out.println(w.getText());
            }





        }




        //Junit 4.13 ile birlikte before ve AfterClass static olmak zorunda
        @AfterClass
        public static void tearDown(){

          // driver.quit();

        }
    }




