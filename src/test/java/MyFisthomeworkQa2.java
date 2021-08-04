import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyFisthomeworkQa2 {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By CLOSE_ADVERTISING = By.xpath(".//div[contains(@style, 'z-index: 61000')]");

    private final By HOME_PAGE_TITLE = By.xpath(".//span[@class = 'list-article__headline']");
    private final By HOME_PAGE_ARTICLE = By.tagName("article");
    private final By LOCATOR_ARTICLE_COMMENTS = By.xpath(".//img[@src='/v5/img/icons/comment-v2.svg']");
    //    private final By LOCATOR_ARTICLE_COMMENTS = By.xpath(".//a[contains(@class,'article-share__item article-share__item--comments article-share__item-with-count')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//span[contains(@class,'list-article__comment section-font-color')]");
    private final By LOCATOR_LOGO = By.xpath(".//a[@class='flex header-logo flex--align-items-center']");
    private final By LOCATOR_CHANGE_LANG = By.xpath(".//div[@class = 'menu-items menu-items--top']");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class,'article-headline' )]");
    private final By ARTICLE_PAGE_TITLE_DIFFERENT = By.xpath(".//h1[@class='article-superheader__headline']");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//span[@class='article-share__item--count']");
    private final By ARTICLE_PAGE_TITLE_ADDITIONAL_TEXT = By.xpath(".//div[@class='article-headline--additional']");
    private final By ARTICLE_PAGE_COMMENTS_BTN = By.xpath("");

    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[@class='article-headline']");
    private final By COMMENTS_PAGE_TITLE_ADDITIONAL_TEXT = By.xpath(".//div[@class='article-headline--additional']");
    private final By COMMENTS_PAGE_COMMENTS_COUNT = By.xpath(".//span[contains(@class,'article-comments-heading__count ')]");

    private final Logger LOGGER = LogManager.getLogger(MyFisthomeworkQa2.class);

    private WebDriver driver;

    @Test
    public void firstTest() {
        LOGGER.info("This test open first article and then open comments for this article in home page ");

        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page tvnet.lv");
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        LOGGER.info("Accepting cookie.");
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        driver.findElement(ACCEPT_COOKIES_BTN).click();

        LOGGER.info("Closing advertising .");
        wait.until(ExpectedConditions.elementToBeClickable(CLOSE_ADVERTISING));
        driver.findElement(CLOSE_ADVERTISING).click();

        LOGGER.info("Opening at home page first article");
        driver.findElement(HOME_PAGE_TITLE).click();

        LOGGER.info("Opening comments for first article.");
        driver.findElement(LOCATOR_ARTICLE_COMMENTS).click();
    }

    @Test
    public void secondTest() {
        LOGGER.info("This test print in console first title on the home page");

        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page");
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        LOGGER.info("Waiting for accept cookies button");
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        LOGGER.info("Accepting cookie.");
        driver.findElement(ACCEPT_COOKIES_BTN).click();

        LOGGER.info("Find first title on the home page");
        WebElement article = driver.findElement(HOME_PAGE_TITLE);

        LOGGER.info("Save title to a variable ");
        String title = article.getText();

        LOGGER.info("Print  out in console first title without comments count");
        System.out.println("First Title:" + title.replaceAll(("\\(\\d+\\)$"), " ").trim());
    }

    @Test
    public void thirdTest() {
        LOGGER.info("This test find element for language change");

        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page");
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        LOGGER.info("Waiting for accept cookies button");
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        LOGGER.info("Accepting cookie.");
        driver.findElement(ACCEPT_COOKIES_BTN).click();

        WebElement menuTop = driver.findElement(LOCATOR_CHANGE_LANG);

        LOGGER.info("Find all elements from Menu top");
        List<WebElement> listItemsMenuTop = menuTop.findElements(By.className("menu-item"));
        for (WebElement itemMenu : listItemsMenuTop) {
            LOGGER.info("Find language change element from Menu top");
            if (itemMenu.getText().toLowerCase().contains("rus")) {
                LOGGER.info("Change language ");
                itemMenu.click();
                System.out.println("Language change:to rus ");
            }
        }
    }

    @Test
    public void fourthTest() {
        LOGGER.info("This test print out in console all titles from home page without comments count ");

        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page");
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        LOGGER.info("Waiting for accept cookies button");
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        LOGGER.info("Accepting cookie.");
        driver.findElement(ACCEPT_COOKIES_BTN).click();

        LOGGER.info("Find all titles from home page ");
        List<WebElement> headlines = driver.findElements(HOME_PAGE_TITLE);

        for (int i = 0; i < headlines.size(); i++) {
            LOGGER.info("If title is not empty save it in variable");
            if (!headlines.get(i).getText().isEmpty()) {
                String head = (headlines.get(i).getText());

                LOGGER.info("Print out in console all titles without comments count");
                System.out.println(i + ":" + head.replaceAll("\\(\\d+\\)$", " "));
//               head =head.replaceAll("[\\p{Ps}\\p{Pe}]"," ");
//               head =head.replaceAll("[0-9]"," ");----remove all int
//               System.out.println(i + ":" + headlines.get(i).getText().replaceAll("\\(\\d+\\)$", " ").trim());  ----short version without string head, trim remove spaces
            }
        }
    }

    @Test
    public void fifthTest() {
        LOGGER.info("This test print out in console all titles and comments count for articles from home page");

        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page");
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        LOGGER.info("Waiting for accept cookies button");
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        LOGGER.info("Accepting cookie.");
        driver.findElement(ACCEPT_COOKIES_BTN).click();

        LOGGER.info("Find all articles from home page");
        List<WebElement> articles = driver.findElements(HOME_PAGE_ARTICLE);
        for (WebElement we : articles) {
            LOGGER.info("If article is not empty get title text");
            if (!we.getText().isEmpty()) {
            }
            String articletitle = we.findElement(HOME_PAGE_TITLE).getText();
            int homePageCommentsCount = 0;
            LOGGER.info("If comments count is not empty save it to a string");
            if (!we.findElements(HOME_PAGE_COMMENTS).isEmpty()) {
                String commentsCountsCount = we.findElement(HOME_PAGE_COMMENTS).getText();
                LOGGER.info("Remove from comments count brackets");
                commentsCountsCount = commentsCountsCount.substring(1, commentsCountsCount.length() - 1);
                LOGGER.info("Change string to a integer");
                homePageCommentsCount = Integer.parseInt(commentsCountsCount);
            }
            LOGGER.info("Print out in console all title from home page without comments and next to it comments count for this article");
            System.out.println(articletitle.replaceAll("\\(\\d+\\)$", ":") + homePageCommentsCount);

        }


    }

    @Test
    public void sixthTest() {
        LOGGER.info("");

        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");

        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page");
        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        LOGGER.info("Waiting for accept cookies button");
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        LOGGER.info("Accepting cookie.");
        driver.findElement(ACCEPT_COOKIES_BTN).click();

        LOGGER.info("Closing advertising .");
        wait.until(ExpectedConditions.elementToBeClickable(CLOSE_ADVERTISING));
        driver.findElement(CLOSE_ADVERTISING).click();

        //---------------------------HOME PAGE-----------------------------------------------------------

        List<WebElement> articles = driver.findElements(HOME_PAGE_ARTICLE);
        WebElement article = articles.get(10);

        String homePageTitle = article.findElement(HOME_PAGE_TITLE).getText().replaceAll("\\(\\d+\\)$", "").trim();
        int homePageCommentsCount = getCommentsCount(article, HOME_PAGE_COMMENTS);
//        if (!article.findElements(HOME_PAGE_COMMENTS).isEmpty()){
////           // String commentsCount = article.findElement(HOME_PAGE_COMMENTS).getText();
        //
////          //   homePageCommentsCount = Integer.parseInt(commentsCount);
//            homePageCommentsCount = getCommentsCount(article.findElement(HOME_PAGE_COMMENTS).getText());
//        }
        article.findElement(HOME_PAGE_TITLE).click();

        //-------------------------ARTICLE PAGE----------------------------------------------------------
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
//        WebElement articlePageTitleText = driver.findElement(ARTICLE_PAGE_TITLE);

//        if (!articlePageTitleText.findElements(ARTICLE_PAGE_TITLE_ADDITIONAL_TEXT).isEmpty()) {
//          String  articlePageTitleAdditionalText = driver.findElement(ARTICLE_PAGE_TITLE_ADDITIONAL_TEXT).getText();
//            String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText().replaceAll(articlePageTitleAdditionalText, " ").trim();
//            articlePageTitleText=
//        }

//        if (!driver.findElements(ARTICLE_PAGE_TITLE_ADDITIONAL_TEXT).isEmpty()){
//            articlePageTitleAdditionalText = driver.findElement(ARTICLE_PAGE_TITLE_ADDITIONAL_TEXT).getText();
//        }
//        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText().replaceAll(articlePageTitleAdditionalText, " ").trim();

        int articlePageCommentsCount = getCommentsCount(ARTICLE_PAGE_COMMENTS);

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, "Wrong comments count");

        driver.findElement(ARTICLE_PAGE_COMMENTS).click();

        //-------------------------COMMENTS PAGE----------------------------------------------------------
        String commentsPageTitle = driver.findElement(COMMENTS_PAGE_TITLE).getText();
