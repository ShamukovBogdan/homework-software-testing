package homework.lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class MainPlatform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static MainPlatform instance;

    private MainPlatform() {}

    public static MainPlatform getInstance()
    {
        if (instance == null) {
            instance = new MainPlatform();
        }
        return instance;
    }

    public AppiumDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if(this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilites());
        } else if (this.isIOS()) {
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else {
            throw new Exception("Cannot detec type of the Driver. MainPlatform value: " + this.getMainPlatformVar());
        }
    }

    public boolean isAndroid()
    {
        return isMainPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS()
    {
        return isMainPlatform(PLATFORM_IOS);
    }

    private DesiredCapabilities getAndroidDesiredCapabilites()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String current = System.getProperty("user.dir");
        String apkFile = current + "/apks/org.wikipedia.apk";

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app", apkFile);
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String current = System.getProperty("user.dir");
        String apkFile = current + "/apks/Wikipedia.app";

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("app", apkFile);
        return capabilities;
    }

    private boolean isMainPlatform(String my_platform)
    {
        String platform = this.getMainPlatformVar();
        return my_platform.equals(platform);
    }

    private String getMainPlatformVar()
    {
        return System.getenv("PLATFORM");
    }
}
