package com.erp.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features/FeeTableERP.feature", glue = {"com.erp.com.stepdefinitions", "com.erp.com.hooks"}, plugin = {"pretty", "html:target/cucumber-html-report.html"}, monochrome = true)
@Test
public class TestRunnerForFeesTable extends AbstractTestNGCucumberTests {
}
