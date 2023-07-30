package app.exito.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AppiumAndroidDriver {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumAndroidDriver appium() throws IOException {

        try{
            Properties properties = new Properties();
            InputStream inputStream = AppiumAndroidDriver.class.getClassLoader().getResourceAsStream("serenity.properties");
            properties.load(inputStream);

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("platformName"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getProperty("platformVersion"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("deviceName"));
            capabilities.setCapability(MobileCapabilityType.UDID, properties.getProperty("udid"));
            capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
            capabilities.setCapability("appActivity", properties.getProperty("appActivity"));

            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return new AppiumAndroidDriver();
    }

    public AppiumDriver<MobileElement> on(){
        return driver;
    }
}
