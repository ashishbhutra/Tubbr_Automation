package pages.LoginPage;

import components.ExpectationHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import pages.BasePage;
import io.qameta.allure.Step;

public class loginPage_helpers extends BasePage {
    @AndroidFindBy(id = "com.tubbr:id/sign_in_username")
    public  MobileElement userName;

    @AndroidFindBy(id = "com.tubbr:id/sign_in_password")
    public  MobileElement passWord;

    @AndroidFindBy(id = "com.tubbr:id/btn_sign_in")
    public  MobileElement signInButton;

    public loginPage_helpers(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Enter UserName: {0}")
    public void setUserName(String uname) {
        ExpectationHelper.waitForElementToBeVisible(userName);
        userName.sendKeys(uname);
    }

    @Step("Enter Password: {0}")
    public void setPassword(String pass) {
        passWord.sendKeys(pass);
    }

    @Step("Click SignIn Button.")
    public void clickSignIn() {
        ExpectationHelper.waitForElementToBeClickable(signInButton);
        signInButton.click();
    }

    @Step("Verify Login Page.")
    public void verifyLoginPage() {
        Assert.assertEquals(userName.isDisplayed(), true);
    }

}
