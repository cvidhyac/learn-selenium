package com.learn.selenium.userinteractions;

import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

class ControlCommandTest {

  private static final Logger LOGGER = Logger.getLogger(ControlCommandTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/multiselect.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testMultipleElements() {

    Select select = new Select(webDriver.findElement(By.tagName("select")));
    List<WebElement> options = select.getOptions();

    Actions actions = new Actions(webDriver);
    //macos uses command for select, use ctrl for windows
    actions.click(options.get(1)).keyDown(Keys.COMMAND)
        .click(options.get(3)).keyUp(Keys.COMMAND).build().perform();

    List<WebElement> selectedOptions = select.getAllSelectedOptions();
    Assertions.assertEquals(2, selectedOptions.size());
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
