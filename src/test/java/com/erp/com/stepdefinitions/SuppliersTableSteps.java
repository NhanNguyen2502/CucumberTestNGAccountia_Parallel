package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.contactPage.SuppliersTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuppliersTableSteps {
    TestContext testContext;
    SuppliersTablePage suppliersTablePage;

    public SuppliersTableSteps(TestContext testContext) {
        this.testContext = testContext;
        suppliersTablePage = testContext.getSuppliersTablePage();
    }

    @Given("User is already on the supplier table")
    public void userIsAlreadyOnTheSupplierTable() {
        suppliersTablePage.goToSupplierTable();
    }

    @When("Users enters keywords to the supplier search input")
    public void usersEntersKeywordsToTheSupplierSearchInput() {
        suppliersTablePage.searchSupplierName("a123123");
    }

    @Then("Products related to the keyword are shown on then supplier table")
    public void productsRelatedToTheKeywordAreShownOnThenSupplierTable() {
        suppliersTablePage.verifyAfterSearch();
    }

    @When("User enter {string} to the supplier search input")
    public void userEnterToTheSupplierSearchInput(String arg0) {
        suppliersTablePage.searchSupplierName(arg0);
    }

    @When("User select {string} on the supplier status filter")
    public void userSelectOnTheSupplierStatusFilter(String arg0) {
        suppliersTablePage.selectFilterOptions(arg0);
    }
}
