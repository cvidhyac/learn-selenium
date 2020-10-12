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

class DragAndDropTest {

  private static final Logger LOGGER = Logger.getLogger(DragAndDropTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/draganddrop.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testDragAndDrop() {
    WebElement drag = webDriver.findElement(By.id("draggable"));
    WebElement drop = webDriver.findElement(By.id("droppable"));
    Actions actions = new Actions(webDriver);
    actions.dragAndDrop(drag, drop).perform();
    //Text returned by javascript
    Assertions.assertEquals("Dropped!", drop.getText());
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
