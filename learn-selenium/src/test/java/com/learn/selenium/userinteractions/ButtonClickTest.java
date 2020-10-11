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

/**
 * Test if button click works
 */
public class ButtonClickTest {

  private static final Logger LOGGER = Logger.getLogger(ButtonClickTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/button.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  /**
   * On click button increase size would increase to 50px
   * On click button decrease size would increase to 30px
   */
  @Test
  void testClickButton_increase() {
    WebElement increaseButton = webDriver.findElement(By.id("increase"));

    //before click
    WebElement paragraphElement = webDriver.findElement(By.id("demo"));
    Assertions.assertEquals("40px", paragraphElement.getCssValue("font-size"));

    //after click
    increaseButton.click();
    Assertions.assertEquals("50px", paragraphElement.getCssValue("font-size"));

  }

  @Test
  void testClickButton_decrease() {
    WebElement decreaseButton = webDriver.findElement(By.id("decrease"));

    WebElement paragraphElement = webDriver.findElement(By.id("demo"));
    Assertions.assertEquals("40px", paragraphElement.getCssValue("font-size"));
    decreaseButton.click();
    Assertions.assertEquals("30px", paragraphElement.getCssValue("font-size"));
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
