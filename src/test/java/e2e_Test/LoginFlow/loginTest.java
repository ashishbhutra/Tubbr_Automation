package e2e_Test.LoginFlow;

import components.SwipeFunctions;
import e2e_Test.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LauchPage.launchPage_helpers;
import pages.LoginPage.loginPage_helpers;
import pages.FourSlider.fourSlider_helpers;
import pages.HomePage.homePage_helpers;
import pages.FriendsInfoPage.FriendsInfo_helpers;
import pages.SettingsPage.settingPage_helpers;
import components.StepLogger;


public class loginTest extends TestBase {

    public launchPage_helpers launchPageObj;
    public loginPage_helpers loginPageObj;
    public fourSlider_helpers fourSliderObj;
    public StepLogger stepLogger;
    public homePage_helpers homePageObj;
    public FriendsInfo_helpers frndInfoObj;
    public settingPage_helpers settingObj;

    @Override
    @BeforeTest
    public void setUpPage() {
        launchPageObj = new launchPage_helpers(driver);
        loginPageObj = new loginPage_helpers(driver);
        fourSliderObj = new fourSlider_helpers(driver);
        stepLogger = new StepLogger();
        homePageObj = new homePage_helpers(driver);
        frndInfoObj = new FriendsInfo_helpers(driver);
        settingObj = new settingPage_helpers(driver);
    }

    @Test(description = "Launch app -> Verify the Launch Page ")
    public void launchAndVerifyLaunchPage() {
        stepLogger.step("Verify the Launch Page");
        launchPageObj.verifyLaunchPage();
    }

    @Test(description = "Go to Login Page and Login")
    public void navigateToLoginPageandLogin() {
        stepLogger.step("Go to Login Page");
        launchPageObj.gotoSignIn();
        loginPageObj.setUserName("ashish");
        loginPageObj.setPassword("ashish123");
        loginPageObj.clickSignIn();
        fourSliderObj.verifyFourSlider();
        fourSliderObj.verifySlideOne();
        SwipeFunctions.swipeLeft((float) 0.75);
        fourSliderObj.verifySlideTwo();
        SwipeFunctions.swipeLeft((float) 0.75);
        fourSliderObj.verifySlideThree();
        SwipeFunctions.swipeLeft((float) 0.75);
        fourSliderObj.verifySlideFour();
        fourSliderObj.clickProceed();
    }

    @Test(description = "Verify Homepage and Logout")
    public void verifyHomeandLogout() {
        // homePageObj.verifyHomePage();
        homePageObj.goToFrinedInfoPage();

        frndInfoObj.verifyFriendInfoPage();
        frndInfoObj.goToSettingPage();

        // settingObj.verifySettingPage();
        settingObj.clickLogout();

        loginPageObj.verifyLoginPage();
    }

}
