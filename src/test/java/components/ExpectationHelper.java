package components;

import e2e_Test.TestBase;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class ExpectationHelper extends TestBase {


    public static MobileElement waitForElementToBeClickable(MobileElement element) {
        WebDriverWait wait=new WebDriverWait(driver, 20);

        MobileElement clicklableElement = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(element));
        return clicklableElement;
    }

    public static boolean waitForElementToBeVisible(MobileElement element) {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        MobileElement ele = (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
        if(ele.isDisplayed()){
            return true;
        }
        else
            return false;
    }

    public static boolean waitForElementToBeVisibleWithTime(MobileElement element, int timeout) {
        WebDriverWait wait=new WebDriverWait(driver, timeout);
        MobileElement ele = (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
        if(ele.isDisplayed()){
            return true;
        }
        else
            return false;
    }

    @BeforeTest
    public void setUpPage() {

    }
}
