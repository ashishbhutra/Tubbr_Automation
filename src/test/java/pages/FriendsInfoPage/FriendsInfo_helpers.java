package pages.FriendsInfoPage;

import components.ExpectationHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import pages.BasePage;

public class FriendsInfo_helpers extends BasePage {
    public FriendsInfo_helpers(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tubbr:id/network_home_img_settings")
    private MobileElement settingIcon;

    public void verifyFriendInfoPage() {
        ExpectationHelper.waitForElementToBeVisible(settingIcon);
        Assert.assertEquals(settingIcon.isDisplayed(), true);
    }

    public void goToSettingPage() {
        settingIcon.click();
    }
}
