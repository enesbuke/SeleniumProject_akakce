import Utility.BaseDriver;
import Utility.Func;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase extends BaseDriver {
    @Test
    public void Test1() {

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
        WebElement usageAgreement = driver.findElement(By.xpath("//input[@type='checkbox'][@id='rnufpca']"));
        usageAgreement.click();

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit'][@value='Hesap aç']"));
        submit.click();

        //Kullanıcı ismi kontrol ediliyor
        WebElement checkName = driver.findElement(By.xpath("//a[text()='Can']"));
        System.out.println(checkName.getText());
        Assert.assertTrue("Kullanıcı bulunamadı",checkName.getText().contains("Can"));
        Func.Wait(2);

        WebElement hMenu = driver.findElement(By.xpath("//a[@title='Hesabım']"));
        hMenu.click();
        Func.Wait(1);

        WebElement exit=driver.findElement(By.xpath("//a[text()='Çık']"));
        exit.click();
        Func.Wait(1);

    }
    @Test
    public void Test2(){
        Func.Wait(3);
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
        WebElement usageAgreement = driver.findElement(By.xpath("//input[@type='checkbox'][@id='rnufpca']"));
        usageAgreement.click();

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit'][@value='Hesap aç']"));
        submit.click();

        Func.Wait(2);

        // Kullanıcı hesabı daha önce kayıt olmuş mu kontrol ediyor !
        WebElement accountCreationControl = driver.findElement(By.cssSelector("div[class='alertX t2']"));
        Assert.assertTrue("Bu eMail başka bir hasaba ait",accountCreationControl.getText().contains("zaten"));

        WebElement okButton=driver.findElement(By.xpath("//button[@class='bt_v8 line_v8']"));
        okButton.click();
        Func.Wait(1);

        WebElement akakce=driver.findElement(By.id("H_m_l_v8"));
        akakce.click();
        Func.Wait(1);

        WebElement hMenu = driver.findElement(By.xpath("//a[text()='Giriş Yap']"));
        hMenu.click();
        Func.Wait(1);

        WebElement emailA = driver.findElement(By.cssSelector("[id='life']"));
        emailA.sendKeys("sulmoyarza@gufum.com");
        Func.Wait(1);

        WebElement passwordA = driver.findElement(By.cssSelector("[id='lifp']"));
        passwordA.sendKeys("Can123Can");
        Func.Wait(1);

        WebElement Button = driver.findElement(By.cssSelector("[id='lfb']"));
        Button.click();
    }

    @Test
    public void Test3(){

        //  //bLogoutTest2
        Func.Wait(2);
        WebElement hMenu = driver.findElement(By.xpath("//a[@title='Hesabım']"));
        hMenu.click();

        WebElement exit=driver.findElement(By.xpath("//a[text()='Çık']"));
        exit.click();
        Func.Wait(1);

        WebElement test=driver.findElement(By.xpath("(//a[text()='Giriş Yap'])[1]"));

        Assert.assertTrue("Çıkış yapılamadı", test.isEnabled());
    }

    @Test

    public void Test4(){

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


        WebElement hMenu = driver.findElement(By.xpath("//a[text()='Hesap Aç']"));
        Assert.assertTrue("YANLIŞ ŞİRRE GİRİŞİ",hMenu.isEnabled());

    }
    @Test
    public void Test5(){

        Func.Wait(2);
        WebElement hesabim=driver.findElement(By.xpath("//*[text()='Can'] "));
        hesabim.click();
        Func.Wait(1);

        WebElement siparislerim = driver.findElement(By.xpath("//a[text()='Siparişlerim']"));
        siparislerim.click();

        WebElement text=driver.findElement(By.xpath("//div[text()='Kayıtlı siparişiniz bulunmuyor.']"));

        Assert.assertTrue("Mesaj kutusu dolu!! ",text.getText().toLowerCase().contains("siparişiniz bulunmuyor"));


    }

    @Test
    public void Test6(){

        Func.Wait(2);
        WebElement hesabim=driver.findElement(By.xpath("//*[text()='Can'] "));
        hesabim.click();
        Func.Wait(1);

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
    public void Test7(){

        Func.Wait(2);
        WebElement hesabim=driver.findElement(By.xpath("//*[text()='Can'] "));
        hesabim.click();
        Func.Wait(1);

        Func.Wait(1);
        WebElement hesapsil=driver.findElement(By.xpath("//*[text()='Hesabımı Sil']"));
        hesapsil.click();


        WebElement password2=driver.findElement(By.xpath("//*[@id='p']"));
        password2.sendKeys("Can123Can");


        WebElement btnHesabimiSil=driver.findElement(By.xpath("//*[@id='u']"));
        btnHesabimiSil.click();

        WaitAndClose();
    }
}

