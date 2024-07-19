package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.DashboardPage;
import io.cucumber.java.en.Given;

public class DashboardSteps {
    TestContext testContext;
    DashboardPage dashboardPage;

    public DashboardSteps(TestContext testContext) {
        this.testContext = testContext;
        dashboardPage = testContext.getDashboardPage();
    }

    @Given("User is already on the dashboard page")
    public void userIsAlreadyOnTheDashboardPage() {
        dashboardPage.goToDashBoardPage();
    }
}
