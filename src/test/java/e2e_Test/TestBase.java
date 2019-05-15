package e2e_Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public abstract class TestBase {

    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    public static AndroidDriver<MobileElement> driver;
    public static String buildId = System.getenv("BUILD_NUMBER");
    public static String accessKey = System.getenv("access.key");
    public static String deviceQuery = System.getenv("device.query");

    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }
    /**
     * This allows the navigation to work within the app.
     * The category name is returned so we can navigate to it from the navigation
     * drawer.
     *
     * @return The name of the Android category
     */

    //public abstract String getName();

    /**
     * Method to initialize the test's page
     */
    @BeforeTest
    public abstract void setUpPage();



    /**
     * This method runs before any other method.
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to appium server.
     */

    @BeforeSuite(alwaysRun = true)
    @Parameters({"platform", "udid", "systemPort"})
    public void setUpAppium(@Optional String platform,@Optional String udid,@Optional String systemPort) throws MalformedURLException {

        // final String URL_STRING = "http://0.0.0.0:4723/wd/hub";

        // URL url = new URL(URL_STRING);

        String[] platformInfo = platform.split(" ");

        //apk path and mane
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/resources/apps/");
        File app = new File(appDir, "TUBBR_com.tubbr.apk");

        /**Set Desired Capabilities
         * Setting Dependencies to run parallel test
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceQuery", deviceQuery);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID, "9886674e5258475a46");
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
        capabilities.setCapability(MobileCapabilityType.APP, app);
        capabilities.setCapability("accessKey", accessKey);
        //capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
        //capabilities.setCapability("appPackage", "com.tubbr");
        //capabilities.setCapability("appActivity", "com.tubbr.tubbrapp.activity.SplashScreen");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        this .startServer();
        // driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver = new AndroidDriver<MobileElement>(new URL("https://cloud.seetest.io:443/wd/hub"), capabilities);

        //Implicit wait to wait for the Elements to show up
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

    public void startServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * To quit the driver
     */
    @AfterSuite
    public void tearDownAppium() throws Exception {
        if (driver != null) {
            driver.quit();}
            this.stopServer();
    }

}
