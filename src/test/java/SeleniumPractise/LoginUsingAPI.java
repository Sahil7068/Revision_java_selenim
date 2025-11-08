package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class LoginUsingAPI {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        Response response = given().header("Content-Type", "application/json").body("{\"userEmail\":\"slworld@gmail.com\",\"userPassword\":\"Test@1234567\"}")
                .when().post("/api/ecom/auth/login").then().assertThat().statusCode(200).extract().response();
        String token = response.jsonPath().getString("token");

        driver.get("https://rahulshettyacademy.com/client");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.setItem(arguments[0], arguments[1])", "token", token);
        driver.navigate().refresh();


    }
}
