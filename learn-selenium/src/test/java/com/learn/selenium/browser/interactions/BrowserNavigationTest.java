package com.learn.selenium.browser.interactions;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BrowserNavigationTest {

  private WebDriver webDriver;
  private static final String FOLDER_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/";
  private static final String FILE_PATH = "mytestfile.html";
  private static final String FILE = "file://" + FOLDER_PATH + FILE_PATH;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    //non-existent file added to see if browser back works
    webDriver.get(FILE);
  }

  @Test
  void browserNavigationTest() throws InterruptedException {
    webDriver.navigate().to("https://www.google.com");
    String currentWindow = webDriver.getWindowHandle();
    Thread.sleep(5000);
    webDriver.navigate().back();
    Thread.sleep(5000);
    webDriver.navigate().forward();
    Thread.sleep(5000);
    webDriver.navigate().refresh();
    Thread.sleep(2000);
    String finalWindowHandle = webDriver.getWindowHandle();
    Assertions.assertEquals(currentWindow, finalWindowHandle);
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
