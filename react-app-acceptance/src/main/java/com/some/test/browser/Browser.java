package com.some.test.browser;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.lang.String.format;
import static java.time.Instant.ofEpochMilli;
import static java.time.ZonedDateTime.ofInstant;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.logging.LogType.BROWSER;

@Component
public class Browser {

    private final WebDriver webDriver;

    public Browser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<String> getLogs() {
        return StreamSupport.stream(webDriver.manage().logs().get(BROWSER).spliterator(), false)
                .map(this::toLogString).collect(toList());
    }

    private String toLogString(LogEntry entry) {
        return format(
                "%s %s: %s",
                ofInstant(ofEpochMilli(entry.getTimestamp()), ZoneId.systemDefault()),
                entry.getLevel().getName(),
                entry.getMessage()
        );
    }

    public void setWindowSize(int width, int height) {
        webDriver.manage().window().setSize(new Dimension(width, height));
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void clearAndClose() {
        deleteAllCookies();
        deleteLocalStorage();
        close();
    }

    public void close() {
        webDriver.close();
    }

    public void deleteAllCookies() {
        webDriver.manage().deleteAllCookies();
    }

    public void addCookie(Cookie cookie) {
        webDriver.manage().addCookie(cookie);
    }

    public void deleteLocalStorage() {
        ((JavascriptExecutor) webDriver).executeScript("window.localStorage.clear();");
    }
}
