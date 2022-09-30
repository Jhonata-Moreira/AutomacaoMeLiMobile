package com.desafio.mercadoLivreApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverConfig {
    private static AppiumDriver driver;

    public static void setUp(){
        File apk =
                new File(System.getProperty("user.dir") + "\\drives\\mercadolibre-10-229-2.apk");

        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL urlConexao = null;
        try {
            urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver(urlConexao, configuracoes);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static AppiumDriver getDriver(){
        DriverConfig.setUp();
        return driver;
    }
}
