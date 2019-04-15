package pages.LauchPage;

import components.ExpectationHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import pages.BasePage;

public class launchPage_helpers extends BasePage {
    @AndroidFindBy(id = "com.tubbr:id/pre_login_button_sign_in")
    private MobileElement signInButton;

    @AndroidFindBy(id = "com.tubbr:id/tubbr_logo")
    private MobileElement tubbrLogo;

    @AndroidFindBy(id= "com.tubbr:id/do_not_have_account")
    private MobileElement alreadyMeberText;

    @AndroidFindBy(id= "com.tubbr:id/alpha")
    private MobileElement alphaLogo;

    @AndroidFindBy(xpath= "//android.widget.TextView(@text = '" + launchPage_constants.yourPersonalBlog + "'")
    private MobileElement youPersonalBlog;

     public void gotoSignIn() {
         ExpectationHelper.waitForElementToBeClickable(signInButton);
         signInButton.click();
     }

     public void verifyLaunchPage() {
         ExpectationHelper.waitForElementToBeVisible(alphaLogo);
         Assert.assertEquals(alphaLogo.isDisplayed(), true);
         Assert.assertEquals(signInButton.isDisplayed(), true);
     }
    public launchPage_helpers(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
}
