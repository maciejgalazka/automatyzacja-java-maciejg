package wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WordPressPage {

    protected WebDriver driver;
    protected static final String WORDPRESS_URL = "https://autotestjava.wordpress.com/";

    public WordPressPage(WebDriver driver) {
        this.driver=driver;

    }
//protected aby mozna dziedzicyc po tym
    protected void writeInto(String text, WebElement webElement) {
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void waitUntilElementIsClickable(WebElement webElement){


    }
}