//        String commentsPageAdditionalText = driver.findElement(COMMENTS_PAGE_TITLE_ADDITIONAL_TEXT).getText();
//        String commentsPageTitle = driver.findElement(COMMENTS_PAGE_TITLE).getText().replaceAll(commentsPageAdditionalText, " ").trim();
//        int commentsPageCommentsCount = getCommentsCount(COMMENTS_PAGE_COMMENTS_COUNT);
//
        int commentsPageCommentsCount = 0;
        if (!driver.findElements(COMMENTS_PAGE_COMMENTS_COUNT).isEmpty()) {
            String commentsPageCommentsCountText = driver.findElement(COMMENTS_PAGE_COMMENTS_COUNT).getText();
            commentsPageCommentsCount = Integer.parseInt(commentsPageCommentsCountText);
        }

        Assertions.assertEquals(homePageTitle, commentsPageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentsCount, "Wrong comments count!");
    }
    //=====================================TEST REALISATION==================================================

    private int getCommentsCount(By locator) {
        int commentsCount = 0;
        if (!driver.findElements(locator).isEmpty()) {
            String commentsCountText = driver.findElement(locator).getText();
            commentsCount = Integer.parseInt(commentsCountText);
        }

        return commentsCount;
    }

    private int getCommentsCount(WebElement we, By locator) {
        int commentsCount = 0;

        if (!we.findElements(locator).isEmpty()) {
            String commentsCountText = we.findElement(locator).getText();
            commentsCountText = commentsCountText.substring(1, commentsCountText.length() - 1);
            commentsCount = Integer.parseInt(commentsCountText);
        }

        return commentsCount;
    }
//    @AfterEach
//     public void CloseBrowser() {
//        driver.close();
//    }


}





