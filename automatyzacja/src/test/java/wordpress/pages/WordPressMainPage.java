package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WordPressMainPage extends  WordPressPage{

   // public static final String COMMENT_LOCATOR ="";
    public static final By COMMENT_LOCATOR = By.cssSelector(".comments-link");

    public WordPressMainPage(WebDriver driver) {
        super(driver);

    }

    public void open(){

        driver.get(WORDPRESS_URL);
    }


    public WordPressCommentPage goToFirstCommentPage() {

        driver.findElement(COMMENT_LOCATOR)
                .click();
        return new WordPressCommentPage(driver);
    }
}
