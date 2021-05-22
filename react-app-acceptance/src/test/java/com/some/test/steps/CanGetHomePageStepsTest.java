package com.some.test.steps;

import com.some.test.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class CanGetHomePageStepsTest {

    private HomePage homePage;
    private CanGetHomePageSteps steps;

    @BeforeEach
    void setUp() {
        homePage = mock(HomePage.class);
        steps = new CanGetHomePageSteps(homePage);
    }

    @Test
    void can_be_user() {
        //When
        steps.iAmAUser();
    }

    @Test
    void can_go_to_home_page() {

        //When
        steps.iGoToTheHomePage();

        //Then
        then(homePage).should().visit();
    }

    @Test
    void can_see_home_page() {

        //Given
        given(homePage.getTitle()).willReturn("React App");

        //When
        steps.iShouldSeeTheHomePage();

        //Then
        then(homePage).should().getTitle();
    }
}
