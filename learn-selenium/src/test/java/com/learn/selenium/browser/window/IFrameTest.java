package com.learn.selenium.browser.window;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class IFrameTest {

  private static final Logger LOGGER = Logger.getLogger(IFrameTest.class.getName());
  private WebDriver webDriver;
  private static final String FOLDER_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/";
  private static final String FILE_PATH = "frames.html";
  private static final String FILE = "file://" + FOLDER_PATH + FILE_PATH;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE);
  }

  @Test
  void testIFrameContents() {
    String mainWindow = webDriver.getWindowHandle();
    String leftFrameText = getFrameText("left");
    Assertions.assertEquals("This is Left Frame", leftFrameText);

    //only main window has reference to other frame names
    webDriver.switchTo().window(mainWindow);

    String middleFrameText = getFrameText("middle");
    Assertions.assertEquals("This is Middle Frame", middleFrameText);
    webDriver.switchTo().window(mainWindow);

    String rightFrameText = getFrameText("right");
    Assertions.assertEquals("This is Right Frame", rightFrameText);
    webDriver.switchTo().window(mainWindow);
  }

  /**
   * Make webdriver switch to a specific frame, and assert its contents
   * @param frameId name/id of the frame
   * @return the text
   */
  private String getFrameText(String frameId) {
    webDriver.switchTo().frame(frameId);
    WebElement middleFrame = webDriver.findElement(By.tagName("p"));
    return middleFrame.getText();
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
