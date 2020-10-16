package com.learn.selenium.drivers;

import java.io.File;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ScreenshotTest {

  private static final Logger LOGGER = Logger.getLogger(ScreenshotTest.class.getName());
  private static final String FOLDER_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/";
  private static final String FILE_PATH = "scraping.html";
  private static final String FILE = "file://" + FOLDER_PATH + FILE_PATH;
  private WebDriver webDriver;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
  }

  @Test
  void testScreenshot() {
    webDriver.get("https://www.google.com");
    File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
    LOGGER.info("File Path: " + screenshot.getAbsolutePath());
    Assertions.assertTrue(screenshot.exists());
    screenshot.deleteOnExit();
  }

  @Test
  void testScreenshot_smallSection() {
    webDriver.get(FILE);
    WebElement element = webDriver.findElement(By.className("author-about"));
    File screenshotFile = captureElement(element);
    LOGGER.info(screenshotFile.getAbsolutePath());
    Assertions.assertNotNull(screenshotFile);
    Assertions.assertTrue(screenshotFile.exists());
    String pathToFile = screenshotFile.getAbsolutePath();
    webDriver.get("file://"+pathToFile);
    screenshotFile.deleteOnExit();
  }

  private static File captureElement(WebElement webElement) {
    WrapsDriver wrapsDriver = (WrapsDriver) webElement;
    return ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
