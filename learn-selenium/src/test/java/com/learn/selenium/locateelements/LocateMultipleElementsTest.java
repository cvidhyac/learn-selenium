package com.learn.selenium.locateelements;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LocateMultipleElementsTest {

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/scraping.html";
  private static final String FILE_PROTOCOL = "file://";
  private WebDriver webDriver;

  @BeforeEach
  public void setUp() {
    webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testCourseList_isSuccess() {
    List<WebElement> webElements = webDriver.findElements(By.className("course-title"));
    webElements.forEach(element -> Assertions.assertNotNull(element.getText()));
  }

  @AfterEach
  public void tearDown() {
    webDriver.close();
    webDriver.quit();

  }
}
