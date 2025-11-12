package PraciseForInterviews;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pagination {
    WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement scroll = driver.findElement(By.xpath("//tr/td[contains(text(), 'Wireless Earbuds')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", scroll);

        List<String> expectedPage1Items = List.of(
                "Smartphone",
                "Laptop",
                "Tablet",
                "Smartwatch",
                "Wireless Earbuds"
        );

        Map<Integer, List<String>> expectedPerPage = new HashMap<>();
        expectedPerPage.put(2, List.of("Bluetooth Speaker", "Television", "Action Camera", "Gaming Console", "Digital Camera"));
        expectedPerPage.put(3, List.of("Smart Home Hub", "Router", "Portable Charger", "Fitness Tracker", "Desktop Computer"));
        expectedPerPage.put(4, List.of("E-Reader", "VR Headset", "Streaming Device", "Soundbar", "Wireless Mouse 20"));

        List<WebElement> l = driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));

        List<WebElement> p = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[2]"));
        System.out.println("For Page " + 1);
        p.stream().map(WebElement::getText).forEach(System.out::println);
        Assert.assertEquals(p.size(), 5);

        Assert.assertEquals(p.stream().map(WebElement::getText).collect(Collectors.toList()), expectedPage1Items);
        System.out.println();

        for (int i = 1; i < l.size(); i++) {
            WebElement pageLink = driver.findElement(By.xpath("//ul[@class='pagination']/li[" + (i+1) + "]/a"));
            pageLink.click();



            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination']/li/a")));

            List<WebElement> products = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[2]"));
            System.out.println("For Page " + (i+1) + " ");
            products.stream().map(WebElement::getText).forEach(System.out::println);
            Assert.assertEquals(products.size(), 5);
            Assert.assertEquals(products.stream().map(WebElement::getText).collect(Collectors.toList()), expectedPerPage.get(i+1));


            System.out.println();



        }
    }




}
