package pageobjects.tests;

import com.sun.org.apache.bcel.internal.classfile.Code;
import org.junit.Assert;
import org.junit.Test;
import pageobjects.domain.CodeSprinters;
import pageobjects.pages.GoogleMainPage;
import pageobjects.pages.GoogleResultPage;

public class GoogleSearchTests extends BaseTest {

    @Test

    public void verifyGoogleFindsCodeSprintersPage(){
        GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);

        //assert - then
        Assert.assertTrue(CodeSprinters.PAGE_NAME + " page found", resultPage.countResultWithUrl(CodeSprinters.PAGE_URL) > 0);

    }

    @Test

    public void verifyGoogleShowsNoCodeSprintersOnSecondPage(){
        GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);
        GoogleResultPage secondResultPage = resultPage.displayNextPage();
        Assert.assertTrue("Pages with URL starting with" + CodeSprinters.PAGE_URL + " not found",
                secondResultPage.countResultWithUrlMatching(CodeSprinters.PAGE_URL) == 0);
    }

    private GoogleResultPage searchOnGoogle(String pageName) {

        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.open();
        return mainPage.searchFor(pageName);
    }
}
