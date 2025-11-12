package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollAndFindTable {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement scroll = driver.findElement(By.xpath("//tr/td[contains(text(), '500')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", scroll);

        int row = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
        int column = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();

        System.out.println("row: " + row + " column: " + column);

        for (int i = 2; i<=row; i++){
            for (int j = 1; j<=column; j++){
                String text = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                if (text.equalsIgnoreCase("Mukesh")){
                    System.out.println("The text is found" + text);
                    break;
                }

            }
        }


        driver.close();



    }
}
