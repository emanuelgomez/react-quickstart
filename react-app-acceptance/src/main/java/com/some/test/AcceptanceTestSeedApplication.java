package com.some.test;

import org.junit.runner.JUnitCore;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AcceptanceTestSeedApplication {

    public static void main(String[] args) {
        JUnitCore.main(ITCucumber.class.getName());
    }
}
