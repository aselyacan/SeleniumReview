//Selenium Review 2. Ders
//09/01/2020 - Salı
//id, tagName, name, className, linkText, partialLinkText, xpath, cssSelector
//Xpath
//absoulete xpath(bu kullanılmaz) ve relative xpath
//örnk webelement : <input class="deneme" id="deger" />
//1. //input[@class='deneme'];
//   //input[@id='deger']
//   //input
//2. //*[@class='deneme'] : tagName'i farketmeksizin,(attribute : class, value : deneme) tüm webelementleri bul demek.
//<a href="http://google.com">Google Linki</a>
//3. //*[.='Google Linki']
//<div>Merhaba ben webelement</div>
////*[.='Merhaba ben webelement']
////div[.='Merhaba ben webelement']
//4. //*[(text() = 'Google Linki')]
//5. //*[contains(text(),'Linki')]
//   //div[contains(text(),'Linki')]
//1. <div class="deneme" id="deger" placeholder="merhaba" />
//2. <div class="tabindex" id="deger" placeholder="selamlar" />
//or  : ya da
//and : ve
//6. //div[@class='deneme' or @id='deger']
//   //div[@class='deneme' and @id='deger']
//örnek : class="deneme" attributene sahip webelementleri bulun ?
////div[@class='deneme'] -> 1
//örnek : id="deger" attributene sahip webelementleri bulun ?
////div[@id='deger'] -> 1 ve 2
//örnek : id="deger" ya da class="deneme" attributlerine göre arama yapınz
////div[@id='deger' or @class='deneme'] -> 1 ve 2
//örnek : id="deger" ve class="deneme" attirbutelerine sahip webelementi blnz
////div[@id='deger' and @class='deneme']  ->
//7. //div[@id='deger'] -> 1 ve 2
//   (//div[@id='deger'])[2] -> 2. sıradaki webelemente götürür.
//   (//div[@id='deger'])[1] -> 1. sıradaki webelemente götürür.
//***** ÖZELLİKLE BİLİNMESİ GEREKENLER.
//1. //tagName[@attribute='value']
//2. //*[@attribute='value']
//3. //*[.='Yazıya göre arama']
//4. (//tagName[@attribute='value'])[2]
//CSS SELECTOR
//***** XPATH ile CSSSELECTOR FARKI
//En Önemli Fark : İNDEX KULLANARAK BULDUĞUMUZ WEBELEMENTLER ARASINDA GEZİNEMİYORUZ !
//<input type="email" class="form-control" placeholder="Email" data-test="email" name="session[email]" id="session_email">
//Bu webelement kaç farklı şekilde bulunabilir ? :
//By.id        		-> Bulunabilir.. -  By.id("session_email")
//By.name      		-> Bulunabilir.. -  By.name("session[email]")
//By.className		-> Bulunabilir.. -  By.className("form-control")
//By.tagName   		-> Bulunabilir.. -  By.tagName("input")
//By.linkText  		-> BulunaMAZ.... -  <a tagname'i yok.
//By.partialLinkText  -> BulunaMAZ.... -  <a tagname'i yok.
//By.xpath            -> Bulunabilir.. -  By.xpath("//input[@type='email']")
//By.cssSelector      -> Bulunabilir.. -  By.cssSelector("#session_email")
//tagName   : input
//attribute : type, class, placeholder, data-test, name, id
//tagName[attribute='value']
//***** cssSelector'u biz daha çok CLASS ve ID attributelerine göre arama yapmak için kullanıyor.
//// CLASS  ->  .form-control
//// ID     ->  #session_email
//<div class="merhaba selamlar" />
//##### YANLIŞ KULLANIM : By.className("merhaba selamlar")
//##### DOĞRU KULLANIM  : By.cssSelector(".merhaba.selamlar")