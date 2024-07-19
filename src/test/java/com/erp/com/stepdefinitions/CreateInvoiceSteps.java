package com.erp.com.stepdefinitions;

import com.erp.com.hooks.TestContext;
import com.erp.com.pages.CompanyListPage;
import com.erp.com.pages.Invoices.CreateInvoicePage;
import com.erp.com.pages.Invoices.InvoicesTablePage;
import erp.com.company.CompanyHelpers;
import erp.com.constants.ConstantGlobal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateInvoiceSteps {
    CompanyListPage companyListPage;
    CreateInvoicePage createInvoicePage;
    InvoicesTablePage invoicesTablePage;
    TestContext testContext;

    public CreateInvoiceSteps(TestContext context) {
        testContext = context;
        companyListPage = testContext.getCompanyListPage();
        createInvoicePage = testContext.getCreateInvoicePage();
        invoicesTablePage = testContext.getInvoiceTablePage();
    }

    @Given("Users is on the create invoice form")
    public void usersIsOnTheCreateInvoiceForm() {
        companyListPage.selectCompanyBaseOnCompanyType(CompanyHelpers.getTypeOfRealCompany(ConstantGlobal.LANGUAGE_ENGLISH));
        invoicesTablePage.goToInvoiceTable();
        createInvoicePage.goToCreateInvoice();
    }

    @And("Users select invoice type")
    public void usersSelectInvoiceType() {
        createInvoicePage.getInvoiceType("STANDARD");
    }

    @And("Users select customer")
    public void usersSelectCustomer() {
        createInvoicePage.selectContactWithOutChangeCurrency();
    }

    @And("Users select product")
    public void usersSelectProduct() {
        createInvoicePage.selectProduct();
    }

    @When("Users click on the create invoice button")
    public void usersClickOnTheCreateInvoiceButton() {
        createInvoicePage.clickOnCreateButton();
    }
}
