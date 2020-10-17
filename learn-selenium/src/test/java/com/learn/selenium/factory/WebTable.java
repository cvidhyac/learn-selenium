package com.learn.selenium.factory;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A reusable web table wrapper to read rows and columns
 * and assert contents
 */
public class WebTable {

  private WebDriver webDriver;

  public WebTable(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  private List<WebElement> getRows() {
    return webDriver.findElements(By.tagName("tr"));
  }

  private List<WebElement> getColumns() {
    return webDriver.findElements(By.tagName("td"));
  }

  public int getRowSize() {
    return getRows().size();
  }

  public int getColumnSize() {
    return getColumns().size();
  }

  public String getCellData(int rowId, int columnId) {
    WebElement row = getRows().get(rowId);
    //get all columns in this row
    List<WebElement> columns = row.findElements(By.tagName("td"));
    return columns.get(columnId).getText();
  }
}
