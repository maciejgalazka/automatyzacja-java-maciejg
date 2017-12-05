package wordpress.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import wordpress.domain.Comment;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver; //aby dziedzicząca klasa to widziala

    @Before
    public void initWebdriver (){


        System.setProperty("webdriver.chrome.driver","c:\\WebDrivers\\chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","c:\\WebDrivers\\geckodriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @After

    public void closeBrowser(){

        if (driver!=null) driver.quit();


    }
}
