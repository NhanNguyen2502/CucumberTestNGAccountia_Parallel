package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.productPage.CreateProductPage;
import com.erp.com.pages.productPage.ProductsTablePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProductsSteps {
    TestContext testContext;
    CreateProductPage createProductPage;
    ProductsTablePage productTablePage;

    public CreateProductsSteps(TestContext testContext) {
        this.testContext = testContext;
        createProductPage = testContext.getCreateProductPage();
        productTablePage = testContext.getProductsTablePage();
    }

    @Given("User is on the create product page")
    public void userIsOnThePage() {
        productTablePage.goToTheProductTable();
        createProductPage.getProductNameExist();
        createProductPage.goToCreateProductPage();
    }

    @And("User fills in the required fields")
    public void userFillsInTheRequiredFields() {
        createProductPage.enterProductName();
        createProductPage.enterProductPrice();
    }

    @When("User clicks on the create button")
    public void userClicksOnTheCreateButton() {
        createProductPage.clickProductCreateButton();
    }

    @Then("User should see a product table")
    public void userShouldSeeAProductTable() {
        createProductPage.verifyCreateSuccess();
    }

    @And("User fills in the required fields with an existing product name")
    public void userFillsInTheRequiredFieldsWithAnExistingProductName() {
        createProductPage.enterProductNameExist();
        createProductPage.enterProductPrice();
    }

    @Then("User should see an error message")
    public void userShouldSeeAnErrorMessage() {
        createProductPage.verifyProductNameExistError();
    }

    @And("User select product {string}")
    public void userSelectProduct(String arg0) {
        createProductPage.selectProductType(arg0);
    }

    @And("User click on add another price button")
    public void userClickOnAddAnotherPriceButton() {
        createProductPage.clickOnAddPriceButton(1);
    }

    @And("User enter price to another price field")
    public void userEnterPriceToAnotherPriceField() {
        createProductPage.enterPriceToOtherPriceInput();
    }

    @And("User click {string} on add another price button")
    public void userClickOnAddAnotherPriceButton(String arg0) {
        createProductPage.clickOnAddPriceButton(Integer.parseInt(arg0));
    }

    @And("User select tax for the product")
    public void userSelectTaxForTheProduct() {
        createProductPage.enterTaxToTaxInputField();
    }
}
