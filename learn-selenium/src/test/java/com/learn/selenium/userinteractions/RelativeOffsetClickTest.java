package com.learn.selenium.userinteractions;

import java.util.logging.Logger;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RelativeOffsetClickTest {

  private static final Logger LOGGER = Logger.getLogger(RelativeOffsetClickTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/button.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  //TODO - example does not work
  @Ignore
  @Test
  void testClickButton_byLocation() {

    //Get web elements needed from the web page
    WebElement increaseButton = webDriver.findElement(By.id("increase"));
    WebElement decreaseButton = webDriver.findElement(By.id("decrease"));
    WebElement paragraphElement = webDriver.findElement(By.id("demo"));

    Assertions.assertEquals("40px", paragraphElement.getCssValue("font-size"));
    increaseButton.click();
    Assertions.assertEquals("50px", paragraphElement.getCssValue("font-size"));

    clickByOffset(increaseButton, decreaseButton, paragraphElement);

  }

  private void clickByOffset(WebElement increaseButton, WebElement decreaseButton, WebElement paragraphElement) {

    //offset should be positive
    int xOffset = decreaseButton.getLocation().getX()-increaseButton.getLocation().getX();
    LOGGER.info("Value of offset is " + xOffset);

    //+1 to avoid out of bounds error
    Actions action = buildAction(webDriver);
    action.moveByOffset(xOffset+1, 0).click().click().perform();
    Assertions.assertEquals("30px", paragraphElement.getCssValue("font-size"));

  }
  private Actions buildAction(WebDriver webDriver) {
    return new Actions(webDriver);
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
