/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 24/05/2023 - Script created.
 */
package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;



public class CompletedInitiativeDataTest extends TestBase {

    InitiativeDetailsPage initiativeDetailsObject;
    AccountDataDetailsPage accountDataDetailsObject;
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Complete Data For Uncompleted Initiative")
    @Feature("Complete Data For Uncompleted Initiative")
    @Epic("Uncompleted Initiative")
    public void CompleteDataForUncompletedInitiative() throws InterruptedException {

        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.waitUntilPageLoaded();
        initiativeDetailsObject.OpenAccountDataDetails();

        accountDataDetailsObject = new AccountDataDetailsPage(driver);
        accountDataDetailsObject.VerifyThatDataIsAppear();

        initiativeDetailsObject.clickOnBackButton2();

        Thread.sleep(2000);

    }
}
