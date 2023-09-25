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

public class EnterRelatedInitiativeDataTest extends TestBase {
    CreateFundingRequestStep1_1Page createFundingRequestStepObject;
    RelatedInitiativePage relatedInitiativeObject;
    VRPProgramListPage vrpProgramListObject;
    RelateInitiativeListItemsPage relateInitiativeListItemsObject;
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Enter Related Initiatives Data")
    @Feature("Enter Related Initiatives")
    @Epic("Funding Request")
    public void EnterRelatedInitiativesData() throws InterruptedException {

        createFundingRequestStepObject = new CreateFundingRequestStep1_1Page(driver);
        createFundingRequestStepObject.clickOnRelatedByBtn();

        relatedInitiativeObject = new RelatedInitiativePage(driver);
        relatedInitiativeObject.clickOnVrpProgramList();

        vrpProgramListObject = new VRPProgramListPage(driver);
        vrpProgramListObject.selectProgramName2(Helper.generateRandomNumber2(0, 4));

        relatedInitiativeObject.clickOnRelatedInitiativeList();

        relateInitiativeListItemsObject = new RelateInitiativeListItemsPage(driver);
        relateInitiativeListItemsObject.selectInitiative(Helper.generateRandomNumber2(0, 4));
        //relateInitiativeListItemsObject.VerifyThaInitiativeIsSelected(0);

        Thread.sleep(1000);

    }
}
