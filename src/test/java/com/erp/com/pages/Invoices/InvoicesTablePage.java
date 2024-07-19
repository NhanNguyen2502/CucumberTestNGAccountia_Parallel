package com.erp.com.pages.Invoices;

import com.erp.com.pages.CompanyListPage;
import erp.com.ulitilities.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static erp.com.ulitilities.WebUI.*;

public class InvoicesTablePage {

    public InvoicesTablePage() {
        // Constructor
    }

    private By invoiceLeftMenu = By.xpath("//a[@data-cy='sidebar-invoice-link']//span");
    private By invoiceLable = By.xpath("//span[@data-cy='invoice-list-title']");
    private By invoiceSearch = By.xpath("//input[@data-cy='search-input-field']");
    private By invoiceSearchField = By.xpath("(//input[@placeholder='Search'])[2]");
    private By itemOnInvoiceTable = By.xpath("//mat-row");

    public void goToInvoiceTable() {
        // Go to invoice table
        waitForPageLoaded();
        clickElement(invoiceLeftMenu);
        waitForPageLoaded();
        Assert.assertTrue(checkDisplayed(invoiceLable));
    }

    public boolean verifyInvoiceTitle() {
        // Verify invoice table
        waitForPageLoaded();
        return checkNull(invoiceLable);
    }

    public void searchInvoice(String index) {
        try {
            WebUI.clickElement(invoiceSearch);
            //validateHelpers.clearElement(productSearch);
            //validateHelpers.setText(productSearch, productName);
            WebElement a = WebUI.getWebElement(invoiceSearchField);
            a.click();
            a.sendKeys(index);
            a.sendKeys(Keys.ENTER);
        } catch (NoSuchElementException e) {
            Assert.fail("Search invoice  Failed.");
        }
    }

    public boolean verifyInvoiceTable() {
        WebUI.waitForPageLoaded();
        return WebUI.checkNull(itemOnInvoiceTable);
    }

    public void verifyAfterSearch() {
        if (verifyInvoiceTable() == true) {
            Assert.assertTrue(verifyInvoiceTable());
            System.out.println("The result is empty");
        }
    }


}
