package com.erp.com.pages.feePage;

import com.erp.com.pages.CompanyListPage;
import erp.com.company.CompanyHelpers;
import erp.com.constants.ConstantGlobal;
import erp.com.ulitilities.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FeesTablePage {
    CompanyListPage companyListPage;

    public FeesTablePage() {
        companyListPage = new CompanyListPage();
    }

    private By feeLeftMenu = By.xpath("//a[@data-cy='sidebar-fee-link']//span");
    private By feeLable = By.xpath("//app-page-title//span[@data-cy='product-list-page']");
    private By feeStatusField = By.xpath("//app-select[@prefix='fee.listPage']//input");
    private By feeStatusAll = By.xpath("//mat-option[@data-cy='option-0']");
    private By feeStatusEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By feeStatusDisabled = By.xpath("//mat-option[@data-cy='option-2']");
    private By feeSearchField = By.xpath("(//input[@data-cy='search-input-field'])[1]");
    private By customerSearchField = By.xpath("(//input[@data-placeholder='Search'])[3]");

    public void goToFeeTable() {
        WebUI.waitForPageLoaded();
        companyListPage.selectCompanyBaseOnCompanyType(CompanyHelpers.getTypeCompany(ConstantGlobal.COMPANY_TYPE, ConstantGlobal.LANGUAGE_ENGLISH));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(feeLeftMenu);
    }

    public boolean verifyFeeTable() {
        WebUI.waitForPageLoaded();
        return WebUI.checkNull(feeLable);
    }

    public void verifyAfterSearch() {
        if (verifyFeeTable() == true) {
            Assert.assertTrue(verifyFeeTable());
            System.out.println("The result is empty");
        }
    }

    public void filterAll() {
        WebUI.clickElement(feeStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(feeStatusAll);
    }

    public void filterEnable() {
        WebUI.clickElement(feeStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(feeStatusEnable);
    }

    public void filterDisabled() {
        WebUI.clickElement(feeStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(feeStatusDisabled);
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

    public void searchFeeName(String feeName) {
        try {
            WebUI.clickElement(feeSearchField);
            //validateHelpers.clearElement(productSearch);
            //validateHelpers.setText(productSearch, productName);
            WebElement a = WebUI.getWebElement(customerSearchField);
            a.click();
            a.sendKeys(feeName);
            a.sendKeys(Keys.ENTER);
        } catch (NoSuchElementException e) {
            Assert.fail("Search fee name failed.");
        }
    }
}
