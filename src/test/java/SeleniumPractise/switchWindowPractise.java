package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class switchWindowPractise {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html?utm_source=chatgpt.com");

        driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();

        Set<String> handler = driver.getWindowHandles();

        Iterator<String> it = handler.iterator();

        String parentwindow = it.next();
        System.out.println("The id of the parentwindow is " + parentwindow);

        if (it.hasNext()){
            String childwindow = it.next();
            System.out.println("The childwindow id is " + childwindow);

            driver.switchTo().window(childwindow);

            System.out.println("The title of the childwindow is " + driver.getTitle());

            driver.close();
            driver.switchTo().window(parentwindow);
            System.out.println("The title of the parentwindow is " + driver.getTitle());
        }
        driver.quit();
    }
}
