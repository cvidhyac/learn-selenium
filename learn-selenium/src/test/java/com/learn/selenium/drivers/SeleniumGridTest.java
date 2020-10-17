package com.learn.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

class SeleniumGridTest {

  private static final Logger LOGGER = Logger.getLogger(SeleniumGridTest.class.getName());
  private WebDriver webDriver;
  private static final String URL_STRING = "https://www.google.com";
  private static final String CHROME_NODE = "http://localhost:5555/wd/hub";
  private static final String FIREFOX_NODE = "http://localhost:6666/wd/hub";

  @Test
  void testAcrossChrome() throws MalformedURLException {
    Capabilities chromeCap = new ChromeOptions();
    webDriver = new RemoteWebDriver(new URL(CHROME_NODE), chromeCap);
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.navigate().to(URL_STRING);
    Assertions.assertEquals("Google", webDriver.getTitle());
    webDriver.close();
    webDriver.quit();
  }

  //TODO - Fix local set up : While my gecko driver path is correct, and the hub is rightly
    //attached, for some reason the RemoteWebDriver configured for firefox does not load the driver
  @Test
  void testAcrossFirefox() {
    webDriver = new FirefoxDriver();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.navigate().to(URL_STRING);
    Assertions.assertEquals("Google", webDriver.getTitle());
    webDriver.quit();
  }


}
