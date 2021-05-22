# react-app-acceptance

## Environment

- Java 11
- Maven
- Selenium Web driver
- Spring boot

## Install Web driver

* [Selenium Chrome Driver reference](https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver)
* [Download latest stable release from](https://sites.google.com/a/chromium.org/chromedriver/)

## Configure project's local file

- Create the file `src/main/java/resources/application-local.properties`
- Add the following properties:
    - `webdriver.driver.headless=false` if you want to work with a window (i.e: for debugging).
    - `webdriver.chrome.driver=<your_local_path_to_driver>`

## Run acceptance test
- `mvn clean package`
- `java -jar -Dspring.profiles.active=local target/react-app-acceptance-*.jar`
