package com.learn.selenium.locateelements;

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

class LocateByCssSelectorTest {
  private static final Logger LOGGER = Logger.getLogger(LocateByCssSelectorTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/scrapeprices.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testCssSelector_Hours() {
    List<WebElement> rowElements = webDriver.findElements(By.cssSelector("body > table > tbody > tr > td"));
    Assertions.assertNotNull(rowElements);
    rowElements.forEach(row -> {
      Assertions.assertNotNull(rowElements);
      String text = row.getText();
      Assertions.assertNotNull(text);
      LOGGER.info("Text value against column : " + text);
    });
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
