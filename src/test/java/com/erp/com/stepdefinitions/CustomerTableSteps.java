package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.contactPage.CustomersTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerTableSteps {
    private CustomersTablePage customerTablePage;
    TestContext testContext;

    public CustomerTableSteps(TestContext testContext) {
        this.testContext = testContext;
        customerTablePage = testContext.getCustomersTablePage();
    }

    @Given("User is already on the customer table")
    public void userIsAlreadyOnTheCustomerTable() {
        customerTablePage.goToCustomerTable();
    }

    @When("Users enters keywords to the customer search input")
    public void usersEntersKeywordsToTheCustomerSearchInput() {
        customerTablePage.searchCustomerName("a123123");
    }

    @Then("Products related to the keyword are shown on then customer table")
    public void productsRelatedToTheKeywordAreShownOnThenCustomerTable() {
        customerTablePage.verifyAfterSearch();
    }

    @When("User enter {string} to the customer search input")
    public void userEnterToTheCustomerSearchInput(String arg0) {
        customerTablePage.searchCustomerName(arg0);
    }

    @When("User select {string} on the customer status filter")
    public void userSelectOnTheCustomerStatusFilter(String arg0) {
        customerTablePage.selectFilterOptions(arg0);
    }

    @Then("Products related to the status are shown on then customer table")
    public void productsRelatedToTheStatusAreShownOnThenCustomerTable() {
        customerTablePage.verifyAfterSearch();
    }
}
