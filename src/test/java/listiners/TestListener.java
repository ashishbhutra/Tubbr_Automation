package listiners;

import e2e_Test.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

public class TestListener extends TestBase implements ITestListener {
    @BeforeTest
    public void setUpPage() {

    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
