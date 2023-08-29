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
import pages.CreateFundingRequestStep1Page;
import pages.FundingRequestLunchPage;
import tests.TestBase;
import utilities.SetURL;

public class VerifyThatInitiativeUICIsMandatoryFiledTest extends TestBase {

    FundingRequestLunchPage fundingRequestLunchObject;
    CreateFundingRequestStep1Page createFundingRequestStep1Object;
    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify That Initiative Name Is Mandatory Filed")
    @Feature("Mandatory Filed")
    @Epic("Funding Request")
    public void VerifyThatInitiativeNameIsMandatoryFiled() throws InterruptedException {
        fundingRequestLunchObject = new FundingRequestLunchPage(driver);
        fundingRequestLunchObject.clickOnFundingRequest();

        createFundingRequestStep1Object = new CreateFundingRequestStep1Page(driver);
        createFundingRequestStep1Object.clickOnUICTab();
        createFundingRequestStep1Object.clickOnValidateButton();
        createFundingRequestStep1Object.VerifyFromInitiativeUICValidationMessage("الرقم الموحد للمبادرة");

        Thread.sleep(1000);
        SetURL.refreshPage();
        Thread.sleep(2000);

    }
}
