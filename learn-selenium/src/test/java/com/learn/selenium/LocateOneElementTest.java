package com.learn.selenium;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Simple program to display single element from a html page
 */
class LocateOneElementTest {

  private static Logger LOGGER = Logger.getLogger(LocateOneElementTest.class.getName());
  private WebDriver webDriver;
  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/scraping.html";
  private static final String FILE_PROTOCOL = "file://";
  /**
   * Initialize the driver and the file path
   */
  @BeforeEach
  public void setUp() {
    webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testLocateElement() {
    WebElement webElement = webDriver.findElement(By.className("author-about"));
    LOGGER.info(webElement.getText());
    Assertions.assertNotNull(webElement.getText());
  }

  @AfterEach
  public void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
