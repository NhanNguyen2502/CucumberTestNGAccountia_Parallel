package com.erp.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "src/test/resources/features/SupplierTableERP.feature",
        glue = {"com.erp.com.stepdefinitions",
                "com.erp.com.common",
                "com.erp.com.hooks"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        tags = ""
)


@Test
public class TestRunnerForSupplierTable extends AbstractTestNGCucumberTests {
}
