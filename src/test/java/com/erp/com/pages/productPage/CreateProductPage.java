package com.erp.com.pages.productPage;

import erp.com.driver.DriverManager;
import erp.com.helpers.DataFaker;
import erp.com.helpers.TranslationHelpers;
import erp.com.ulitilities.Log;
import erp.com.ulitilities.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class CreateProductPage {
    private Random random;
    private String _nameExist;
    private String _productNameCreated;

    public CreateProductPage() {
        random = new Random();
    }

    private By productName = By.xpath("//input[@data-cy='product-name']");
    private By productPrice = By.xpath("//input[@data-cy='product-price']");
    private By productCreateButton = By.xpath("//act-button[@data-cy='create-product-button']");
    private By productTableTitle = By.xpath("//div[@data-cy='product-list-page']");
    private By productNameExistList = By.xpath("//span[@data-cy='product-name-data']");
    private By productNameExistError = By.xpath("//div[@data-cy='product-name-exist-error']");
    private By productTableCreateButton = By.xpath("//act-button[@data-cy='create-product-button']");
    private By productTypeDropdownButton = By.xpath("//button[@data-cy='drop-down-button']");
    private By productTypeOptions = By.xpath("//mat-option");
    private By productAddPriceButton = By.xpath("//app-product-other-currency-price//act-button[@data-cy='add-product-price-button']");
    private By productOtherPrice = By.xpath("//input[@data-cy='product-currency-price']");
    private By productTaxInputField = By.xpath("//input[@data-cy='select-vat']");
    private By productTaxOptions = By.xpath("//mat-option");

    public void enterTaxToTaxInputField() {
        WebUI.waitAfterClick();
        if (!WebUI.checkNull(productTaxInputField)) {
            WebUI.clickElement(productTaxInputField);
            if (!WebUI.checkNull(productTaxOptions)) {
                List<WebElement> _productTaxOptions = WebUI.getListElements(productTaxOptions);
                int randomTax = random.nextInt(0, _productTaxOptions.size());
                _productTaxOptions.get(randomTax).click();
            } else {
                System.out.println("Tax options are not displayed, please check the company settings.");
                Log.info("Tax options are not displayed, please check the company settings.");
            }
        } else {
            System.out.println("Tax input field is not displayed, please check the company settings.");
            Log.info("Tax input field is not displayed, please check the company settings.");
        }

    }

    public void enterPriceToOtherPriceInput() {
        WebUI.waitAfterClick();
        List<WebElement> _productOtherPrice = WebUI.getListElements(productOtherPrice);
        if (!_productOtherPrice.isEmpty()) {
            for (WebElement a : _productOtherPrice) {
                WebUI.waitAfterClick();
                int randomPrice = random.nextInt(1, 100);
                a.sendKeys(String.valueOf(randomPrice));
                WebUI.waitAfterClick();
            }
        }
    }

    public void clickOnAddPriceButton(int index) {
        WebUI.waitForPageLoaded();
        for (int i = 0; i < index; i++) {
            WebUI.waitAfterClick();
            WebUI.clickElement(productAddPriceButton);
            WebUI.waitAfterClick();
        }
    }

    public void selectProductType(String productType) {
        WebUI.waitAfterClick();
        WebUI.clickElement(productTypeDropdownButton);
        var _productTypeOptions = WebUI.getListElements(productTypeOptions);
        switch (productType.trim().toUpperCase()) {
            case "ITEM":
                for (WebElement a : _productTypeOptions) {
                    if (a.getText().equals("ITEM") || a.getText().equals(TranslationHelpers.getTranslation("$.createProduct.select.option.item"))) {
                        a.click();
                        break;
                    }
                }
                break;
            case "SERVICE":
                for (WebElement a : _productTypeOptions) {
                    if (a.getText().equals("SERVICE") || a.getText().equals(TranslationHelpers.getTranslation("$.createProduct.select.option.service"))) {
                        a.click();
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }

    public void goToCreateProductPage() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(productTableCreateButton);
    }

    public void verifyProductNameExistError() {
        WebUI.waitAfterClick();
        Assert.assertTrue(DriverManager.getDriver().findElement(productNameExistError).isDisplayed());
    }

    public String getProductNameExist() {

        WebUI.waitForPageLoaded();
        var _nameExistList = WebUI.getListElements(productNameExistList);
        if (!_nameExistList.isEmpty()) {
            var _nameRandom = random.nextInt(_nameExistList.size());
            _nameExist = _nameExistList.get(_nameRandom).getText();
            return _nameExist;
        }
        return null;
    }

    public void enterProductNameExist() {
        WebUI.waitForPageLoaded();
        WebUI.setText(productName, _nameExist);
    }

    public void enterProductName() {
        WebUI.waitAfterClick();
        WebUI.setText(productName, DataFaker.getDataFaker().team().name());
    }

    public void enterProductPrice() {
        WebUI.waitAfterClick();
        WebUI.clickElement(productPrice);
        int randomPrice = random.nextInt(1, 100);
        WebUI.setText(productPrice, String.valueOf(randomPrice));
    }

    public void clickProductCreateButton() {
        WebUI.waitAfterClick();
        _productNameCreated = DriverManager.getDriver().findElement(productName).getAttribute("value");
        WebUI.clickElement(productCreateButton);
    }

    public void verifyCreateSuccess() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().findElement(productTableTitle).isDisplayed());
        System.out.println("Product created: " + _productNameCreated);
    }
}
