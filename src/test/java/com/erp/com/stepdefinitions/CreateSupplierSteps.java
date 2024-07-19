package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.contactPage.CreateContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateSupplierSteps {
    CreateContactPage createContatPage;
    TestContext testContext;

    public CreateSupplierSteps( TestContext testContext) {
        this.testContext = testContext;
        createContatPage = testContext.getCreateContactPage();
    }

    @Given("User is on the create supplier page")
    public void userIsOnTheCreateSupplierPage() {
        createContatPage.goToCreateSupplierPage();
    }

    @And("User fills in the supplier name")
    public void userFillsInTheSupplierName() {
        createContatPage.enterContactName();
    }

    @When("User clicks on the create supplier button")
    public void userClicksOnTheCreateSupplierButton() {
        createContatPage.clickCreateContactButton();
    }

    @Then("The supplier table should be displayed")
    public void theSupplierTableShouldBeDisplayed() {
        createContatPage.verifyAfterCreated();
    }

    @And("User selects the customer role")
    public void userSelectsTheCustomerRole() {
        createContatPage.selectBothOptions();
    }

    @And("User enters the supplier discount")
    public void userEntersTheSupplierDiscount() {
        createContatPage.enterDiscount();
    }

    @And("User enters the supplier group")
    public void userEntersTheSupplierGroup() {
        createContatPage.enterGroup();
    }

    @And("User selects another currency for supplier")
    public void userSelectsAnotherCurrencyForSupplier() {
        createContatPage.selectAnotherCurrency();
    }

    @Then("The warning text of the supplier name should be displayed")
    public void theWarningTextOfTheSupplierNameShouldBeDisplayed() {
        createContatPage.verifyContactNameRequiredWarning();
    }
}
