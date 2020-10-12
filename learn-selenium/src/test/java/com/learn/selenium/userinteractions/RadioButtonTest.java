package com.learn.selenium.userinteractions;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {

  private static final Logger LOGGER = Logger.getLogger(RadioButtonTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/check.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  /**
   * Radio buttons have a property "checked" as default,
   * More than one element belonging to the same group, then only one of them can be selected.
   */
  @Test
  void testRadioButton_isSelected() {
    WebElement element = webDriver.findElement(By.xpath("//input[@type='radio' and @value='female']"));
    if(!element.isSelected()) {
      element.click();
      Assertions.assertTrue(element.isSelected());
    } else {
      LOGGER.info("No action executed");
      fail();
    }

  }


  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
