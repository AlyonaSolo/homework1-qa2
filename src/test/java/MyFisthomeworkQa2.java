import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Locale;

public class MyFisthomeworkQa2 {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By CLOSE_ADVERTISING = By.xpath(".//div[@style='position: fixed; background-color: rgb(51, 51, 51); font-size: 0.75em; color: rgb(255, 255, 255); cursor: pointer; padding: 9px; bottom: 35px; right: 30px; z-index: 61000; border-radius: 50%;']");
    private final By HOME_PAGE_ARTICLE_TITLE = By.xpath(".//span[@itemprop= 'headline name']");
    private final By LOCATOR_ARTICLE_COMMENTS = By.xpath(".//img[@src='/v5/img/icons/comment-v2.svg']");
//    private final By LOCATOR_ARTICLE_COMMENTS = By.xpath(".//a[contains(@class,'article-share__item article-share__item--comments article-share__item-with-count')]");
    private final By LOCATOR_ARTICLE_COMMENTS_COUNT = By.xpath(".//span[contains(@class,'list-article__comment section-font-color')]");
    private final By LOCATOR_LOGO = By.xpath(".//a[@class='flex header-logo flex--align-items-center']");
    private final By LOCATOR_CHANGE_LANG = By.xpath(".//div[@class = 'menu-items menu-items--top']");

    private WebDriver driver;

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        driver.findElement(ACCEPT_COOKIES_BTN).click();

        driver.findElement(CLOSE_ADVERTISING).click();

        driver.findElement(HOME_PAGE_ARTICLE_TITLE).click();
        driver.findElement(LOCATOR_ARTICLE_COMMENTS).click();
    }

    @Test
    public void secondTest() {
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        driver.findElement(ACCEPT_COOKIES_BTN).click();

       WebElement article = driver.findElement(HOME_PAGE_ARTICLE_TITLE);
       String title = article.getText();
       System.out.println("First Title:" + title.replaceAll(("\\(\\d+\\)$"), " ").trim());
    }

    @Test
    public void thirdTest(){
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        driver.findElement(ACCEPT_COOKIES_BTN).click();

        WebElement menuTop = driver.findElement(LOCATOR_CHANGE_LANG);
        List<WebElement> listItemsMenuTop = menuTop.findElements(By.className("menu-item"));
        for (WebElement itemMenu : listItemsMenuTop){
            if (itemMenu.getText().toLowerCase().contains("rus")){
            itemMenu.click();
                System.out.println("Language change:to rus ");
            }
        }
    }

    @Test
    public void fourthTest() {
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        driver.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headlines = driver.findElements(HOME_PAGE_ARTICLE_TITLE);

        for (int i = 0; i < headlines.size(); i++) {
            if (!headlines.get(i).getText().isEmpty()) {
               String head = (headlines.get(i).getText());
               System.out.println(i + ":" + head.replaceAll("\\(\\d+\\)$", " "));
//               head =head.replaceAll("[\\p{Ps}\\p{Pe}]"," ");
//               head =head.replaceAll("[0-9]"," ");----remove all int
//               System.out.println(i + ":" + headlines.get(i).getText().replaceAll("\\(\\d+\\)$", " ").trim());  ----short version without string head, trim remove spaces
            }
        }
    }

    @Test
    public void fifthTest() {
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        driver.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> headlines = driver.findElements(HOME_PAGE_ARTICLE_TITLE);

        for (int i = 0; i < headlines.size(); i++) {
            if (!headlines.get(i).getText().isEmpty()) {
                String head = headlines.get(i).getText();
                System.out.println(i + ":" + headlines.get(i).getText());
            }


        }
    }

//    @AfterEach
//     public void CloseBrowser() {
//        driver.close();
//    }
}






