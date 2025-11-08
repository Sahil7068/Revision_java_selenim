package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.time.Month;
import java.util.List;
import java.util.stream.IntStream;

public class HandlingCalendar {
    public static void main(String[] args) {
        String month = "11";
        String dateNumber = "30";
        String yearNumber = "2024";

        String expectedList[] = {month, dateNumber, yearNumber};

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector("input[name='year']")).click();
        IntStream.range(0, 2).forEach(s->driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click());
        driver.findElement(By.xpath("//button[text()='"+yearNumber+"']")).click();
        driver.findElements(By.cssSelector("button.react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();

        String monthName = Month.of(Integer.parseInt(month)).name(); // gives "NOVEMBER"
        monthName = monthName.substring(0,1).toUpperCase() + monthName.substring(1).toLowerCase();

        String xpath = "//abbr[@aria-label='" + monthName + " " + dateNumber + ", " + yearNumber + "']";
        driver.findElement(By.xpath(xpath)).click();

        List<WebElement> actualList = driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));

        IntStream.range(0, actualList.size())
                .forEach(i -> Assert.assertEquals(
                        actualList.get(i).getAttribute("value"),
                        expectedList[i]
                ));






    }
}
