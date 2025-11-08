package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class fileUpload {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C://Users//mdsah//Downloads//australian-dollars-banknotes-light-background-close-up_359031-4339.jpg");
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
    }
}
