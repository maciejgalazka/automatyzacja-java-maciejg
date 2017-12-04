package pageobjects.pages;

import org.openqa.selenium.WebDriver;

public abstract class GooglePage {

    protected static final String GOOGLE_ADDRESS = "http://google.pl/";
    protected WebDriver driver;

    public GooglePage(WebDriver driverx) {

        this.driver=driverx;
    }

}
