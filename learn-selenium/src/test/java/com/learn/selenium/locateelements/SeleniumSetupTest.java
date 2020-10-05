package com.learn.selenium.locateelements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Verify if Selenium set up works
 * Pre-requisite - install selenium via brew
 */
class SeleniumSetupTest {

  private WebDriver chromeDriver;

  @BeforeEach
  public void setUp() {
    chromeDriver = new ChromeDriver();
  }

  @Test
  void testDriverLoads() {
    Assertions.assertNotNull(chromeDriver);
  }

  @AfterEach
  public void tearDown() {
    chromeDriver.close();
    chromeDriver.quit();
  }
}
