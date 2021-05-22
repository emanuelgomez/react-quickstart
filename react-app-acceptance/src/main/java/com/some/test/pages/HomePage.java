package com.some.test.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage {

    private final String baseUrl;
    private final WebDriver driver;

    public HomePage(@Value("${acceptance.base.url}") String baseUrl, WebDriver driver) {
        this.baseUrl = baseUrl;
        this.driver = driver;
    }

    public void visit() {
        driver.get(baseUrl);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
