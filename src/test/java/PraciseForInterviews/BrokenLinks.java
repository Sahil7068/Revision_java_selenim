package PraciseForInterviews;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        List<WebElement> l = driver.findElements(By.tagName("a"));

        for(WebElement lin : l){
            String link = lin.getAttribute("href");
            if(link==null || link.isEmpty())
                continue;
            checkForBroken(link);
        }
    }

    public static void checkForBroken(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection httpUrl = (HttpURLConnection)url.openConnection();
        httpUrl.setConnectTimeout(10000);
        httpUrl.setRequestMethod("HEAD");
        httpUrl.connect();

        if(httpUrl.getResponseCode() >= 400){
            System.out.println(link + " -> " + httpUrl.getResponseMessage() + " is a broken link");
        }
        else{
            System.out.println(link + " -> " + httpUrl.getResponseMessage() + " is not a broken link");
        }
    }
}
