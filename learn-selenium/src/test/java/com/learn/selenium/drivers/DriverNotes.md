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


## Selenium Grid

- A Grid is a set of selenium nodes, with each node running on different platforms /driver.
<br/>
For example, node1 can run chrome driver, node2 can run firefox and node3 can run IE.

### How to Create a Grid ?

<br/>
- Step 1 : Create a Hub
Hub is similar to standalone server with additional  ``` -role hub``` parameter
All the nodes running different platforms will connect to this hub.

```
java -jar selenium-server-standalone-2.53.0.jar -port 4444 -role hub
```

- Step 2 : Create a Node for Chrome Driver <br/>

This is created on my local mac, so all nodes will use same platform. <br/>
Idea is that multiple OS can be specified on different nodes.

```
java -jar selenium-server-standalone-2.53.0.jar -Dwebdriver.chrome.driver=/usr/local/bin/chromedriver -role node -hub http://localhost:4444/grid/register -browser browserName=chrome -port 5555
```

```
java -jar selenium-server-standalone-2.53.0.jar -Dwebdriver.firefox.driver=/usr/local/bin/geckodriver -role node -hub http://localhost:4444/grid/register -browser browserName=firefox -port 6666
```

### Verify Selenium Grid set up

- Access the URL : ```http://localhost:4444/grid/console#```
- If run with both chrome and firefox, you should now see two configurations on the browser.

Grids are quite configurable and has multiple variants. It is also possible to set up grid
using a json file instead of specifying command line args.

An example NodeConfig JSON is seen here : <br/>
Link : [node-config.json](learn-selenium/src/main/resources/testpages/node-config.json)


Selenium Grid docs : [Selenium Grid docs](https://www.selenium.dev/documentation/en/grid/grid_4/setting_up_your_own_grid/)
