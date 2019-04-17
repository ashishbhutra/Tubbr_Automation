package pages.SettingsPage;

import components.ExpectationHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.BasePage;

public class settingPage_helpers extends BasePage {
    public settingPage_helpers(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tubbr:id/settings_container_logout")
    private MobileElement logoutBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[text() = \"Settings\"]")
    private MobileElement settingHeader;

    @Step("Verify Settings Page")
    public void verifySettingPage() {
        ExpectationHelper.waitForElementToBeVisible(settingHeader);
        Assert.assertEquals(settingHeader.isDisplayed(), true);
    }

    @Step("Click on Logout Button")
    public void clickLogout() {
        logoutBtn.click();
    }
}
