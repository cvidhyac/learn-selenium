package com.learn.selenium.userinteractions;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Search the google website for the given keyword.
 * Observe the usage of sendKeys and submit.
 */
public class GoogleSearchTest {

  private static final Logger LOGGER = Logger.getLogger(GoogleSearchTest.class.getName());
  private WebDriver webDriver;

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get("https://www.google.com");
  }

  @Test
  void testGoogleHomePage() {

    //google search home page text box has name as "q"
    WebElement qBox = webDriver.findElement(By.name("q"));
    qBox.clear();
    qBox.sendKeys("US Presidential Elections");

    //When you inspect the webpage, the button is of type submit, click will not work hence submit
    WebElement searchButton = webDriver.findElement(By.name("btnK"));
    searchButton.submit();

  }


  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
