package com.some.test.pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

class HomePageTest {

    private WebDriver driver;
    private String baseUrl;
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        driver = mock(WebDriver.class);
        baseUrl = someString();
        homePage = new HomePage(baseUrl, driver);
    }

    @Test
    void can_visit() {

        //When
        homePage.visit();

        //Then
        then(driver).should().get(baseUrl);
    }

    @Test
    void can_get_title() {
        //When
        homePage.getTitle();

        //Then
        then(driver).should().getTitle();
    }
}
