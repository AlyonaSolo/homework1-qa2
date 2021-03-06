package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ArticlePage {
    private final By TITLE = By.xpath(".//h1[contains(@class,'article-headline' )]");
    private final By COMMENTS = By.xpath(".//span[@class='article-share__item--count']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        return baseFunc.getText(TITLE);
    }

    public int getCommentsCount() {
        LOGGER.info("Getting article comments count");

        if (baseFunc.findElements(COMMENTS).isEmpty()) {
            return 0;
        } else {
            String commentsCountToParse = baseFunc.getText(COMMENTS);
            return Integer.parseInt(commentsCountToParse);
        }
    }

    public void openCommentsPage() {
        LOGGER.info("Opening article comments page");
        baseFunc.click(COMMENTS);
    }
}
