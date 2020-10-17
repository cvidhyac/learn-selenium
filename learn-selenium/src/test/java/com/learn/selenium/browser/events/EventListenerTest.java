package com.learn.selenium.browser.events;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

class EventListenerTest {

  private static final Logger LOGGER = Logger.getLogger(EventListenerTest.class.getName());
  private WebDriver webDriver;
  private static final String FOLDER_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/";
  private static final String FILE_PATH = "button.html";
  private static final String FILE = "file://" + FOLDER_PATH + FILE_PATH;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE);
  }

  @Test
  void testEventListener() {
    EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
    eventFiringWebDriver.register(new ClickEventListener());

    WebElement element = eventFiringWebDriver.findElement(By.id("increase"));
    element.click();
    Assertions.assertEquals("50px", eventFiringWebDriver.findElement(By.id("demo")).getCssValue("font-size"));
  }
  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
