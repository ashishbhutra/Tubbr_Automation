package pages.LoginPage;

import components.ExpectationHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import pages.BasePage;

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

    public void setUserName(String uname) {
        ExpectationHelper.waitForElementToBeVisible(userName);
        userName.sendKeys(uname);
    }

    public void setPassword(String pass) {
        passWord.sendKeys(pass);
    }

    public void clickSignIn() {
        ExpectationHelper.waitForElementToBeClickable(signInButton);
        signInButton.click();
    }

    public void verifyLoginPage() {
        Assert.assertEquals(userName.isDisplayed(), true);
    }

}
