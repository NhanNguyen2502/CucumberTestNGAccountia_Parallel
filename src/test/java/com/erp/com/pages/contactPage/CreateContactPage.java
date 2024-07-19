package com.erp.com.pages.contactPage;

import erp.com.driver.DriverManager;
import erp.com.helpers.CustomFaker;
import erp.com.helpers.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static erp.com.ulitilities.WebUI.*;

public class CreateContactPage {
    private String _nameExist;
    private String _contactNameCreated;
    CustomersTablePage customersTablePage;
    SuppliersTablePage suppliersTablePage;
    private Random random;
    CustomFaker customFaker;

    public CreateContactPage() {
        customersTablePage = new CustomersTablePage();
        suppliersTablePage = new SuppliersTablePage();
        random = new Random();
        customFaker = new CustomFaker();
    }

    private By createContactButton = By.xpath("//act-button[@data-cy='create-contact-button']");
    private By contactNameInput = By.xpath("//input[@data-cy='contact-name']");
    private By contactNameRequiredWarning = By.xpath("//div[@data-cy='name-required-error-message']");
    private By createContactbutton = By.xpath("//act-button[@data-cy='create-contact-button']");
    private By contactTableTitle = By.xpath("//app-page-title//span[@data-cy='customer-list-title']");
    private By contactTypeInput = By.xpath("//input[@apptooltip='contactTypeSelect.inputField.addUserRoleTooltip']");
    private By contactTypeOption = By.xpath("//mat-option[1]");
    private By contactDiscount = By.xpath("//input[@data-cy='contact-discount-setting']");
    private By contactGroup = By.xpath("//input[@data-cy='group-chip-input']");
    private By contactCurrenciesInput = By.xpath("//mat-form-field[@data-cy='select-currency-form-field']//input");
    private By contactCurrenciesOptions = By.xpath("//mat-option");


    public void goToCreateCustomerPage() {
        customersTablePage.goToCustomerTable();
        waitForPageLoaded();
        clickElement(createContactButton);
    }

    public void goToCreateSupplierPage() {
        suppliersTablePage.goToSupplierTable();
        waitForPageLoaded();
        clickElement(createContactButton);
    }

    public void verifyContactNameRequiredWarning() {
        clickElement(contactNameInput);
        clickElement(createContactbutton);
        Assert.assertTrue(DriverManager.getDriver().findElement(contactNameRequiredWarning).isDisplayed());
    }

    public void enterContactName() {
        waitForPageLoaded();
        verifyContactNameRequiredWarning();
        _contactNameCreated = DataFaker.getDataFaker().name().name().replace(".", " ");
        setText(contactNameInput, _contactNameCreated);
    }

    public void clickCreateContactButton() {
        waitAfterClick();
        clickElement(createContactbutton);
    }

    public void verifyAfterCreated() {
        waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().findElement(contactTableTitle).isDisplayed());
        System.out.println("Contact name created: " + _contactNameCreated);
    }

    public void selectBothOptions() {
        waitAfterClick();
        clickElement(contactTypeInput);
        waitAfterClick();
        clickElement(contactTypeOption);
    }

    public void enterDiscount() {
        waitAfterClick();
        clearInput(contactDiscount);
        waitAfterClick();
        setText(contactDiscount, String.valueOf(random.nextInt(1, 100)));
    }

    public void enterGroup() {
        waitAfterClick();
        setText(contactGroup, customFaker.group().group());
    }

    public void selectAnotherCurrency() {
        waitAfterClick();
        var _curretValue = getValueAttribute(contactCurrenciesInput);
        clickElement(contactCurrenciesInput);
        List<WebElement> _currencies = getListElements(contactCurrenciesOptions);
        if (!_currencies.isEmpty()) {
            for (WebElement a : _currencies) {
                if (!a.getText().equals(_curretValue)) {
                    _currencies.remove(a);
                    break;
                }
            }
            _currencies.get(random.nextInt(0, _currencies.size())).click();
        }

    }
}
