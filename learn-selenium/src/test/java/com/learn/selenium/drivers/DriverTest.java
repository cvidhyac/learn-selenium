package com.learn.selenium.drivers;

import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

class DriverTest {

  private static final Logger LOGGER = Logger.getLogger(DriverTest.class.getName());
  private WebDriver chromeWebDriver;
  private WebDriver firefoxWebDriver;
  private WebDriver ieWebDriver;


  @Test
  void testChromeDriver() {
    chromeWebDriver = new ChromeDriver();
    chromeWebDriver.get("https://www.google.com");
    LOGGER.info("Chrome Driver works");
    Assertions.assertNotNull(chromeWebDriver.getTitle());
    chromeWebDriver.close();
    chromeWebDriver.quit();
  }

  @Test
  void testFirefoxDriver() {
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    FirefoxProfile userProfile = new FirefoxProfile();
    userProfile.setAcceptUntrustedCertificates(true);
    userProfile.setAssumeUntrustedCertificateIssuer(false);
    firefoxOptions.setProfile(userProfile);
    firefoxWebDriver = new FirefoxDriver(firefoxOptions);
    firefoxWebDriver.get("https://www.google.com");
    LOGGER.info("Firefox driver works");
    Assertions.assertNotNull(firefoxWebDriver.getTitle());
    firefoxWebDriver.quit();
  }


}
