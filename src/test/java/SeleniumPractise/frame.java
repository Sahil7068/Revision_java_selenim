package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class frame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Total frames: " + frames.size());

//        // Step 1: Switch to the outer iframe (iframeResult)
//        driver.switchTo().frame("iframeResult");
//
//        // Step 2: switch to inner iframe (by WebElement or name/title)
//        WebElement inner = driver.findElement(By.xpath("//iframe[@title='W3Schools Free Online Web Tutorials']"));
//        driver.switchTo().frame(inner);
//
//        WebElement css = driver.findElement(By.xpath("//a[text()='CSS']"));
//        css.click();
//
//        String text = css.getText();
//        System.out.println(text);
    }
}
