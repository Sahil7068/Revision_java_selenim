package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavaScripExe {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html?utm_source=chatgpt.com");

        WebElement ele = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", ele);

        js.executeScript("arguments[0].value='sahil", ele);

        js.executeScript("arguments[0].scrollIntoView(true)", ele);

        //highlight Element

        js.executeScript("arguments[0].style.border='3 px red'", ele);



    }
}
