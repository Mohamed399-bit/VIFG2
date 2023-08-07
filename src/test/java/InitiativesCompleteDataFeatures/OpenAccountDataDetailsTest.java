/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 24/05/2023 - Script created.
 */
package InitiativesCompleteDataFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AccountDataDetailsPage;
import pages.ExistInitiativesPage;
import pages.InitiativeDetailsPage;
import tests.TestBase;
import utilities.SetURL;


public class OpenAccountDataDetailsTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    InitiativeDetailsPage initiativeDetailsObject;
    AccountDataDetailsPage accountDataDetailsObject;
    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Open Account Data Details")
    @Feature("Complete Data For Uncompleted Initiative")
    @Epic("Uncompleted Initiative")
    public void openAccountDataDetails() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnUnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        existInitiativesObject.scrollDown();
        existInitiativesObject.clickOnViewInitiativeNumber(existInitiativesObject.UICNumber);

        Thread.sleep(2000);
        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.waitUntilPageLoaded();
        initiativeDetailsObject.OpenAccountDataDetails();

        accountDataDetailsObject = new AccountDataDetailsPage(driver);
        accountDataDetailsObject.VerifyThatDataIsAppear();

        initiativeDetailsObject.clickOnBackButton2();

        Thread.sleep(2000);
        SetURL.refreshPage();
        Thread.sleep(1500);

    }
}
