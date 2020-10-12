package com.learn.selenium.userinteractions;

import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {

  private static final Logger LOGGER = Logger.getLogger(DropdownTest.class.getName());
  private WebDriver webDriver;

  private static final String FILE_PATH = "/Users/vchidamb/Softwares/pet_projects/learn-selenium/learn-selenium/src/main/resources/testpages/dropdown.html";
  private static final String FILE_PROTOCOL = "file://";

  @BeforeEach
  void setUp() {
    this.webDriver = new ChromeDriver();
    webDriver.get(FILE_PROTOCOL.concat(FILE_PATH));
  }

  @Test
  void testDropdown_isMultiple() {
    Select carsDD = new Select(webDriver.findElement(By.tagName("select")));

    //size of dropdown
    Assertions.assertEquals(4, carsDD.getOptions().size());

    //is multi-select dropdown
    Assertions.assertFalse(carsDD.isMultiple());

    //choose a selection from dropdown
    carsDD.selectByVisibleText("Opel");
    Assertions.assertEquals("Opel", carsDD.getFirstSelectedOption().getText());

    carsDD.selectByIndex(1);
    Assertions.assertEquals("Saab", carsDD.getFirstSelectedOption().getText());
  }


  @AfterEach
  void tearDown() {
    webDriver.close();
    webDriver.quit();
  }

}
