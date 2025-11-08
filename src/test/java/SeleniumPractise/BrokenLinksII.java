package SeleniumPractise;

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

public class BrokenLinksII {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement l : links){
            String url = l.getAttribute("href");
            checkBrokenLink(url);
        }


    }

    public static void checkBrokenLink(String ur4l){
        try {
            URL url = new URL(ur4l);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.connect();

            if (urlConnection.getResponseCode() >= 400){
                System.out.println(url + " ->" + urlConnection.getResponseMessage() + " is broken link");
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
