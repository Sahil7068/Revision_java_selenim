package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class BrokenLinks {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(links.size());

        List<String> hrefs = new ArrayList<>();

        for (WebElement link : links) {
            String url = link.getAttribute("href");
//            hrefs.add(link.getAttribute("href"));

            checkBrokenLink(url);
        }



    }

    public static void checkBrokenLink(String linkUrl){
        try{

            URL url = new URL(linkUrl);
            HttpURLConnection httpUrl = (HttpURLConnection)url.openConnection();
            httpUrl.setConnectTimeout(5000);
            httpUrl.connect();

            if (httpUrl.getResponseCode() >= 400){
                System.out.println(linkUrl + " ->" + httpUrl.getResponseMessage() + " is broken link");
            }

            else {
                System.out.println(linkUrl + " ->" + httpUrl.getResponseMessage() + " is not a broken link");
            }


        }
        catch (Exception e){

        }
    }
}
