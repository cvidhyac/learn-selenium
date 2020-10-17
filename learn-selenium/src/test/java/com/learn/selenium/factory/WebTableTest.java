package com.learn.selenium.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class WebTableTest {

  private WebDriver webDriver;
  private static final String FOLDER_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/";
  private static final String FILE_PATH = "scrapeprices.html";
  private static final String FILE = "file://" + FOLDER_PATH + FILE_PATH;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE);
  }

  @Test
  void testTableContents_Size() {
    WebTable webTable = new WebTable(webDriver);
    Assertions.assertEquals(5, webTable.getRowSize());
    Assertions.assertEquals(12, webTable.getColumnSize());
  }

  @Test
  void testCellData() {
    WebTable webTable = new WebTable(webDriver);
    Assertions.assertEquals("25", webTable.getCellData(2, 2));
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
