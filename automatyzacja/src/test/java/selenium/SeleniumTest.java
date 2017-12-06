package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static final String LOCATOR_CS_PAGE = "*//*[@class='rc']/*[@class='r']/a[@href='http://agileszkolenia.pl/']";
    public static final By CS_PAGE_RESULT_LINK = By.xpath(LOCATOR_CS_PAGE);
    public static final String GOOGLE_LINK = "http://google.com";
    public static final By SEARCH_BOX_LOCATOR = By.id("lst-ib");
    public static final String CS_PAGE_NAME = "code sprinters";
    public WebDriver driver;

    @Before

    public void initializeBrowser(){

        //zamiast poniższego lepiej trzymać ścieżkę w zmiennej systemowej path
       // System.setProperty("webdriver.chrome.driver","c:\\WebDrivers\\chromedriver.exe");
       //System.setProperty("webdriver.gecko.driver","c:\\WebDrivers\\geckodriver.exe");


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @Test

    public void canFindCsPageOnFirstGoogleResultPage(){

        driver.get(GOOGLE_LINK);
        WebElement searchBox = driver.findElement(SEARCH_BOX_LOCATOR);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(CS_PAGE_NAME);
        searchBox.submit();

        Assert.assertTrue("CS page found",driver.findElements(CS_PAGE_RESULT_LINK).size() > 0);


    }

    @After

    public void closeBrowser(){

       if (driver!=null) driver.quit();


    }
}
