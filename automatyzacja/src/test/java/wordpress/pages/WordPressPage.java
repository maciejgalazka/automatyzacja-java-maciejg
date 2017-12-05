package wordpress.pages;

import org.openqa.selenium.WebDriver;

public abstract class WordPressPage {

    protected WebDriver driver;
    protected static final String WORDPRESS_URL = "https://autotestjava.wordpress.com/";

    public WordPressPage(WebDriver driver) {
        this.driver=driver;

    }

}
