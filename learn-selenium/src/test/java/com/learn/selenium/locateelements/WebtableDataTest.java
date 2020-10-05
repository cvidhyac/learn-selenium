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

class WebtableDataTest {

  private static Logger LOGGER = Logger.getLogger(LocateOneElementTest.class.getName());
  private WebDriver webDriver;
  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/scrapeprices.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }


  @Test
  void testWebsiteTable_isSuccess() {
    List<WebElement> rowElements = webDriver.findElements(By.tagName("tr"));
    Assertions.assertEquals(5, rowElements.size());
    rowElements.forEach(rowElement -> {
      List<WebElement> columnElements =  rowElement.findElements(By.tagName("td"));
      columnElements.forEach(columnElement -> {
        Assertions.assertNotNull(columnElement.getText());
        LOGGER.info(columnElement.getText());
      });
    });
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }
}
