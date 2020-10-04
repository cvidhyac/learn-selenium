package com.learn.selenium;

import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LocateHyperlinksTest {

  private static final Logger LOGGER = Logger.getLogger(LocateHyperlinksTest.class.getName());
  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/scraping.html";
  private static final String FILE_PROTOCOL = "file://";
  private WebDriver webDriver;

  @BeforeEach
  void setUp() {
    webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testHyperlink_ByLinkText_isSuccess() {
    WebElement webElement = webDriver.findElement(By.linkText("Location"));
    String hrefString = webElement.getAttribute("href");
    Assertions.assertNotNull(hrefString);
    LOGGER.info(hrefString);
  }

  @Test
  void testPartialHyperlink_isSuccess() {
    WebElement webElement = webDriver.findElement(By.partialLinkText("Contact"));
    String hrefString = webElement.getAttribute("href");
    Assertions.assertNotNull(hrefString);
    LOGGER.info(hrefString);
  }

  @Test
  void testHyperLink_byTagName_isSuccess() {
    List<WebElement> webElements = webDriver.findElements(By.tagName("a"));
    Assertions.assertEquals(2, webElements.size());
    webElements.forEach(element -> {
      String hrefString = element.getAttribute("href");
      LOGGER.info(hrefString);
      Assertions.assertNotNull(hrefString);
    });

  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
