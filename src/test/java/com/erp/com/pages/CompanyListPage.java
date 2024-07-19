package com.erp.com.pages;

import erp.com.company.CompanyHelpers;
import erp.com.constants.ConstantGlobal;
import erp.com.driver.DriverManager;
import erp.com.ulitilities.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Random;

public class CompanyListPage {
    private boolean _companyListEmpty = false;
    private boolean _real = false;
    private boolean _demo = false;

    public CompanyListPage() {
    }

    private By companyListTitle = By.xpath("//app-page-title//span[@data-cy='company-list-title']");
    private By companies = By.xpath("//mat-row//mat-cell[2]");
    private By companyTypes = By.xpath("//div[@data-cy='company-type']");
    private By dashboardLeftMenu = By.xpath("//a[@data-cy='sidebar-dashboard-link']");

    public void verifyCompanyListTitle() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().findElement(companyListTitle).isDisplayed());
        verifyCompanyList();
    }

    public void verifyCompanyList() {
        _companyListEmpty = WebUI.checkNull(companyTypes);
        if (_companyListEmpty == true) {
            System.out.println("The company list empty");
        }
    }

    public void selectCompanyBaseOnCompanyType(String companyType) {
        WebUI.waitForPageLoaded();
        if (!_companyListEmpty) {
            var ran = new Random();
            var _companyTypes = WebUI.getListElements(companyTypes);
            var _companies = WebUI.getListElements(companies);
            for (int i = 0; i < _companyTypes.size(); i++) {
                if (_companyTypes.get(i).getText().equals(companyType)) {
                    _companies.get(i).click();
                    break;
                }
            }
        }
    }

    public void selectCompanyBaseOnCompanyTypeOfExample(String companyType) {
        WebUI.waitForPageLoaded();
        String _companyType = companyType.toUpperCase();
        if (_companyListEmpty == false) {
            var _companyTypes = WebUI.getListElements(companyTypes);
            var _companies = WebUI.getListElements(companies);
            switch (_companyType) {
                case "REAL":
                    for (int i = 0; i < _companyTypes.size(); i++) {
                        if (_companyTypes.get(i).getText().equals(CompanyHelpers.getTypeCompany(ConstantGlobal.COMPANY_TYPE, ConstantGlobal.LANGUAGE_ENGLISH))) {
                            _real = true;
                            _companies.get(i).click();
                            break;
                        }
                    }
                    if (_real) {
                        System.out.println("The company list not exist the company with type: " + companyType);
                    }
                    break;
                case "DEMO":
                    for (int i = 0; i < _companyTypes.size(); i++) {
                        if (_companyTypes.get(i).getText().equals(CompanyHelpers.getTypeOfDemoCompany(ConstantGlobal.LANGUAGE_ENGLISH))) {
                            _demo = true;
                            _companies.get(i).click();
                            break;
                        }
                    }
                    if (_demo) {
                        System.out.println("The company list not exist the company with type: " + companyType);
                    }
                    break;
            }
            if (_real == false && _demo == false) {
                System.out.println("The company list not exist the company with type: " + companyType);
            }

        }
    }

    public void verifyRedirectToDashboard() {
        if (_real == true || _demo == true) {
            WebUI.waitForPageLoaded();
            Assert.assertTrue(DriverManager.getDriver().findElement(dashboardLeftMenu).isDisplayed());
        }
    }

    public void verifyNotRedirectTDashboard() {
        if (_real == false && _demo == false) {
            WebUI.waitForPageLoaded();
            Assert.assertTrue(WebUI.checkNull(dashboardLeftMenu));
        }
    }
}
