package com.erp.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/CreateInvoiceERP.feature",
        glue = {"com.erp.com.stepdefinitions", "com.erp.com.hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        monochrome = true)
@Test
public class TestRunnerForCreateInvoice extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
