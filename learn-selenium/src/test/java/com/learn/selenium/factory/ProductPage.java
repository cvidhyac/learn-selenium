package com.learn.selenium.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject is a model in selenium to promote code reuse. Each developer would use the common
 * attributes related to a product page Any tests written to test this page will use this factory.
 * <p>
 * Can also be interpreted as a POJO class representing the attribute elements in product.html
 */
public class ProductPage {

  @FindBy(className = "course-title")
  private WebElement courseName;

  @FindBy(className = "course-length")
  private WebElement courseLength;

  @FindBy(className = "course-desc")
  private WebElement courseDesc;

  @FindBy(className = "course-price")
  private WebElement price;

  private WebDriver webDriver;

  public ProductPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    //Note usage of selenium page factory interface
    PageFactory.initElements(webDriver, this);
  }

  public WebElement getCourseName() {
    return courseName;
  }

  public void setCourseName(WebElement courseName) {
    this.courseName = courseName;
  }

  public WebElement getCourseLength() {
    return courseLength;
  }

  public void setCourseLength(WebElement courseLength) {
    this.courseLength = courseLength;
  }

  public WebElement getCourseDesc() {
    return courseDesc;
  }

  public void setCourseDesc(WebElement courseDesc) {
    this.courseDesc = courseDesc;
  }

  public WebElement getPrice() {
    return price;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  public String toString() {
    return "Course Name :".concat(getCourseName().getText()).concat(",")
        .concat("Course Length : ".concat(getCourseLength().getText()).concat(","))
        .concat("Course Desc: ".concat(getCourseDesc().getText()).concat(","))
        .concat("Course Price: ".concat(getPrice().getText()));
  }

}
