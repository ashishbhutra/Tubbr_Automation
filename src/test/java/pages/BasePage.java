package pages;

        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;
        import org.openqa.selenium.support.PageFactory;
        import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    /**
     * The driver
     */
    protected final AppiumDriver<?> driver;

    protected BasePage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
    }
}
