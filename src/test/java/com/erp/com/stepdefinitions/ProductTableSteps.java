package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.productPage.ProductsTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductTableSteps {
    private TestContext testContext;
    private ProductsTablePage productTablePage;

    public ProductTableSteps(TestContext testContext) {
        this.testContext = testContext;
        productTablePage = testContext.getProductsTablePage();
    }

    @Given("User is already on the product table")
    public void userIsAlreadyOnTheProductTable() {
        productTablePage.goToTheProductTable();
    }

    @When("Users enters keywords to the search input")
    public void usersEntersKeywordsToTheSearchInput() {
        productTablePage.searchProductName("a123123");
    }

    @Then("Products related to the keyword are shown on then product table")
    public void productsRelatedToTheKeywordAreShownOnThenProductTable() {
        productTablePage.verifyAfterSearch();
    }

    @When("User enter {string} to the search input")
    public void userEnterToTheSearchInput(String arg0) {
        productTablePage.searchProductName(arg0);
    }

    @When("User select {string} to filter")
    public void userSelectToFilter(String arg0) {
        productTablePage.selectFilterOptions(arg0);
    }

    @Then("Products related to the status are shown on then product table")
    public void productsRelatedToTheStatusAreShownOnThenProductTable() {
        productTablePage.verifyAfterSearch();
    }
}
