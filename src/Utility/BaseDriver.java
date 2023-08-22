package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;
    static {

        driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.akakce.com");

    }
    public static void WaitAndClose(){
        Func.Wait(3);
        driver.quit();
    }
}
