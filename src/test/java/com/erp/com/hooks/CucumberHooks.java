package com.erp.com.hooks;

import com.erp.com.common.BaseSetup;
import erp.com.constants.ConstantGlobal;
import erp.com.driver.DriverManager;
import erp.com.helpers.CaptureHelper;
import erp.com.helpers.PropertiesHelper;
import erp.com.helpers.TranslationHelpers;
import erp.com.ulitilities.Log;
import erp.com.ulitilities.WebUI;
import io.cucumber.java.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CucumberHooks {
    TestContext testContext;

    public CucumberHooks(TestContext context) {
        testContext = context;
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("================ beforeAll ================");
        PropertiesHelper.loadAllFile();
        TranslationHelpers.loadAllTranslation(ConstantGlobal.LANGUAGE_ENGLISH);
    }

    @Before
    public void beforeScenario() {
        System.out.println("================ beforeScenario ================");
        //BaseSetup.createDriver(ConstantGlobal.BROWSER);
    }


    @After
    public void afterScenario(Scenario scenario) {
        WebUI.sleep(5);
        System.out.println("================ afterScenario ================");
        DriverManager.quit();
    }
}
