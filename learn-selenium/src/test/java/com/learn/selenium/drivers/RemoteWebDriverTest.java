package com.learn.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

class RemoteWebDriverTest {

  private WebDriver webDriver;

  /**
   * Refer: {@see DriverNotes.md} on how to start local selenium server using chrome driver
   * @throws MalformedURLException when url is incorrect
   */
  @BeforeEach
  void setUp() throws MalformedURLException {
    webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), new ChromeOptions());
  }

  @Test
  void testDriver() {
    webDriver.get("https://www.google.com");
    Assertions.assertEquals("Google", webDriver.getTitle());
  }

  @AfterEach
  public void tearDown() {
    webDriver.close();
    webDriver.quit();
  }
}
