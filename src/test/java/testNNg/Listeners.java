package testNNg;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }


}

