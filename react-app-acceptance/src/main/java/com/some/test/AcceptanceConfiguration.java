package com.some.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class AcceptanceConfiguration {

    private ChromeDriver chromeDriver;

    @Bean
    public ChromeDriver webDriver(
            @Value("${webdriver.chrome.driver}") String path,
            @Value("${webdriver.driver.headless}") boolean headless) {
        System.setProperty("webdriver.chrome.driver", path);
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(headless);
        chromeDriver = new ChromeDriver(chromeOptions);
        return this.chromeDriver;
    }

    @PreDestroy
    public void quitWebDriver(){
        chromeDriver.quit();
    }
}
