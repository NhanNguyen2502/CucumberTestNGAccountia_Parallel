package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.CompanyListPage;
import com.erp.com.pages.feePage.CreateFeePage;
import com.erp.com.pages.feePage.FeesTablePage;
import erp.com.driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateFeeSteps {
    FeesTablePage feesTablePage;
    CreateFeePage createFeePage;
    TestContext testContext;


    public CreateFeeSteps(TestContext testContext) {
        this.testContext = testContext;
        feesTablePage = testContext.getFeesTablePage();
        createFeePage = testContext.getCreateFeePage();
    }

    @Given("User is on the create fee page")
    public void userIsOnTheCreateFeePage() {
        feesTablePage.goToFeeTable();
        createFeePage.goToTheCreateFeePage();
    }

    @And("User enters fee name")
    public void userEntersFeeName() {
        createFeePage.enterFeeName();
    }

    @When("User click on the create fee button")
    public void userClickOnTheCreateFeeButton() {
        createFeePage.clickCreateButton();
    }

    @Then("The fee table should be displayed")
    public void theFeeTableShouldBeDisplayed() {
        createFeePage.verifyAfterCreate();
    }

    @And("User enters fee price")
    public void userEntersFeePrice() {
        createFeePage.enterFeePriceInput();
    }

    @And("User clicks add another price button")
    public void userClicksAddAnotherPriceButton() {
        createFeePage.addAnotherPrice(1);
    }

    @And("User clicks {string} add another price button")
    public void userClicksAddAnotherPriceButton(String arg0) {
        createFeePage.addAnotherPrice(Integer.parseInt(arg0));
    }

    @Then("The warning text the name is required should be displayed")
    public void theWarningTextTheNameIsRequiredShouldBeDisplayed() {
        createFeePage.verifyFeeNameRequiredWarning();
    }
}
