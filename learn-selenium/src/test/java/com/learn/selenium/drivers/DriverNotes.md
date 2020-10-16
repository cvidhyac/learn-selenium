## Driver notes

### Remote Web driver
* Needs a selenium server running (for remote web driver)
* specify chrome driver

### Run Selenium standalone server

* Download the jar from mvnrepository, and cd to the path.

#### Firefox
```
java -jar selenium-server-standalone-2.53.0.jar -Dwebdriver.firefox.driver=/usr/local/bin/geckodriver
```

#### Chrome
```
java -jar selenium-server-standalone-2.53.0.jar -Dwebdriver.chrome.driver=/usr/local/bin/chromedriver
```

#### Tip
To check where driver is located in macos : which chromedriver

### Accessing the server

When the server starts up, it can be located at : (Non-https)

- URL : http://localhost:4444
- Selenium console : http://localhost:4444/wd/hub
