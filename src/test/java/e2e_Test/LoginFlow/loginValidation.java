package e2e_Test.LoginFlow;

import e2e_Test.TestBase;
import listiners.TestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage.loginPage_helpers;
import components.StepLogger;

@Listeners({TestListener.class})
public class loginValidation extends TestBase {

    loginPage_helpers loginPage;
    StepLogger stepLogger;
    @BeforeTest
    @Override
    public void setUpPage() {
        loginPage = new loginPage_helpers(driver);
        stepLogger = new StepLogger();
    }

    @Test(priority = 0, description = "Verify the Validation for Login Page")
    public void blankUserNameAndPassword() {
        stepLogger.step("Verify Login Page");
        loginPage.verifyLoginPage();

        stepLogger.step("Both Username and Password Blank click Sign in");
        loginPage.clickSignIn();

        stepLogger.step("");
    }
}
