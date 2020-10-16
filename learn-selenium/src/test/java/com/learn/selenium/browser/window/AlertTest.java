package com.learn.selenium.browser.window;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AlertTest {

  private static final Logger LOGGER = Logger.getLogger(AlertTest.class.getName());
  private WebDriver webDriver;
  private static final String FOLDER_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/";
  private static final String FILE_PATH = "alerts.html";
  private static final String FILE = "file://" + FOLDER_PATH + FILE_PATH;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE);
  }

  @Test
  void testAlertBox() {
    webDriver.findElement(By.id("simple")).click();
    WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
    webDriverWait.until(ExpectedConditions.alertIsPresent());
    Alert alert = webDriver.switchTo().alert();
    Assertions.assertNotNull(alert.getText());
    LOGGER.info(alert.getText());
    alert.accept();
  }


  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
