package com.quinbay.travel.cucumber;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {
    static WebDriver driver;
    @Before
    public void before()
    {
        System.out.println("Before execution");

    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void after()
    {
        System.out.println("After execution");
    }
}
