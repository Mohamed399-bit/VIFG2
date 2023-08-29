/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 17/08/2023 - Script created.
 */
package CreateFundingRequestFeatures;

import data.LoginExcelReader2;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FundingRequestLunchPage;
import pages.LoginPage;
import pages.LunchPage;
import pages.NewHomePage;
import tests.TestBase;

import java.io.IOException;

public class LoginAsFundingRequestUserTest extends TestBase {

    LunchPage lunchObject;
    LoginPage loginObject;
    NewHomePage newHomeObject;
    FundingRequestLunchPage fundingRequestLunchObject;
    @Test(priority = 1 , dataProvider = "ExcelData")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login To Web")
    @Feature("Login Epic")
    @Epic("Login Epic")
    public void LoginAsCompleteUser(String userName ,String password) throws InterruptedException {

        lunchObject = new LunchPage(driver);
        lunchObject.clickOnGovernmentEntity();

        loginObject = new LoginPage(driver);
        loginObject.loginMethod(userName,password);

        newHomeObject = new NewHomePage(driver);
        newHomeObject.clickOnExistInitiative();
        fundingRequestLunchObject = new FundingRequestLunchPage(driver);
        fundingRequestLunchObject.verifyThatUserLoggedIn("طلبات التمويل");

    }
    @DataProvider(name = "ExcelData")
    public Object[][] LoginTestData() throws IOException {
        LoginExcelReader2 ER = new LoginExcelReader2();
        return ER.getExcelData();
    }
}
