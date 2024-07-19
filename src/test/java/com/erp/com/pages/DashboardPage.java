package com.erp.com.pages;

import erp.com.company.CompanyHelpers;
import erp.com.constants.ConstantGlobal;
import erp.com.ulitilities.WebUI;

public class DashboardPage {
    CompanyListPage companyListPage;

    public DashboardPage() {
        companyListPage = new CompanyListPage();
    }

    public void goToDashBoardPage() {
        WebUI.waitForPageLoaded();
        companyListPage.selectCompanyBaseOnCompanyType(CompanyHelpers.getTypeCompany(ConstantGlobal.COMPANY_TYPE,ConstantGlobal.LANGUAGE_ENGLISH));
        companyListPage.verifyRedirectToDashboard();
    }

}
