package com.erp.com.pages.contactPage;

import com.erp.com.pages.CompanyListPage;
import erp.com.company.CompanyHelpers;
import erp.com.constants.ConstantGlobal;
import erp.com.ulitilities.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CustomersTablePage {
    CompanyListPage companyListPage;

    public CustomersTablePage() {
        companyListPage = new CompanyListPage();
    }

    private By customerLeftMenu = By.xpath("//a[@data-cy='sidebar-customer-link']//span");
    private By customerLabel = By.xpath("//span[@data-cy='customer-list-title']");
    private By customerStatusField = By.xpath("(//app-select[@data-cy='select-contact-status']//input)[1]");
    private By customerStatusAll = By.xpath("//mat-option[@data-cy='option-0']");
    private By customerEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By customerDisable = By.xpath("//mat-option[@data-cy='option-2']");
    private By customerSearch = By.xpath("(//input[@data-cy='search-input-field'])[1]");
    private By customerSearchField = By.xpath("(//input[@data-placeholder='Search'])[3]");


    public void goToCustomerTable() {
        WebUI.waitForPageLoaded();
        companyListPage.selectCompanyBaseOnCompanyType(CompanyHelpers.getTypeCompany(ConstantGlobal.COMPANY_TYPE, ConstantGlobal.LANGUAGE_ENGLISH));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(customerLeftMenu);
    }

    public boolean verifyCustomerTable() {
        WebUI.waitForPageLoaded();
        return WebUI.checkNull(customerLabel);
    }

    public void verifyAfterSearch() {
        if (verifyCustomerTable() == true) {
            Assert.assertTrue(verifyCustomerTable());
            System.out.println("The result is empty");
        }
    }

    public void filterAll() {
        WebUI.clickElement(customerStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(customerStatusAll);
    }

    public void filterEnable() {
        WebUI.clickElement(customerStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(customerEnable);
    }

    public void filterDisabled() {
        WebUI.clickElement(customerStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(customerDisable);
    }

    public void selectFilterOptions(String type) {
        if (!type.isEmpty()) {
            switch (type.trim().toUpperCase()) {
                case "ENABLED":
                    filterEnable();
                    break;
                case "DISABLED":
                    filterDisabled();
                    break;
                case "ALL":
                    filterAll();
                    break;
            }
        } else {
            filterAll();
        }

    }

    public void searchCustomerName(String productName) {
        try {
            WebUI.clickElement(customerSearch);
            //validateHelpers.clearElement(productSearch);
            //validateHelpers.setText(productSearch, productName);
            WebElement a = WebUI.getWebElement(customerSearchField);
            a.click();
            a.sendKeys(productName);
            a.sendKeys(Keys.ENTER);
        } catch (NoSuchElementException e) {
            Assert.fail("Search Product Name Failed.");
        }
    }
}
