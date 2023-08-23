import Utility.BaseDriver;

import Utility.Func;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase extends BaseDriver {
    @Test
    public void Test1 () {
        //aCreateAndAcVerifTest

        // Hesap açma butonuna tıklar
        WebElement newAccount = driver.findElement(By.xpath("//a[text()='Hesap Aç']"));
        newAccount.click();


        //İsim (1),soyisim(2) ,email (3),tekrar email(4), şifre(5) ,tekrar şifre(6) girişi

        //(1)
        WebElement name = driver.findElement(By.xpath("//input[@type='text'][@name='rnufn']"));
        name.sendKeys("Can");
        //(2)
        WebElement lastName = driver.findElement(By.xpath("//input[@type='text'][@name='rnufs']"));
        lastName.sendKeys("Cen");
        //(3)
        WebElement email = driver.findElement(By.xpath("//input[@type='email'][@name='rnufe1']"));
        email.sendKeys("sulmoyarza@gufum.com"); // Tek kullanımlık mail
        //(4)
        WebElement tryEmail = driver.findElement(By.xpath("//input[@type='email'][@name='rnufe2']"));
        tryEmail.sendKeys("sulmoyarza@gufum.com");
        //(5)
        WebElement password = driver.findElement(By.xpath("//input[@type='password'][@name='rnufp1']"));
        password.sendKeys("Can123Can");
        //(6)
        WebElement password2 = driver.findElement(By.xpath("//input[@type='password'][@name='rnufp2']"));
        password2.sendKeys("Can123Can");

        //Cinsiyet seçimi
        WebElement gender = driver.findElement(By.xpath("//input[@type='radio'][@name='rngc'][@id='rngm']"));
        gender.click();

        // İl ve İlçe Girişi
        WebElement city = driver.findElement(By.xpath("//option[text()='Afyon']"));
        city.click();

        WebElement county = driver.findElement(By.xpath("//option[text()='Çobanlar']"));
        county.click();


        // Dogum Tarihi girişi .
        WebElement webDay = driver.findElement(By.id("bd"));
        WebElement webMonth = driver.findElement(By.id("bm"));
        WebElement webYear = driver.findElement(By.id("by"));

        Select day = new Select(webDay);
        Select month = new Select(webMonth);
        Select year = new Select(webYear);

        day.selectByVisibleText("16");
        month.selectByValue("4");
        year.selectByVisibleText("1998");


        //Kullanım koşullarını onayla .
        WebElement usageAgreement = driver.findElement(By.xpath("//input[@type='checkbox'][@id=\"rnufpca\"]"));
        usageAgreement.click();

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit'][@value=\"Hesap aç\"]"));
        submit.click();


        try {

            // Kullanıcı hesabı daha önce kayıt olmuş mu kontrol ediyor !
            WebElement accountCreationControl = driver.findElement(By.xpath("//div[@class='m-c']"));
            if (!accountCreationControl.isDisplayed()) {
                System.out.println("Bu Email ile Başka bir hesap var !!!");
            }
        } catch (Exception ignored) {

        }

        try {
            // Kullanıcı isminin Can oldugunu kontrol ediyor
            WebElement checkName = driver.findElement(By.cssSelector("[rel='nofollow'][href='/akakcem/']"));
            Assert.assertEquals("Can", checkName.getText());
        } catch (Exception ignored) {

        }
    }

@Test
    public void Test2 (){
    //bLogoutTest2

    WebElement hMenu = driver.findElement(By.xpath("//a[@title='Hesabım']"));
    Func.Wait(2);
    new Actions(driver)
            .moveToElement(hMenu)
            .build()
            .perform();

    Func.Wait(2);
    try {

    WebElement cikis=driver.findElement(By.xpath("//a[text()='Çık']"));
    Func.Wait(2);

    cikis.click();
    Func.Wait(1);

        Assert.assertFalse("Çıkış yapılamadı",cikis.isSelected());
    }catch (Exception e) {
        System.out.println("Button'a tıklamadı");
    }
        }

    @Test
    public void Test3() {
        //cLoginTest3

        WebElement girisYap = driver.findElement(By.cssSelector("[id='H_rl_v8'] a+a"));
        girisYap.click();
        Func.Wait(2);

        WebElement email = driver.findElement(By.cssSelector("[id='life']"));
        email.sendKeys("sulmoyarza@gufum.com");

        WebElement password = driver.findElement(By.cssSelector("[id='lifp']"));
        password.sendKeys("Can123Can");

        WebElement Button = driver.findElement(By.cssSelector("[id='lfb']"));
        Button.click();
        Func.Wait(2);

        try {

            WebElement errorW3 = driver.findElement(By.xpath("//div[@class=\"alertX t2\"]"));

            if (!errorW3.isDisplayed()) {
                System.out.println("Eposta veya Şifreniz hatalı");


            }
        } catch (Exception e) {


        }
    }
    @Test
    public void Test4(){
        //dOrderListTest4

        //Sipariş listesi giriş yapma
        WebElement hMenu = driver.findElement(By.xpath("//div[@id='HM_v8']/a"));
        new Actions(driver)
                .moveToElement(hMenu)
                .build()
                .perform();


        WebElement hesabim = driver.findElement(By.xpath("//a[text()='Hesabım']"));
        hesabim.click();
        Func.Wait(1);

        WebElement siparislerim = driver.findElement(By.xpath("//a[text()='Siparişlerim']"));
        siparislerim.click();

        WebElement text=driver.findElement(By.xpath("//div[text()='Kayıtlı siparişiniz bulunmuyor.']"));

        Assert.assertTrue("Mesaj kutusu dolu!! ",text.getText().toLowerCase().contains("siparişiniz bulunmuyor"));


    }
@Test
public void Test5(){
    //Mesajlarima Giris
    Func.Wait(1);
    WebElement MyMessages= driver.findElement(By.xpath("//a[text()='Mesajlarım']"));
    MyMessages.click();

    //Mesaj Kutusunun bos oldugunun kontrolu
    WebElement confirmationText = driver.findElement(By.xpath("//div[@class='wbb_v8']"));
    Assert.assertTrue("Listelenecek mesaj bulunamadı", confirmationText.getText().contains("Listelenecek mesaj bulunamadı"));
    System.out.println("Mesajlarim = " + confirmationText.getText());


}
    @Test
    public void Test6(){

       //Hesap silme
        Func.Wait(1);
        WebElement webMenu=driver.findElement(By.xpath("//*[@title='Hesabım']"));
        webMenu.click();


        WebElement btnHesabim=driver.findElement(By.xpath("//*[text()='Hesabım']"));
        btnHesabim.click();

        Func.Wait(1);
        WebElement hesapsil=driver.findElement(By.xpath("//*[text()='Hesabımı Sil']"));
        hesapsil.click();


        WebElement password2=driver.findElement(By.xpath("//*[@id='p']"));
        password2.sendKeys("Can123Can");


        WebElement btnHesabimiSil=driver.findElement(By.xpath("//*[@id='u']"));
        btnHesabimiSil.click();

        try {
            WebElement passwordError = driver.findElement(By.xpath("//p[text()='Mevcut şifrenizi doğru girdiğinizden emin olun.']"));

            if (!passwordError.isDisplayed()) {
                System.out.println("Geçersiz Şifre");
            }
        }catch (NoSuchElementException e) {

        }

//        Func.Wait(2);
//        String passwordCheck="JAtW-mZyb4.A-q";
//        Assert.assertTrue("Geçersiz şifre ! ", password2.getText().contains(passwordCheck));


        WaitAndClose();
    }
}

