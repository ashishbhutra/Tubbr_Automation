package pages.HomePage;

import components.ExpectationHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.BasePage;

public class homePage_helpers extends BasePage {
    public homePage_helpers(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tubbr:id/tubbr_icon")
    private MobileElement tubbrHeaderIcon;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]/android.widget.TextView")
    private MobileElement featuredTab;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]/android.widget.TextView")
    private MobileElement networkTab;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]/android.widget.TextView")
    private MobileElement DiscoverTab;

    @Step("Verify Home Page")
    public void verifyHomePage() {
        ExpectationHelper.waitForElementToBeVisible(tubbrHeaderIcon);
        Assert.assertEquals(featuredTab.getText(),"Featured");
        Assert.assertEquals(networkTab.getText(),"Network");
        Assert.assertEquals(DiscoverTab.getText(),"Discover");
    }

    @Step("Click Tubbr header icon")
    public void goToFrinedInfoPage() {
        tubbrHeaderIcon.click();
    }

    @Step("Click on featured tab")
    public void goToFeaturedTab() {
        featuredTab.click();
    }

    @Step("Click on Discover tab")
    public void goToDiscoverTab() {
        DiscoverTab.click();
    }

    @Step("Click on Network tab")
    public void goToNetworkTab() {
        networkTab.click();
    }
}
