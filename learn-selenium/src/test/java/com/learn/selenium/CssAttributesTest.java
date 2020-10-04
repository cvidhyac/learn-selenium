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

class CssAttributesTest {

  private static final Logger LOGGER = Logger.getLogger(CssAttributesTest.class.getName());
  private WebDriver webDriver;
  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/scraping.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @AfterEach
  void tearDown() {
    this.webDriver.close();
    this.webDriver.quit();
  }

  @Test
  void test_cssAttributes_isSuccess() {
    WebElement webElement = webDriver.findElement(By.className("author-about"));
    String text = webElement.getText();
    String tagName = webElement.getTagName();
    String textColor = webElement.getCssValue("color");
    int locationXAxis = webElement.getLocation().getX();
    int locationYAxis = webElement.getLocation().getY();
    int elementHeight = webElement.getSize().getHeight();
    int elementWidth = webElement.getSize().getWidth();
    LOGGER.info("Text: " + text);
    LOGGER.info("TagName: " + tagName);
    LOGGER.info("Text Color: " + textColor);
    LOGGER.info("Location X Axis: " + locationXAxis);
    LOGGER.info("Location Y Axis: " + locationYAxis);
    LOGGER.info("Element Height: " + elementHeight);
    LOGGER.info("Element Width: " + elementWidth);
    Assertions.assertNotNull(text);
    Assertions.assertNotNull(tagName);
    Assertions.assertNotNull(textColor);
    Assertions.assertEquals(212, locationXAxis);
    Assertions.assertEquals(96, locationYAxis);
    Assertions.assertEquals(738, elementHeight);
    Assertions.assertEquals(600, elementWidth);
  }
}
