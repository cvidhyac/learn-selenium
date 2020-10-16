package com.learn.selenium.browser.interactions;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SessionCookieTest {

  private static final Logger LOGGER = Logger.getLogger(SessionCookieTest.class.getName());
  private WebDriver webDriver;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get("https://app.lucidchart.com");
  }

  @Test
  void testCookie() {

    Set<Cookie> websiteCookie = webDriver.manage().getCookies();
    LOGGER.log(Level.INFO, "Website cookie size : {0}", new Object[] {websiteCookie.size()});
    websiteCookie.forEach(cookie -> {
      String cookieName = cookie.getName();
      String cookieValue = cookie.getValue();
      Assertions.assertNotNull(cookieName);
      Assertions.assertNotNull(cookieValue);
      LOGGER.log(Level.INFO, "CookieName : {0}, CookieValue: {1}",
          new Object[] {cookieName, cookieValue});
    });
  }


  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
