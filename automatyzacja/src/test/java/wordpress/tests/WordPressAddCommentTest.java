package wordpress.tests;

import org.junit.Assert;
import org.junit.Test;
import wordpress.domain.Comment;
import wordpress.pages.WordPressCommentPage;
import wordpress.pages.WordPressMainPage;

public class WordPressAddCommentTest extends BaseTest{

    @Test

    public void verifyCanAddComment(){

        Comment comment = new Comment();

        WordPressMainPage mainPage = new WordPressMainPage(driver);
        mainPage.open();
        WordPressCommentPage commentPage = mainPage.goToFirstCommentPage();

        commentPage.addComment(comment);

        Assert.assertTrue(commentPage.isCommentAdded(comment));

    }

    @Test
    public void verifyCanAddCommentToComment() throws InterruptedException {

        Comment comment = new Comment();
        Comment reply = Comment.reply();

        WordPressMainPage mainPage = new WordPressMainPage(driver);
        mainPage.open();
        WordPressCommentPage commentPage = mainPage.goToFirstCommentPage();

        commentPage.addComment(comment);
        commentPage.findReplyAndClick(comment);
        commentPage.addComment(reply);

        Assert.assertTrue(commentPage.isCommentAdded(reply));

    }


}
