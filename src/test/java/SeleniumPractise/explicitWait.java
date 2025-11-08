package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.time.Duration;

public class explicitWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        driver.get("https://www.google.com");
    }

    public static void clickOn(WebDriver driver, WebElement locator, int timeout){
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement element = wait.until(ExpectedConditions.visibilityofElementLocated(By.id("elementId")));
//
//
//    public Login(Webdriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "//tagname[@attribute='value'")
//    private WebElement login;
//
//    public void login(){
//        clickOn(login, 20);
//    }
//
//    //javascriptExecutor
//
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].scrollIntoView(true);", element);
//
//    //Alerts
//
//    Alert ar = driver.switch().alert();
//    ar.accept();
//    String text = ar.getText();
//    System.out.println(text);
//
//    Select ar = new Select(driver.findElement(By.xpath("")));
//    ar.selectByVisibleText("Text");
//
//    SoftAssert softa = new SoftAssert();
//    softa.assertEquals()
//
//    //fileIntput
//
//    Properties prop = new Properties();
//    FileInputStream f = new FileInputStream();
//
//    prop.load(f);
}
