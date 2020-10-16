# learn-selenium

Learn basic selenium concepts for automating simple UI testing.

## Notes
* Use chrome driver (install via brew in macos)
* Use "Inspect" option in chrome developer tools to understand structure of web page.
* Css styles displayed in the bottom of the developer tools tab.

## Locate Elements

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

[CSS Attributes](learn-selenium/src/test/java/com/learn/selenium/locateelements/LocateCssAttributesTest.java) <br/>
Find CSS Attributes in a web element and assert values. <br/>
<br/>

[Print website data](learn-selenium/src/test/java/com/learn/selenium/locateelements/WebtableDataTest.java) <br/>
Print data in rows and columns from a html table <br/>

[HTML CSS Selector](learn-selenium/src/test/java/com/learn/selenium/locateelements/LocateByCssSelectorTest.java) <br/>
HTML CSS Selector test, and print row elements <br/>
- Tip : Use chrome devtools to copy css selector (Inspect -> Copy -> Copy Selector) <br/>

[XPath expressions](learn-selenium/src/test/java/com/learn/selenium/locateelements/LocateByXPathTest.java) <br/>
Find element by xpath expression

## User Interactions

[Button click](learn-selenium/src/test/java/com/learn/selenium/userinteractions/ButtonClickTest.java) <br/>
Two buttons (increase, decrease) to see if CSS attribute to increase/decrease font size works

[Search on Google](learn-selenium/src/test/java/com/learn/selenium/userinteractions/GoogleSearchTest.java) <br/>
Search a term in google search and see if it works

[Understand Dropdowns](learn-selenium/src/test/java/com/learn/selenium/userinteractions/DropdownTest.java) <br/>
Simple example to understand how dropdowns work, and different methods in it

[List contents in Dropdown](learn-selenium/src/test/java/com/learn/selenium/userinteractions/ListPropertiesTest.java) <br/>
Verify if dropdown is multiple and validate contents

[Radio Button](learn-selenium/src/test/java/com/learn/selenium/userinteractions/RadioButtonTest.java) <br/>
Verify if element is selected, if not click and select to toggle the state

[Check Box](learn-selenium/src/test/java/com/learn/selenium/userinteractions/CheckboxTest.java) <br/>
Verify if check box is selected, if selected unselct it.

[Multi-Select Dropdown](learn-selenium/src/test/java/com/learn/selenium/userinteractions/ControlCommandTest.java) <br/>
Use Action keyUp and keyDown to select multiple elements from a dropdown where multi-select is allowed.

[Double Click Action](learn-selenium/src/test/java/com/learn/selenium/userinteractions/DoubleClickTest.java) <br/>
Demonstrate doubleClick in Action builder and see if javascript function returns right value

[Drag and Drop](learn-selenium/src/test/java/com/learn/selenium/userinteractions/DragAndDropTest.java) <br/>
How to test drag and drop action involving an intermediate javascript function.

## Browser Interactions

[Browser Navigation](learn-selenium/src/test/java/com/learn/selenium/browser/interactions/BrowserNavigationTest.java) 
<br/>
Demonstrate website navigation using browser back, forward, refresh

[Window Maximize](learn-selenium/src/test/java/com/learn/selenium/browser/interactions/WindowMaximizeTest.java) 
<br/>
Window Maximize test

[Session Cookies](learn-selenium/src/test/java/com/learn/selenium/browser/interactions/SessionCookieTest.java)
<br/>
Session cookies - get cookie from website

[Timeouts](learn-selenium/src/test/java/com/learn/selenium/browser/interactions/ScheduleTimeoutTest.java)
<br/>
Adding wait times, implict timeout and explicit timeout condition

## Browser Window Validation

[Html Frame Navigation](learn-selenium/src/test/java/com/learn/selenium/browser/window/HtmlFrameTest.java)
<br/>
Switch to child html pages using HTML frames and assert the contents, switch to main window

[IFrame Navigation](learn-selenium/src/test/java/com/learn/selenium/browser/window/IFrameTest.java)
<br/>
IFrame switch and asserting website content

[Popup Test](learn-selenium/src/test/java/com/learn/selenium/browser/window/PopupTest.java)
<br/>
Flip betwee popups and print titles in each popup

[Alert Test](learn-selenium/src/test/java/com/learn/selenium/browser/window/AlertTest.java)
<br/>
How to find Alert box from screen, and close it by automation.

## Drivers

[Drivers] 

[Standalone Set up](learn-selenium/src/test/java/com/learn/selenium/drivers/DriverNotes.md)
<br/>
Start selenium server locally with cli options

[Screenshot](learn-selenium/src/test/java/com/learn/selenium/drivers/ScreenshotTest.java)
<br/>
- How to capture a screenshot and access the screenshot file
- How to capture screenshot of a specific section of the page