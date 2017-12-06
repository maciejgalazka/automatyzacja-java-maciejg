package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressLoginPage extends WordPressPage {


    private static final String WORDPRESS_ADMIN_URL = WORDPRESS_URL + "wp-login.php";
    private @FindBy(id = "usernameOrEmail") WebElement userNameInputBox;
    private @FindBy(id = "password") WebElement userPasswordBox;

    public WordPressLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WordPressAdminPage logIn(String username, String password){
        driver.get(WORDPRESS_ADMIN_URL);
        //WebElement userNameInputBox = driver.findElement(By.id("usernameOrEmail"));

        writeInto(username, userNameInputBox);
        userNameInputBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(userPasswordBox));

        //WebElement userPassword = driver.findElement(By.id("password"));
        writeInto(password, userPasswordBox);
        userPasswordBox.submit();
        return new WordPressAdminPage(driver);
    }

}
