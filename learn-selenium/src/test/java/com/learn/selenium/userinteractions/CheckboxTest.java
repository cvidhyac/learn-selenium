package com.learn.selenium.userinteractions;

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

public class CheckboxTest {

  private static final Logger LOGGER = Logger.getLogger(CheckboxTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/check.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testCheckBox_isChecked() {
    List<WebElement> checkBoxList = webDriver.findElements(By.xpath("//input[@type='checkbox' and @name='vehicle']"));
    Assertions.assertEquals(2, checkBoxList.size());
    checkBoxList.forEach(element -> {
      if(!element.isSelected()) {
        element.click();
        LOGGER.info("State of : " + element.getText() + " is now : " + element.isSelected());
        element.click();
        LOGGER.info("Clearing input now ..");
        LOGGER.info("State of : " + element.getText() + " is now : " + element.isSelected());
      }
    });

  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
