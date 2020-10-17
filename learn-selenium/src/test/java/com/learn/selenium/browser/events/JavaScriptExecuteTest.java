package com.learn.selenium.browser.events;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class JavaScriptExecuteTest {

  private static final Logger LOGGER = Logger.getLogger(JavaScriptExecuteTest.class.getName());
  private WebDriver webDriver;
  private static final String FOLDER_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/";
  private static final String FILE_PATH = "scraping.html";
  private static final String FILE = "file://" + FOLDER_PATH + FILE_PATH;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE);
  }

  @Test
  void testExecuteJavaScript_ReturnString() {
    JavascriptExecutor executor = (JavascriptExecutor) webDriver;
    String title = (String) executor.executeScript("return document.title");
    LOGGER.info(title);
    Assertions.assertNotNull(title);
  }

  @Test
  void testExecuteJavaScript_ReturnLong() {
    JavascriptExecutor executor = (JavascriptExecutor) webDriver;
    long linkLength = (long) executor.executeScript("var links = document.getElementsByTagName('A'); return links.length");
    LOGGER.info("Link Length : " + linkLength);
    Assertions.assertNotEquals(0, linkLength);
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
