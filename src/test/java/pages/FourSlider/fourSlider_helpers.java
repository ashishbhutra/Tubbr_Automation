package pages.FourSlider;

import components.ExpectationHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.BasePage;

public class fourSlider_helpers extends BasePage {
    public fourSlider_helpers(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.tubbr:id/four_slide_header")
    private MobileElement fourSliderHeader;

    @AndroidFindBy(id = "com.tubbr:id/img_proceed")
    private MobileElement proceedBtn;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement slide1HeaderOne;

    @AndroidFindBy(xpath  = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement slide1HeaderTwo;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement slide1HeaderThree;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement slide1HeaderFour;

    @Step("Verify Four Slider Header")
    public void verifyFourSlider() {
        Assert.assertEquals(fourSliderHeader.isDisplayed(), true);
    }

    @Step("Click on Proceed Button")
    public void clickProceed() {
        ExpectationHelper.waitForElementToBeClickable(proceedBtn);
        proceedBtn.click();
    }

    @Step("Verify Slide One")
    public void verifySlideOne() {
        ExpectationHelper.waitForElementToBeVisibleWithTime(slide1HeaderOne, 45);
        String heading= slide1HeaderOne.getText();
        Assert.assertEquals(heading,fourSlider_constants.fourSlider_1);
    }

    @Step("Verify Slide two")
    public void verifySlideTwo() {
        ExpectationHelper.waitForElementToBeVisible(slide1HeaderTwo);
        String heading= slide1HeaderTwo.getText();
        Assert.assertEquals(heading,fourSlider_constants.fourSlider_2);
    }

    @Step("Verify Slide Three")
    public void verifySlideThree() {
        ExpectationHelper.waitForElementToBeVisible(slide1HeaderThree);
        String heading= slide1HeaderThree.getText();
        Assert.assertEquals(heading,fourSlider_constants.fourSlider_3);
    }

    @Step("Verify Slide Four")
    public void verifySlideFour() {
        ExpectationHelper.waitForElementToBeVisible(slide1HeaderFour);
        String heading= slide1HeaderFour.getText();
        Assert.assertEquals(heading,fourSlider_constants.fourSlider_4);
    }
}
