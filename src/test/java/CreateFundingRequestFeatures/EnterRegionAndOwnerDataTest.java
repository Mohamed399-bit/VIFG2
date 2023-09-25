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

public class EnterRegionAndOwnerDataTest extends TestBase {
    CreateFundingRequestStep1_1Page createFundingRequestStepObject;
    AdministrativeRegionsPage administrativeRegionsObject;
    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Enter Region And Owner Data")
    @Feature("Enter Region And Owner")
    @Epic("Funding Request")
    public void EnterRegionAndOwnerData() throws InterruptedException {

        createFundingRequestStepObject = new CreateFundingRequestStep1_1Page(driver);
        createFundingRequestStepObject.clickOnAdministrativeRegions();

        administrativeRegionsObject = new AdministrativeRegionsPage(driver);
        administrativeRegionsObject.selectAdministrativeRegions(Helper.generateRandomNumber2(0, 4));
        createFundingRequestStepObject.enterInitiativeOwnerData(Helper.generateRandomWords2(3),
                Helper.generateRandomName(7)+"@Test.com" ,"56"+Helper.generateRandomNumber(7));
        Thread.sleep(1000);

    }
}
