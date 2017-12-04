package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

public class GoogleResultPage extends GooglePage {


    private static final By LOCATOR_SINGLE_RESULT = By.cssSelector(".rc > .r > a");
    public static final By LOCATOR_NEXT_PAGE_LINK = By.id("pnnext");

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public int countResultWithUrl(String pageUrl) {
        List<WebElement>  results = driver.findElements(LOCATOR_SINGLE_RESULT);
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getAttribute("href").equals(pageUrl)).count();

    }

    public GoogleResultPage displayNextPage() {

        driver.findElement(LOCATOR_NEXT_PAGE_LINK).click();

        return new GoogleResultPage(driver);
    }

    public int countResultWithUrlMatching(String pageUrl) {

        List<WebElement>  results = driver.findElements(LOCATOR_SINGLE_RESULT);
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getAttribute("href").startsWith(pageUrl)).count();
    }
    //robi to samo co metoda wyżej
    /*public int countResultWithUrl2(String pageUrl) {
       return (int) driver.findElements(By.cssSelector(".rc > .r > a"))
        .stream()
        .filter(result -> result.getAttribute("href").equals(pageUrl)).count();

    }*/

}
