import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Selenium {

    public static final String SEARCH_BUTTON_BY_XPATH = "//*[@id=\\\"sb_form_q\\\"]";
    public static WebDriver browser;

    public static void setup() {
        System.setProperty("webdriver.chrome.driver",
                "webdriver/chromedriver82.exe");
        browser = new ChromeDriver();
        browser.get("https://Bing.com/");
    }
    public static void searchByWord(String word){
        WebElement searchInput = browser.findElement(By.id("sb_form_q"));
        searchInput.sendKeys(word);
        //searchInput.sendKey(Keys.ENTER);
        WebElement formGo = browser.findElement(By.id("sb_form_go"));
        //formGo.click();
        //pirmas veikiantis budas paspaudziant mygtuku su JS
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("arguments[0].click();", formGo);
        // antras neveikiantis budas neveikiantis su javascript
        // WebDriverWait webDriverWait = new WebDriverWait(browser,2);
        //WebDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"sb_form_q\"]")));

    }
    public static int compareResults(){
        WebElement sbCount = browser.findElement(By.xpath("//*[@id=\"b_tween\"]/span"));
        System.out.println(sbCount.getText());
        String searchResults = sbCount.getText().replaceAll("[a-zA-Z]", "").replaceAll("[, ]", "");
        int searchRes = Integer.parseInt(searchResults);
        return searchRes;

    }
    public static void close(){
        browser.close();
    }
    public static void main(String[] args) {
        System.out.println("Selenium + Junit");
        setup();
        searchByWord("Ponas Baranauskas");
        compareResults();
    }
}
