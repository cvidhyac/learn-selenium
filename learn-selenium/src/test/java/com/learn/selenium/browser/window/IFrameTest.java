package com.learn.selenium.browser.window;

import java.util.Set;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class IFrameTest {

  private static final Logger LOGGER = Logger.getLogger(IFrameTest.class.getName());
  private WebDriver webDriver;
  private static final String FOLDER_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/";
  private static final String FILE_PATH = "iframes.html";
  private static final String FILE = "file://" + FOLDER_PATH + FILE_PATH;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE);
  }

  @Test
  void testIFrameTest() {
    String mainWindow = webDriver.getWindowHandle();

    // check by id in the first iframe
    WebElement iframeElement = webDriver.findElement(By.id("scraping"));
    webDriver.switchTo().frame(iframeElement);
    validateScrapingContent();
    webDriver.switchTo().window(mainWindow);

    //another hypothetical usecase to check contents in the next iframe
    webDriver.switchTo().frame("selenium");
    validateSeleniumHqFrame();
    webDriver.switchTo().window(mainWindow);
    //This should return back to main page after testing.
    Assertions.assertEquals(mainWindow, webDriver.getWindowHandle());
  }

  private void validateSeleniumHqFrame() {
    WebElement webElement = webDriver.findElement(By.xpath("/html/body/div[1]/section/div/h2/strong"));
    LOGGER.info(webElement.getText());
  }

  private void validateScrapingContent() {
    WebElement paragraphText = webDriver.findElement(By.className("author-about"));
    Assertions.assertNotNull(paragraphText.getText());
    LOGGER.info(paragraphText.getText());
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
