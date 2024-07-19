package com.erp.com.hooks;

import com.erp.com.common.BaseSetup;
import com.erp.com.pages.CompanyListPage;
import com.erp.com.pages.DashboardPage;
import com.erp.com.pages.Invoices.CreateInvoicePage;
import com.erp.com.pages.Invoices.InvoicesTablePage;
import com.erp.com.pages.LoginPage;
import com.erp.com.pages.contactPage.CreateContactPage;
import com.erp.com.pages.contactPage.CustomersTablePage;
import com.erp.com.pages.contactPage.SuppliersTablePage;
import com.erp.com.pages.feePage.CreateFeePage;
import com.erp.com.pages.feePage.FeesTablePage;
import com.erp.com.pages.productPage.CreateProductPage;
import com.erp.com.pages.productPage.ProductsTablePage;
import erp.com.constants.ConstantGlobal;
import erp.com.driver.DriverManager;
import erp.com.ulitilities.Log;
import io.cucumber.core.backend.Backend;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {
    private WebDriver driver;
    private LoginPage loginPage;
    private CompanyListPage companyListPage;
    private DashboardPage dashboardPage;
    private ProductsTablePage productsTablePage;
    private CreateProductPage createProductPage;
    private CustomersTablePage customersTablePage;
    private SuppliersTablePage suppliersTablePage;
    private CreateContactPage createContactPage;
    private CreateFeePage createFeePage;
    private FeesTablePage feesTablePage;
    private InvoicesTablePage invoiceTablePage;
    private CreateInvoicePage createInvoicePage;

    public TestContext() {
        ThreadGuard.protect(new BaseSetup().createDriver(ConstantGlobal.BROWSER));
        Log.info("Driver is created: " + getDriver());
    }

    public CreateInvoicePage getCreateInvoicePage() {
        if (createInvoicePage == null) {
            createInvoicePage = new CreateInvoicePage();
        }
        return createInvoicePage;
    }

    public InvoicesTablePage getInvoiceTablePage() {
        if (invoiceTablePage == null) {
            invoiceTablePage = new InvoicesTablePage();
        }
        return invoiceTablePage;
    }

    public FeesTablePage getFeesTablePage() {
        if (feesTablePage == null) {
            feesTablePage = new FeesTablePage();
        }
        return feesTablePage;
    }

    public CreateFeePage getCreateFeePage() {
        if (createFeePage == null) {
            createFeePage = new CreateFeePage();
        }
        return createFeePage;
    }

    public SuppliersTablePage getSuppliersTablePage() {
        if (suppliersTablePage == null) {
            suppliersTablePage = new SuppliersTablePage();
        }
        return suppliersTablePage;
    }

    public CustomersTablePage getCustomersTablePage() {
        if (customersTablePage == null) {
            customersTablePage = new CustomersTablePage();
        }
        return customersTablePage;
    }

    public CreateContactPage getCreateContactPage() {
        if (createContactPage == null) {
            createContactPage = new CreateContactPage();
        }
        return createContactPage;
    }

    public CreateProductPage getCreateProductPage() {
        if (createProductPage == null) {
            createProductPage = new CreateProductPage();
        }
        return createProductPage;
    }

    public ProductsTablePage getProductsTablePage() {
        if (productsTablePage == null) {
            productsTablePage = new ProductsTablePage();
        }
        return productsTablePage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CompanyListPage getCompanyListPage() {
        if (companyListPage == null) {
            companyListPage = new CompanyListPage();
        }
        return companyListPage;
    }

    public WebDriver getDriver() {
        return driver = DriverManager.getDriver();
    }
}
