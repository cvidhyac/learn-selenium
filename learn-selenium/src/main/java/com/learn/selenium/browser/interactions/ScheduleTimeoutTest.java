package com.learn.selenium.browser.interactions;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ScheduleTimeoutTest {

  private WebDriver webDriver;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get("https://www.google.com");
  }

  /**
   * When a non-existent page is being laoded, test should timeout in x seconds
   */
  @Test
  void testPageLoadTimeout() {
    Timeouts timeouts = webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    Assertions.assertNotNull(timeouts);
  }

  @Test
  void testImplicitTimeout() {
    Timeouts timeouts = webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Assertions.assertNotNull(timeouts);
  }

  /**
   * Wait on a specific element for a period of time, and see if timeout exception is thrown
   * Uses Explicit wait condition with an expected condition on a certain element
   */
  @Test
  void testExplicitWait() {
    WebElement webElement = webDriver.findElement(By.name("q"));
    webElement.sendKeys("news");

    WebElement searchElement = webDriver.findElement(By.name("btnK"));
    searchElement.submit();

    webDriver.navigate().back();

    WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
    Assertions.assertThrows(TimeoutException.class, () ->
        webDriverWait
            .until(ExpectedConditions.elementToBeSelected(webDriver.findElement(By.name("q"))))
    );
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
