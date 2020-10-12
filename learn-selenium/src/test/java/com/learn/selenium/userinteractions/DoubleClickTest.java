package com.learn.selenium.userinteractions;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class DoubleClickTest {

  private static final Logger LOGGER = Logger.getLogger(DoubleClickTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/doubleclick.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testDoubleClick() {

    WebElement messageElement = webDriver.findElement(By.id("message"));
    //blue
    Assertions.assertEquals("rgba(0, 0, 255, 1)", messageElement.getCssValue("background-color"));
    Actions actions = new Actions(webDriver);
    actions.doubleClick(messageElement).perform();
    //yellow
    Assertions.assertEquals("rgba(255, 255, 0, 1)", messageElement.getCssValue("background-color"));
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
