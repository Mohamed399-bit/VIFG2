/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 17/08/2023 - Script created.
 */
package tests;

import org.testng.annotations.Test;
import pages.*;
import utilities.Helper;

public class CreateFundingRequestTest extends TestBase{

    FundingRequestLunchPage fundingRequestLunchObject;
    CreateFundingRequestStep1Page createFundingRequestStep1Object;
    SearchByInitiativeNamePage searchByInitiativeNameObject;
    InitiativeNameListPage initiativeNameListObject;
    CreateFundingRequestStep1_1Page createFundingRequestStepObject;
    RelatedInitiativePage relatedInitiativeObject;
    VRPProgramListPage vrpProgramListObject;
    RelateInitiativeListItemsPage relateInitiativeListItemsObject;
    AdministrativeRegionsPage administrativeRegionsObject;
    @Test(priority = 2)
    public void CreateFundingRequest() throws InterruptedException {
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
        createFundingRequestStepObject.clickOnRelatedByBtn();

        relatedInitiativeObject = new RelatedInitiativePage(driver);
        relatedInitiativeObject.clickOnVrpProgramList();

        vrpProgramListObject = new VRPProgramListPage(driver);
        vrpProgramListObject.selectProgramName2(0);

        relatedInitiativeObject.clickOnRelatedInitiativeList();

        relateInitiativeListItemsObject = new RelateInitiativeListItemsPage(driver);
        relateInitiativeListItemsObject.selectInitiative(0);

        createFundingRequestStepObject.clickOnAdministrativeRegions();

        administrativeRegionsObject = new AdministrativeRegionsPage(driver);
        administrativeRegionsObject.selectAdministrativeRegions(0);
        createFundingRequestStepObject.enterInitiativeOwnerData(Helper.generateRandomWords2(3),
                Helper.generateRandomName(7)+"@Test.com" ,"56"+Helper.generateRandomNumber(8));


        Thread.sleep(7000);

    }
}
