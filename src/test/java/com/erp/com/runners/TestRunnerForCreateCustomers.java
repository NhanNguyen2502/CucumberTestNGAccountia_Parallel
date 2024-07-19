package com.erp.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/createCustomerERP.feature",
        glue = {"com.erp.com.stepdefinitions", "com.erp.com.hooks", "com.erp.com.common"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,
        tags = ""
)
@Test
public class TestRunnerForCreateCustomers extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}