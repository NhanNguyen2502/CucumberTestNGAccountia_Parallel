package com.erp.com.stepdefinitions;

import com.erp.com.common.BaseSetup;
import com.erp.com.hooks.TestContext;
import com.erp.com.pages.CompanyListPage;
import com.erp.com.pages.LoginPage;
import erp.com.company.CompanyHelpers;
import erp.com.constants.ConstantGlobal;

import static erp.com.ulitilities.WebUI.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanyTableSteps {
    TestContext testContext;
    LoginPage loginPage;
    CompanyListPage companyListPage;

    public CompanyTableSteps(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getLoginPage();
        companyListPage = testContext.getCompanyListPage();
    }

    @Given("Users logged")
    public void usersLoggedWithAnd() {
        openURL(ConstantGlobal.URL);
        loginPage.enterEmailAndPassword(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        loginPage.clickLogin();
    }

    @Given("User access to company list")
    public void userAccessTheCompanyList() {
        companyListPage.verifyCompanyListTitle();
    }

    @When("User click on the company")
    public void userClickOnTheCompany() {
        companyListPage.selectCompanyBaseOnCompanyType(CompanyHelpers.getTypeCompany(ConstantGlobal.COMPANY_TYPE, ConstantGlobal.LANGUAGE_ENGLISH));
    }

    @Then("User should be taken to the Dashboard")
    public void theUserRedirectToDashboardPage() {
        companyListPage.verifyRedirectToDashboard();

    }

    @When("User click on the company that has {string}")
    public void userClickOnTheCompanyThatHas(String companyType) {
        companyListPage.selectCompanyBaseOnCompanyTypeOfExample(companyType);
    }

    @Then("User will not be taken to the dashboard page")
    public void userWillNotBeTakenToTheDashboardPage() {
        companyListPage.verifyNotRedirectTDashboard();
    }

    @Then("User still on the company list page")
    public void userStillOnTheCompanyListPage() {
        companyListPage.verifyCompanyListTitle();
    }
}
