package components;

import e2e_Test.TestBase;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeTest;

public class SwipeFunctions extends TestBase {
    @BeforeTest
    public void setUpPage() {

    }
    public static void swipeLeft(float partOfScreen) {
        Dimension size = driver.manage().window().getSize();

        int startx = (int) (size.width * partOfScreen);
        int starty = (int) (size.height * partOfScreen);
        int endx =  (int) (size.width * (0.5));

        (new TouchAction(driver))
                .press(startx,starty)
                .moveTo(-(endx), 0)
                .release()
                .perform();
    }
}
