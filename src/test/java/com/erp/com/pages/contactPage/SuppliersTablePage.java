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

public class SuppliersTablePage {
    CompanyListPage companyListPage;

    public SuppliersTablePage() {
        companyListPage = new CompanyListPage();
    }

    private By supplierLeftMenu = By.xpath("//a[@data-cy='sidebar-supplier-link']");
    private By supplierLable = By.xpath("//span[@data-cy='customer-list-title']");
    private By supplierStatusField = By.xpath("(//app-select[@data-cy='select-contact-status']//input)[1]");
    private By supplierStatusAll = By.xpath("//mat-option[@data-cy='option-0']");
    private By customerEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By supplierDisable = By.xpath("//mat-option[@data-cy='option-2']");
    private By supplierSearch = By.xpath("(//input[@data-cy='search-input-field'])[1]");
    private By customerSearchField = By.xpath("(//input[@data-placeholder='Search'])[3]");

    public void goToSupplierTable() {
        WebUI.waitForPageLoaded();
        companyListPage.selectCompanyBaseOnCompanyType(CompanyHelpers.getTypeCompany(ConstantGlobal.COMPANY_TYPE, ConstantGlobal.LANGUAGE_ENGLISH));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(supplierLeftMenu);
    }

    public boolean verifySupplierTable() {
        WebUI.waitForPageLoaded();
        return WebUI.checkNull(supplierLable);
    }

    public void verifyAfterSearch() {
        if (verifySupplierTable() == true) {
            Assert.assertTrue(verifySupplierTable());
            System.out.println("The result is empty");
        }
    }

    public void filterAll() {
        WebUI.clickElement(supplierStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(supplierStatusAll);
    }

    public void filterEnable() {
        WebUI.clickElement(supplierStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(customerEnable);
    }

    public void filterDisabled() {
        WebUI.clickElement(supplierStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(supplierDisable);
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

    public void searchSupplierName(String supplierName) {
        try {
            WebUI.clickElement(supplierSearch);
            //validateHelpers.clearElement(productSearch);
            //validateHelpers.setText(productSearch, productName);
            WebElement a = WebUI.getWebElement(customerSearchField);
            a.click();
            a.sendKeys(supplierName);
            a.sendKeys(Keys.ENTER);
        } catch (NoSuchElementException e) {
            Assert.fail("Search supplier Name Failed.");
        }
    }
}
