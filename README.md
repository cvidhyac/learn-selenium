# learn-selenium

Learn basic selenium concepts for automating simple UI testing.

## Notes
* Use chrome driver (install via brew in macos)
* Use "Inspect" option in chrome developer tools to understand structure of web page.
* Css styles displayed in the bottom of the developer tools tab.

## Exercises

[Selenium Setup](learn-selenium/src/test/java/com/learn/selenium/locateelements/SeleniumSetupTest.java) <br/>
Test Chrome driver loads post installation, How to start and stop driver
<br/>

[Locate Single Element](learn-selenium/src/test/java/com/learn/selenium/locateelements/LocateOneElementTest.java) <br/>
How to find single element from a html page? <br/>
- Learn usage of WebElement and By classname

[Locate Multiple Elements](learn-selenium/src/test/java/com/learn/selenium/locateelements/LocateMultipleElementsTest.java) <br/>
How to find single element from a html page?<br/>
- Learn usage of List variant of WebElement

[Locate Hyperlink](learn-selenium/src/test/java/com/learn/selenium/locateelements/LocateHyperlinksTest.java) <br/>
Find the assigned hyperlink against href attribute. <br/>
- Learn usage of By.linkText and By.partialLinkText
- Learn usage of By.tagName and retrieve the <a> tag

[CSS Attributes](learn-selenium/src/test/java/com/learn/selenium/locateelements/CssAttributesTest.java) <br/>
Find CSS Attributes in a web element and assert values. <br/>
<br/>

[Print website data](learn-selenium/src/test/java/com/learn/selenium/locateelements/WebtableDataTest.java) <br/>
Print data in rows and columns from a html table <br/>

[HTML CSS Selector](learn-selenium/src/test/java/com/learn/selenium/locateelements/CssSelectorTest.java) <br/>
HTML CSS Selector test, and print row elements <br/>
- Tip : Use chrome devtools to copy css selector (Inspect -> Copy -> Copy Selector) <br/>