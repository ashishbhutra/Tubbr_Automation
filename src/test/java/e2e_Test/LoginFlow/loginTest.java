package e2e_Test.LoginFlow;

import components.SwipeFunctions;
import e2e_Test.TestBase;
import listiners.TestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LauchPage.launchPage_helpers;
import pages.LoginPage.loginPage_helpers;
import pages.FourSlider.fourSlider_helpers;
import pages.HomePage.homePage_helpers;
import pages.FriendsInfoPage.FriendsInfo_helpers;
import pages.SettingsPage.settingPage_helpers;
import components.StepLogger;

@Listeners({TestListener.class})
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

    @Test(priority = 0, description = "Launch app -> Verify the Launch Page and Login into App ")
    public void verifyLaunchPageAngLogin() {

        final String uname = "ashish";
        final String pass = "ashish123";

        stepLogger.step("Verify the Launch Page");
        launchPageObj.verifyLaunchPage();

        stepLogger.step("Go to Login Page");
        launchPageObj.gotoSignIn();

        stepLogger.step("Enter User Name and Password");
        loginPageObj.setUserName(uname);
        loginPageObj.setPassword(pass);

        stepLogger.step("Click Sign In");
        loginPageObj.clickSignIn();
    }

    @Test(priority = 1,description = "Verify and Navigate All Four Slides")
    public void verifyAndNavigateFourSlider() {

        stepLogger.step("Verify Start of Four Slider");
        fourSliderObj.verifyFourSlider();

        stepLogger.step("Verify First Slide and Swipe Left");
        fourSliderObj.verifySlideOne();
        SwipeFunctions.swipeLeft((float) 0.75);

        stepLogger.step("Verify Second Slide and Swipe Left");
        fourSliderObj.verifySlideTwo();
        SwipeFunctions.swipeLeft((float) 0.75);

        stepLogger.step("Verify Third Slide and Swipe Left");
        fourSliderObj.verifySlideThree();
        SwipeFunctions.swipeLeft((float) 0.75);

        stepLogger.step("Verify Fourt Slide and Click Ok");
        fourSliderObj.verifySlideFour();
        fourSliderObj.clickProceed();
    }

    @Test(priority = 2,description = "Verify Homepage and Logout of App")
    public void verifyHomePageAndLogout() {
        stepLogger.step("Verify Home Page");
        // homePageObj.verifyHomePage();

        stepLogger.step("Go to Friends Info Page");
        homePageObj.goToFrinedInfoPage();

        stepLogger.step("Verify Friend Info Page");
        frndInfoObj.verifyFriendInfoPage();

        stepLogger.step("Go to Setting Page");
        frndInfoObj.goToSettingPage();

        stepLogger.step("Verify Settings Page");
        // settingObj.verifySettingPage();

        stepLogger.step("Click Logout");
        settingObj.clickLogout();

        stepLogger.step("Verify Login Page");
        loginPageObj.verifyLoginPage();
    }

}
