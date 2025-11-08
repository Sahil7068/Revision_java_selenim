package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.transform.sax.SAXResult;
import java.time.Duration;

public class alert {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://letcode.in/alert");

        driver.findElement(By.xpath("//button[@id='accept']")).click();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println("The text is " + text);

        alert.accept();
        driver.close();
    }
}
