package net.oktaliem.web.drivers;

import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class DriverFactory {
    private final static String CHROME = "chrome";
    private final static String FIREFOX = "firefox";
    static Logger log = Logger.getLogger(DriverFactory.class.getName());


    public static WebDriver createProxyDriver(String type, Proxy proxy, String path) {
        if (type.equalsIgnoreCase(CHROME)) return createChromeDriver(createProxyCapabilities(proxy), path);
        else if (type.equalsIgnoreCase(FIREFOX)) return createFirefoxDriver(createProxyCapabilities(proxy));
        throw new RuntimeException("Unknown WebDriver browser: "+type);
    }

    public static WebDriver createChromeDriver(DesiredCapabilities capabilities, String path) {
        System.setProperty("webdriver.chrome.driver", path);
        if (capabilities != null) {
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            return new ChromeDriver(capabilities);
        } else return new ChromeDriver();

    }

    public static WebDriver createFirefoxDriver(DesiredCapabilities capabilities) {
        if (capabilities != null) {
            return new FirefoxDriver(capabilities);
        }

        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile myProfile = allProfiles.getProfile("WebDriver");
        if (myProfile == null) {
            File ffDir = new File(System.getProperty("user.dir")+ File.separator+"ffProfile");
            if (!ffDir.exists()) {
                ffDir.mkdir();
            }
            myProfile = new FirefoxProfile(ffDir);
        }
        myProfile.setAcceptUntrustedCertificates(true);
        myProfile.setAssumeUntrustedCertificateIssuer(true);
        myProfile.setPreference("webdriver.load.strategy", "unstable");
        if (capabilities == null) {
            capabilities = new DesiredCapabilities();
        }
        capabilities.setCapability(FirefoxDriver.PROFILE, myProfile);
        return new FirefoxDriver(capabilities);
    }

    public static DesiredCapabilities createProxyCapabilities(Proxy proxy) {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("proxy", proxy);
        return capabilities;
    }


}
