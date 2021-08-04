package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.pages.ArticlePage;
import pageobject.pages.BaseFunc;
import pageobject.pages.CommentsPage;
import pageobject.pages.HomePage;


public class SecondHomeworkQA {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final int ARTICLE_ID = 1;

    private BaseFunc baseFunc;

    @Test
    public void SecondHomework() {
        baseFunc = new BaseFunc();
        baseFunc.openPage("tvnet.lv");

        //---------------------------HOME PAGE-----------------------------------------------------------
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

        homePage.closeAdvertising();

        homePage.getArticleById(ARTICLE_ID);

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentsCount = homePage.getCommentsCount(ARTICLE_ID);

        ArticlePage articlePage = homePage.openArticle(ARTICLE_ID);

        //-------------------------ARTICLE PAGE----------------------------------------------------------
        String articlePageTitle = articlePage.getTitle();
        int articlePageCommentsCount = articlePage.getCommentsCount();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, "Wrong comments count");

        articlePage.openCommentsPage();

        //-------------------------COMMENTS PAGE----------------------------------------------------------
        CommentsPage commentsPage = new CommentsPage(baseFunc);
        String commentsPageTitle = commentsPage.getTitle();
        int commentsPageCommentsCount = commentsPage.getCommentsCount();

        Assertions.assertEquals(homePageTitle, commentsPageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentsCount, "Wrong comments count!");
    }

    @AfterEach
    public void CloseBrowser() {
        baseFunc.closeBrowser();
    }
}


