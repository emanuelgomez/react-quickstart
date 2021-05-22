package com.some.test.steps;

import com.some.test.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CanGetHomePageSteps {

    private final HomePage homePage;

    public CanGetHomePageSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("I am a user")
    public void iAmAUser() {
        // No op
    }

    @When("I go to the home page")
    public void iGoToTheHomePage() {
        homePage.visit();
    }

    @Then("I should see the home page")
    public void iShouldSeeTheHomePage() {
        final String title = homePage.getTitle();
        assertThat(title, is(not(nullValue())));
        assertThat(title, is("React App"));
    }
}
