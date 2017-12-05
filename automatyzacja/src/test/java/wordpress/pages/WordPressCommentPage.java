package wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.domain.Comment;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class WordPressCommentPage extends WordPressPage {

    private static final By COMMENT_WINDOW_LOCATOR = By.id("comment");
    private static final By EMAIL_LOCATOR = By.id("email");
    private static final By NAME_LOCATOR = By.id("author");
    private static final By COMMENT_SUBMIT_LOCATOR = By.id("comment-submit");
    private static final By COMMENT_CONTENT_LOCATOR = By.cssSelector(".comment-content > p");
    private static final By COMMENT_LOCATOR = By.className("comment-body");
    private static final By COMMENT_NAME_LOCATOR = By.tagName("cite");
    private static final By REPLY_LOCATOR = By.className("comment-reply-link");

    public WordPressCommentPage(WebDriver driver) {
        super(driver);
    }

    public void addComment(Comment comment) {
        addComment(comment.getContent(), comment.getMail(), comment.getName());
    }

    private void addComment(String comment, String email, String name) {

        WebElement commentWindow = driver.findElement(COMMENT_WINDOW_LOCATOR);
                commentWindow.click();
                commentWindow.sendKeys(comment);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EMAIL_LOCATOR));
        WebElement webElementEmail = driver.findElement(EMAIL_LOCATOR);
        webElementEmail.clear();
        webElementEmail.sendKeys(email);
        WebElement webElementName = driver.findElement(NAME_LOCATOR);
        webElementName.clear();
        webElementName.sendKeys(name);
        driver.findElement(COMMENT_SUBMIT_LOCATOR).click();

    }

    public boolean isCommentAdded(Comment comment) {
        return isCommentAdded(comment.getContent(), comment.getName());
    }

    private boolean isCommentAdded(String comment, String name) {

        List<WebElement> comments = driver.findElements(COMMENT_LOCATOR);
        Stream<WebElement> commentsStream = comments.stream();
        return commentsStream
                .filter(result -> result.findElement(COMMENT_NAME_LOCATOR).getText().equals(name))
                .filter(result -> result.findElement(COMMENT_CONTENT_LOCATOR).getText().equals(comment))
                .count()>0;

   }

    public void findReplyAndClick(Comment comment) {
        findReplyAndClick(comment.getContent(), comment.getName());
    }

   private void findReplyAndClick(String comment, String name){

       List<WebElement> comments = driver.findElements(COMMENT_LOCATOR);
       Stream<WebElement> commentsStream = comments.stream();
       List<WebElement> webElements = commentsStream
               .filter(result -> result.findElement(COMMENT_NAME_LOCATOR).getText().equals(name))
               .filter(result -> result.findElement(COMMENT_CONTENT_LOCATOR).getText().equals(comment))
               .collect(toList());

       if (webElements.size() > 1) {
           throw new RuntimeException("Too much elements. Expected 1 received: " + webElements.size());
       }

       webElements.get(0).findElement(REPLY_LOCATOR).
               click();

       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancel-comment-reply-link")));

   }
}
