package com.learn.selenium.userinteractions;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListPropertiesTest {

  private static final Logger LOGGER = Logger.getLogger(ListPropertiesTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/multiselect.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testMultiselect() {
    Select mCarsDD = new Select(webDriver.findElement(By.tagName("select")));
    Assertions.assertEquals(4, mCarsDD.getOptions().size());
    Assertions.assertTrue(mCarsDD.isMultiple());
    Assertions.assertArrayEquals(expectedOptions().toArray(), mCarsDD.getOptions().stream()
        .map(WebElement::getText).toArray());
  }

  private List<String> expectedOptions() {
    List<String> options = new LinkedList<>();
    options.add("Volvo");
    options.add("Saab");
    options.add("Opel");
    options.add("Audi");
    return options;
  }

  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
