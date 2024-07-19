package com.erp.com.pages.feePage;

import erp.com.driver.DriverManager;
import erp.com.helpers.DataFaker;
import erp.com.ulitilities.WebUI;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Random;

import static erp.com.ulitilities.WebUI.*;

public class CreateFeePage {
    private String _feeNameCreated;
    Random random;

    public CreateFeePage() {
        random = new Random();
    }

    private By feeCreateButtonOnTheTable = By.xpath("//act-button[@data-cy='create-product-button']//button");
    private By feeNameField = By.xpath("//input[@data-cy='fee-name-input']");
    private By feeNameRequiredWarning = By.xpath("//div[@data-cy='fee-name-required-error']");
    private By feeNameExistedWarning = By.xpath("//div[@data-cy='fee-name-required-error']");
    private By feeMainInput = By.xpath("//input[@data-cy='fee-currency-amount']");
    private By feeCreateButton = By.xpath("//act-button[@data-cy='create-fee-button']//button");
    private By feeTableTitle = By.xpath("//app-page-title//span[@data-cy='product-list-page']");
    private By feeAddAnotherPrice = By.xpath("//act-button[@data-cy='add-fee-amount-button']//button");

    public void addAnotherPrice(int numberPrice) {
        try {
            if (numberPrice > 0) {
                for (int i = 0; i < numberPrice; i++) {
                    clickElement(feeAddAnotherPrice);
                    waitAfterClick();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void goToTheCreateFeePage() {
        waitForPageLoaded();
        clickElement(feeCreateButtonOnTheTable);
    }

    public void verifyFeeNameRequiredWarning() {
        Assert.assertTrue(DriverManager.getDriver().findElement(feeNameRequiredWarning).isDisplayed());
    }

    public void enterFeeName() {
        waitForPageLoaded();
        _feeNameCreated = DataFaker.getDataFaker().job().title();
        setText(feeNameField, _feeNameCreated);
        for (int i = 0; ; i++) {
            if (!checkNull(feeNameExistedWarning)) {
                _feeNameCreated = DataFaker.getDataFaker().job().title();
                clearInput(feeNameField);
                setText(feeNameField, _feeNameCreated);
            } else {
                break;
            }
        }
    }

    public void enterFeePriceInput() {
        waitAfterClick();
        var _listInput = getListElements(feeMainInput);
        for (var input : _listInput) {
            int randomPrice = random.nextInt(1, 100);
            input.clear();
            input.sendKeys(String.valueOf(randomPrice));
            waitAfterClick();
        }

    }

    public void clickCreateButton() {
        waitAfterClick();
        clickElement(feeCreateButton);
    }

    public void verifyAfterCreate() {
        waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().findElement(feeTableTitle).isDisplayed());
        System.out.println("The fee was created successfully: " + _feeNameCreated);
    }
}
