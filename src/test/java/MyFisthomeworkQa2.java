import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyFisthomeworkQa2 {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    //    private final By LOCATOR_FIRST_ARTICLE = By.xpath(".//*[contains(@href,'https://www.tvnet.lv/7232964/tragedija-bagdade-ugunsgreka-covid-19-pacientu-slimnica-gajusi-boja-82-cilveki')]");
    private final By LOCATOR_FIRST_ARTICLE = By.xpath(".//*[contains(@class,'list-article__media')]");
    private final By LOCATOR_ARTICLE_COMMENTS = By.xpath(".//*[contains(@src,'/v5/img/icons/comment-v2.svg')]");
    private final By LOCATOR_ARTICLE_TITLE = By.xpath(".//*[contains(@class,'list-article__headline')]");
    private final By LOCATOR_ALL_ARTICLE_TITLE = By.xpath(".//*[contains(@class,'list-article__headline')]");
    private final By LOCATOR_ALL_COUNT_COMMENTS = By.xpath(".//*[contains(@class,'list-article__comment section-font-color')]");
    private final By LOCATOR_LOGO = By.xpath(".//*[@class='flex header-logo flex--align-items-center']");
    private final By LOCATOR_CHANGE_LANG = By.xpath(".//*[@href='https://rus.tvnet.lv/']");
//    private final By LOCATOR_CHANGE_LANG = By.xpath(".//a[text()=('RUS')]");


    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();
        browserWindow.findElement(LOCATOR_FIRST_ARTICLE).click();
        browserWindow.findElement(LOCATOR_ARTICLE_COMMENTS).click();

        browserWindow.findElement(LOCATOR_ARTICLE_TITLE).getText();
        System.out.println(browserWindow.getTitle());
    }

    @Test
    public void secondTest(){
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        browserWindow.findElements(LOCATOR_ALL_ARTICLE_TITLE).toString();
        System.out.println(browserWindow.getTitle());
    }

    @Test
    public void fourthTest(){
        System.setProperty("webdriver.chrome.driver", "C://Users/User/IdeaProjects/chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");

        WebDriverWait wait = new WebDriverWait(browserWindow, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));
        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();

        List <WebElement> allarticle = browserWindow.findElements(LOCATOR_ALL_ARTICLE_TITLE);
        for (int i=0; i < allarticle.size(); i++){
            String article = allarticle.get(i).getText();
            int removeComment = article.indexOf("(");
            if (removeComment == -1){
                System.out.println(i+1 + " " + article);
            }
            else {
                System.out.println(i+1 + " "+ article.substring(0,removeComment));
            }

        }

    }


}



