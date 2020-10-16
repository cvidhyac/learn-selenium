package com.learn.selenium.browser.window;

import java.util.Set;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class PopupTest {

  private static final Logger LOGGER = Logger.getLogger(PopupTest.class.getName());
  private WebDriver webDriver;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get("https://www.naukri.com");
  }

  @Test
  void testPopup() {
    Set<String> windowHandles = webDriver.getWindowHandles();
    windowHandles.forEach(popUp -> {
      webDriver.switchTo().window(popUp);
      Assertions.assertNotNull(webDriver.getTitle());
      LOGGER.info(webDriver.getTitle());
      //close the popupWindow
      webDriver.close();
    });
  }

  @AfterEach
  void tearDown() {
      webDriver.quit();
  }

}
