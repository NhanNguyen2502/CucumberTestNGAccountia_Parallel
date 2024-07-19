package com.erp.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/LoginERP.feature",
        glue = {"com.erp.com.stepdefinitions", "com.erp.com.hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)
@Test
public class TestRunnerForLogin extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}