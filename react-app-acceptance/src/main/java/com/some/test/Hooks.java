package com.some.test;

import com.some.test.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@ContextConfiguration(classes = ITCucumber.class)
@SpringBootTest(classes = ITCucumber.class, webEnvironment = DEFINED_PORT)
public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private final Browser browser;

    public Hooks(Browser browser) {
        this.browser = browser;
    }

    @Before
    public void setup() {
        // No Op
        browser.deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Scenario {} end", scenario.getName());
        if (scenario.isFailed()) {
            browser.getLogs().forEach(log::error);
            browser.deleteAllCookies();
        }
    }
}
