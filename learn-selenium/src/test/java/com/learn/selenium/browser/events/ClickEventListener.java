package com.learn.selenium.browser.events;

import java.io.File;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class ClickEventListener implements WebDriverEventListener {

  private static final Logger LOGGER = Logger.getLogger(ClickEventListener.class.getName());
  @Override
  public void beforeAlertAccept(WebDriver webDriver) {

  }

  @Override
  public void afterAlertAccept(WebDriver webDriver) {

  }

  @Override
  public void afterAlertDismiss(WebDriver webDriver) {

  }

  @Override
  public void beforeAlertDismiss(WebDriver webDriver) {

  }

  @Override
  public void beforeNavigateTo(String s, WebDriver webDriver) {

  }

  @Override
  public void afterNavigateTo(String s, WebDriver webDriver) {

  }

  @Override
  public void beforeNavigateBack(WebDriver webDriver) {

  }

  @Override
  public void afterNavigateBack(WebDriver webDriver) {

  }

  @Override
  public void beforeNavigateForward(WebDriver webDriver) {

  }

  @Override
  public void afterNavigateForward(WebDriver webDriver) {

  }

  @Override
  public void beforeNavigateRefresh(WebDriver webDriver) {

  }

  @Override
  public void afterNavigateRefresh(WebDriver webDriver) {

  }

  @Override
  public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

  }

  @Override
  public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

  }

  @Override
  public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    try {
      File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
      Assertions.assertNotNull(screenshot);
      Assertions.assertTrue(screenshot.exists());
      Thread.sleep(2000);
      screenshot.deleteOnExit();
      LOGGER.info("Before Click ON invoked");

    } catch(Exception e) {
      //doNothing
    }
  }

  @Override
  public void afterClickOn(WebElement webElement, WebDriver webDriver) {
    try {
      File afterScreenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
      Assertions.assertNotNull(afterScreenshot);
      Assertions.assertTrue(afterScreenshot.exists());
      Thread.sleep(2000);
      afterScreenshot.deleteOnExit();
      LOGGER.info("After Click ON invoked");
    } catch(Exception e) {
      //doNothing
    }
  }

  @Override
  public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver,
      CharSequence[] charSequences) {

  }

  @Override
  public void afterChangeValueOf(WebElement webElement, WebDriver webDriver,
      CharSequence[] charSequences) {

  }

  @Override
  public void beforeScript(String s, WebDriver webDriver) {

  }

  @Override
  public void afterScript(String s, WebDriver webDriver) {

  }

  @Override
  public void beforeSwitchToWindow(String s, WebDriver webDriver) {

  }

  @Override
  public void afterSwitchToWindow(String s, WebDriver webDriver) {

  }

  @Override
  public void onException(Throwable throwable, WebDriver webDriver) {

  }

  @Override
  public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

  }

  @Override
  public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

  }

  @Override
  public void beforeGetText(WebElement webElement, WebDriver webDriver) {

  }

  @Override
  public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

  }
}
