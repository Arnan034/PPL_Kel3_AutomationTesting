package io.cucumber.zaidan.stepDefinition;

import io.cucumber.zaidan.utils.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Initial {

    @Before
    public void setUp() {
        Driver.setUpDriver();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
