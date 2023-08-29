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
import utilities.SetURL;

public class VerifyThatProgramNameIsMandatoryFiledTest extends TestBase {
    CreateFundingRequestStep1Page createFundingRequestStep1Object;
    SearchByInitiativeNamePage searchByInitiativeNameObject;
    InitiativeNameListPage initiativeNameListObject;
    CreateFundingRequestStep1_1Page createFundingRequestStepObject;
    AdministrativeRegionsPage administrativeRegionsObject;
    FundingRequestLunchPage fundingRequestLunchObject;
    ErrorMessagePage errorMessageObject;
    ValidationMessageForFirstStepPage validationMessageForFirstStepObject;
    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify That Program Name Is Mandatory Filed")
    @Feature("Mandatory Filed")
    @Epic("Funding Request")
    public void VerifyThatProgramNameIsMandatoryFiled() throws InterruptedException {
//        fundingRequestLunchObject = new FundingRequestLunchPage(driver);
//        fundingRequestLunchObject.clickOnFundingRequest();

        createFundingRequestStep1Object = new CreateFundingRequestStep1Page(driver);
        createFundingRequestStep1Object.clickOnInitiativeNameTab();

        searchByInitiativeNameObject = new SearchByInitiativeNamePage(driver);
        searchByInitiativeNameObject.clickOnArrowList();

        initiativeNameListObject = new InitiativeNameListPage(driver);
        initiativeNameListObject.SelectInitiativeName(Helper.generateRandomNumber2(0, 4));

        createFundingRequestStep1Object.clickOnValidateButton();

        createFundingRequestStepObject = new CreateFundingRequestStep1_1Page(driver);
        createFundingRequestStepObject.clickOnRelatedByBtn();

        createFundingRequestStepObject.clickOnAdministrativeRegions();

        administrativeRegionsObject = new AdministrativeRegionsPage(driver);
        administrativeRegionsObject.selectAdministrativeRegions(0);
        createFundingRequestStepObject.enterInitiativeOwnerData(Helper.generateRandomWords2(3),
                Helper.generateRandomName(7)+"@Test.com" ,"56"+Helper.generateRandomNumber(7));
        createFundingRequestStepObject.clickOnNextButton();

//        errorMessageObject = new ErrorMessagePage(driver);
//        errorMessageObject.VerifyThatErrorMessageDisplay("جميع البيانات المطلوبة بشكل صحيح");

        validationMessageForFirstStepObject = new ValidationMessageForFirstStepPage(driver);
        validationMessageForFirstStepObject.verifyThatValidationMessageForProgramNameDisplayed("اسم برنامج الرؤية");

        Thread.sleep(1000);
        SetURL.refreshPage();
        Thread.sleep(2000);

    }
}
