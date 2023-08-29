/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 17/08/2023 - Script created.
 */
package CreateFundingRequestFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.Helper;

public class SearchForInitiativeByNameTest extends TestBase {

    FundingRequestLunchPage fundingRequestLunchObject;
    CreateFundingRequestStep1Page createFundingRequestStep1Object;
    SearchByInitiativeNamePage searchByInitiativeNameObject;
    InitiativeNameListPage initiativeNameListObject;
    CreateFundingRequestStep1_1Page createFundingRequestStepObject;
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search For Initiative By Name")
    @Feature("Search For Initiative")
    @Epic("Funding Request")
    public void SearchForInitiativeByName() throws InterruptedException {
        fundingRequestLunchObject = new FundingRequestLunchPage(driver);
        fundingRequestLunchObject.clickOnFundingRequest();

        createFundingRequestStep1Object = new CreateFundingRequestStep1Page(driver);
        createFundingRequestStep1Object.clickOnInitiativeNameTab();

        searchByInitiativeNameObject = new SearchByInitiativeNamePage(driver);
        searchByInitiativeNameObject.clickOnArrowList();

        initiativeNameListObject = new InitiativeNameListPage(driver);
        initiativeNameListObject.SelectInitiativeName(Helper.generateRandomNumber2(0, 4));

        createFundingRequestStep1Object.clickOnValidateButton();

        createFundingRequestStepObject = new CreateFundingRequestStep1_1Page(driver);
        createFundingRequestStepObject.VerifyThatManinDataIsDisplay();

        Thread.sleep(1000);

    }
}
