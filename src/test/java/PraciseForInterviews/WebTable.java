package PraciseForInterviews;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement scroll = driver.findElement(By.xpath("//h2[contains(text(), 'Static Web Table')]"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", scroll);

        int rowSize = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
        int columnSize = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();

        outerLoop:
        for (int i = 1; i<rowSize; i++){
            for (int j = 1; j<=columnSize; j++){
                WebElement element = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + (i+1) + "]/td[" + j + "]"));
                if(element.getText().contains("JAVA")){
                    System.out.println((i+1) + " X " + j);
                    break outerLoop;
                }

            }
        }
    }
}
