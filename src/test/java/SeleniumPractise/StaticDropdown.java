package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StaticDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select select = new Select(staticDropdown);
        List<WebElement> l = select.getOptions();



//        List<String> optionsTexts = new ArrayList<>();
//        for (WebElement options : l){
//            optionsTexts.add(options.getText());
//        }
//
//        Collections.sort(optionsTexts);
//
//        for (String op : optionsTexts){
//            System.out.println(op);
//        }


        l.stream()
                .map(WebElement::getText)
                .sorted()
                .forEach(System.out::println);


        driver.quit();

    }
}
