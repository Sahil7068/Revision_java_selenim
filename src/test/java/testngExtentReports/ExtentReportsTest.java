//package testngExtentReports;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class ExtentReportsTest {
//
//    ExtentReports extent;
//
//
//    @BeforeTest
//    public void config(){
//        String path = System.getProperty("user.dir") + "\\reports\\index.html";
//        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//        reporter.config().setReportName("WEB AUTOMATION");
//        reporter.config().setDocumentTitle("Test Results");
//
//        extent = new ExtentReports();
//        extent.attachReporter(reporter);
//        extent.setSystemInfo("SDET", "Sahil");
//
//
//    }
//
//    @Test
//    public void initialDemo(){
//
//        extent.createTest("Initial Test");
//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://rahulshettyacademy.com/client");
//
//        String title = driver.getTitle();
//        System.out.println(title);
//        extent.flush();
//    }
//}
