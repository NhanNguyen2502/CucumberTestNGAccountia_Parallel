package com.erp.com.pages;

import erp.com.helpers.TranslationHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static erp.com.ulitilities.WebUI.*;

public class LoginPage {
    public LoginPage() {
    }

    private By inputEmail = By.xpath("//input[@id='username']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='kc-login-button']");
    private By languageButton = By.xpath("(//div[@id='kc-locale-dropdown']//a//span)[1]");
    private By languageOptions = By.xpath("//li//div//a[@id='kc-locale-option']");


    public void enterEmailAndPassword(String email, String password) {
        setText(inputEmail, email);
        waitAfterClick();
        setText(inputPassword, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    public void selectLanguage(String language) {
        waitForLoadLoginPage();
        if (!(language == null)) {
            clickElement(languageButton);
            var options = getListElements(languageOptions);
            String key = "$.languageSelect.option.english";
            switch (language) {
                case "English" -> key = "$.languageSelect.option.english";
                case "Arabic" -> key = "$.languageSelect.option.arabic";
                case "Kurdish - Badini" -> key = "$.languageSelect.option.badini";
                case "Kurdish - Sorani" -> key = "$.languageSelect.option.sorani";
                default -> System.out.println("default");
            }
            for (WebElement o : options) {
                if (o.getText().contains(language) || o.getText().contains(TranslationHelpers.getTranslation(key))) {
                    System.out.println("Test with language: " + language);
                    o.click();
                    break;
                }
            }
        } else {
            System.out.println("Test with language: English by default");
            clickElement(languageButton);
            var options = getListElements(languageOptions);
            String key = "$.languageSelect.option.english";
            for (WebElement o : options) {
                if (o.getText().contains("English") || o.getText().contains(TranslationHelpers.getTranslation( key))) {
                    o.click();
                    break;
                }
            }
        }

    }
}
