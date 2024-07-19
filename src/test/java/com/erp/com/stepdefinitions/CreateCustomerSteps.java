package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.contactPage.CreateContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCustomerSteps {
    CreateContactPage createContatPage;
    TestContext testContext;

    public CreateCustomerSteps(TestContext testContext) {
        this.testContext = testContext;
        createContatPage = testContext.getCreateContactPage();
    }

    @Given("User is on the create customer page")
    public void userIsOnTheCreateCustomerPage() {
        createContatPage.goToCreateCustomerPage();
    }

    @And("User fills in the customer name")
    public void userFillsInTheCustomerName() {
        createContatPage.enterContactName();
    }

    @When("User clicks on the create customer button")
    public void userClicksOnTheCreateCustomerButton() {
        createContatPage.clickCreateContactButton();
    }

    @Then("The customer table should be displayed")
    public void theCustomerTableShouldBeDisplayed() {
        createContatPage.verifyAfterCreated();
    }

    @And("User selects the supplier role")
    public void userSelectsTheSupplierRole() {
        createContatPage.selectBothOptions();
    }

    @And("User enters the discount")
    public void userEntersTheDiscount() {
        createContatPage.enterDiscount();
    }

    @And("User enters group name")
    public void userEntersGroupName() {
        createContatPage.enterGroup();
    }

    @And("User selects another currency for customer")
    public void userSelectsAnotherCurrency() {
        createContatPage.selectAnotherCurrency();
    }

    @And("User enters the customer group")
    public void userEntersTheCustomerGroup() {
        createContatPage.enterGroup();
    }

    @Then("The warning text of the customer name should be displayed")
    public void theWarningTextOfTheCustomerNameShouldBeDisplayed() {
        createContatPage.verifyContactNameRequiredWarning();
    }
}
