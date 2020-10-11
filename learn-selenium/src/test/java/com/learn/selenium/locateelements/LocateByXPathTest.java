package com.learn.selenium.locateelements;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXPathTest {

  private static final Logger LOGGER = Logger.getLogger(LocateByXPathTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/scraping.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testByXpath() {
    WebElement pElement = webDriver.findElement(By.xpath("/html/body/div/p"));
    WebElement firstOccurencePElement = webDriver.findElement(By.xpath("//div//p"));

    Assertions.assertNotNull(pElement.getText());
    Assertions.assertNotNull(firstOccurencePElement.getText());

    LOGGER.info(pElement.getText());
    LOGGER.info(firstOccurencePElement.getText());
  }

  @AfterEach
  public void tearDown() {
    webDriver.close();
    webDriver.quit();

  }
}
