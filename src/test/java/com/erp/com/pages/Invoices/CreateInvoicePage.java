package com.erp.com.pages.Invoices;

import erp.com.driver.DriverManager;
import erp.com.ulitilities.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Random;

import static erp.com.ulitilities.WebUI.*;

public class CreateInvoicePage {

    private Random random;

    public CreateInvoicePage() {
        // Constructor
        random = new Random();
    }

    private By invoiceCreateInvoiceButton = By.xpath("//act-button[@data-cy='new-invoice-button']//button");
    private By invoiceTypeInput = By.xpath("//input[@data-cy='draft-invoice-type']");
    private By invoiceTypeStandard = By.xpath("//mat-option[@data-cy='option-0']");
    private By invoiceTypeInstalment = By.xpath("//mat-option[@data-cy='option-1']");
    private By invoiceTypeCashSale = By.xpath("//mat-option[@data-cy='option-2']");
    private By invoiceContactInput = By.xpath("//input[@data-cy='select-contact']");
    private By invoiceOptions = By.xpath("//mat-option");
    private By invoiceDialog = By.xpath("//act-dialog");
    private By invoiceCancelChangeCurrencyButton = By.xpath("//act-button[@data-cy='dialog-cancel-button']//button");
    private By invoiceProductInput = By.xpath("//input[@data-cy='select-product']");
    private By invoiceProductPrices = By.xpath("(//input[@data-cy='price'])[1]");
    private By invocieSaveButton = By.xpath("//act-button[@data-cy='create-invoice-button']//button");
    private By invoiceDialogConfirm = By.xpath("//app-confirm-dialog");


    public void clickOnCreateButton() {
        waitAfterClick();
        clickElement(invocieSaveButton);
    }


    public void selectProduct() {
        waitAfterClick();
        clickElement(invoiceProductInput);
        waitAfterClick();
        var options = getWebElements(invoiceOptions);
        if (options.size() > 0) {
            waitAfterClick();
            options.get(random.nextInt(options.size())).click();
        }
        System.out.println(DriverManager.getDriver().findElement(invoiceProductPrices).getDomAttribute("value"));

    }

    public void selectContactWithOutChangeCurrency() {
        waitAfterClick();
        clickElement(invoiceContactInput);
        waitAfterClick();
        var options = getWebElements(invoiceOptions);
        waitAfterClick();
        if (options.size() > 0) {
            options.get(random.nextInt(options.size())).click();
        }
        waitAfterClick();
        if (checkDisplayed(invoiceDialog)) {
            Assert.assertTrue(checkDisplayed(invoiceDialog));
            clickElement(invoiceCancelChangeCurrencyButton);
        }

    }

    public void goToCreateInvoice() {
        waitForPageLoaded();
        clickElement(invoiceCreateInvoiceButton);
    }

    public void getInvoiceType(String invoiceType) {
        waitForPageLoaded();
        clickElement(invoiceTypeInput);
        switch (invoiceType.trim().toUpperCase()) {
            case "STANDARD":
                clickElement(invoiceTypeStandard);
                break;
            case "INSTALMENT":
                clickElement(invoiceTypeInstalment);
                break;
            case "CASHSALE":
                clickElement(invoiceTypeCashSale);
                break;
            default:
                System.out.println("Select invoice type by default.");
                break;
        }
    }

}
