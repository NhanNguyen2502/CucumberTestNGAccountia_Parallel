package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.CompanyListPage;
import com.erp.com.pages.Invoices.InvoicesTablePage;
import erp.com.company.CompanyHelpers;
import erp.com.constants.ConstantGlobal;
import erp.com.ulitilities.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static erp.com.ulitilities.WebUI.*;

public class InvoicesTableSteps {
    private TestContext testContext;
    private CompanyListPage companyListPage;
    private InvoicesTablePage invoicesTablePage;

    public InvoicesTableSteps(TestContext context) {
        testContext = context;
        companyListPage = context.getCompanyListPage();
        invoicesTablePage = context.getInvoiceTablePage();
    }

    @Given("User is on the invoices page")
    public void userIsOnTheInvoicesPage() {
        waitForPageLoaded();
        companyListPage.selectCompanyBaseOnCompanyType(CompanyHelpers.getTypeOfRealCompany(ConstantGlobal.LANGUAGE_ENGLISH));
        invoicesTablePage.goToInvoiceTable();
    }

    @When("User search for invoice number")
    public void userSearchForInvoiceNumber() {
        invoicesTablePage.searchInvoice("123456");
    }

    @Then("Invoices related to the keyword are shown on then product table")
    public void invoicesRelatedToTheKeywordAreShownOnThenProductTable() {
        invoicesTablePage.verifyAfterSearch();
    }
}
