package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.feePage.FeesTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeeTableSteps {
    TestContext testContext;
    FeesTablePage feesTablePage;

    public FeeTableSteps(TestContext testContext) {
        feesTablePage = testContext.getFeesTablePage();
    }

    @Given("User is already on the fee table")
    public void userIsAlreadyOnTheFeeTable() {
        feesTablePage.goToFeeTable();
    }

    @When("Users enters fee name to the search input")
    public void usersEntersFeeNameToTheSearchInput() {
        feesTablePage.searchFeeName("Senior Consultant");
    }

    @Then("Fees related to the keyword are shown on then product table")
    public void feeRelatedToTheKeywordAreShownOnThenProductTable() {
        feesTablePage.verifyAfterSearch();
    }

    @When("User enter {string} of fee name to the search input")
    public void userEnterOfFeeNameToTheSearchInput(String arg0) {
        feesTablePage.searchFeeName(arg0);
    }

    @When("User select fee {string} to filter")
    public void userSelectFeeToFilter(String arg0) {
        feesTablePage.selectFilterOptions(arg0);
    }

    @Then("Fees related to the status are shown on then product table")
    public void feesRelatedToTheStatusAreShownOnThenProductTable() {
        feesTablePage.verifyAfterSearch();
    }
}
