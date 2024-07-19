package com.erp.com.pages.productPage;

import com.erp.com.pages.CompanyListPage;
import erp.com.company.CompanyHelpers;
import erp.com.constants.ConstantGlobal;
import erp.com.ulitilities.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductsTablePage {
    CompanyListPage companyListPage;

    public ProductsTablePage() {
        companyListPage = new CompanyListPage();
    }

    private By productLeftMenu = By.xpath("//a[@data-cy='sidebar-product-link']");
    private By itemOnProductTable = By.xpath("//span[@data-cy='product-name-data']");
    private By productStatusField = By.xpath("//app-select[@data-cy='select-product-status']//input");
    private By productEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By productDisable = By.xpath("//mat-option[@data-cy='option-2']");
    private By productStatusAll = By.xpath("//mat-option[@data-cy='option-0']");
    private By productSearch = By.xpath("(//input[@data-cy='search-input-field'])[1]");
    private By productSearchField = By.xpath("(//input[@data-placeholder='Search'])[3]");


    public void goToTheProductTable() {
        WebUI.waitForPageLoaded();
        companyListPage.selectCompanyBaseOnCompanyType(CompanyHelpers.getTypeCompany(ConstantGlobal.COMPANY_TYPE, ConstantGlobal.LANGUAGE_ENGLISH));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(productLeftMenu);
    }

    public boolean verifyProductTable() {
        WebUI.waitForPageLoaded();
        return WebUI.checkNull(itemOnProductTable);
    }

    public void verifyAfterSearch() {
        if (verifyProductTable() == true) {
            Assert.assertTrue(verifyProductTable());
            System.out.println("The result is empty");
        }
    }

    public void filterAll() {
        WebUI.clickElement(productStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(productStatusAll);
    }

    public void filterEnable() {
        WebUI.clickElement(productStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(productEnable);
    }

    public void filterDisabled() {
        WebUI.clickElement(productStatusField);
        WebUI.waitAfterClick();
        WebUI.clickElement(productDisable);
    }

    public void searchProductName(String productName) {
        try {
            WebUI.clickElement(productSearch);
            //validateHelpers.clearElement(productSearch);
            //validateHelpers.setText(productSearch, productName);
            WebElement a = WebUI.getWebElement(productSearchField);
            a.click();
            a.sendKeys(productName);
            a.sendKeys(Keys.ENTER);
        } catch (NoSuchElementException e) {
            Assert.fail("Search Product Name Failed.");
        }
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

}
