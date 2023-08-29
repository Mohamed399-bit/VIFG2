/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 22/05/2023 - Script created.
 */
package SearchFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.Helper;
import utilities.SetURL;

public class SearchByDurationTest extends TestBase {

    HomePage homeObject;
    ExistInitiativesPage existInitiativesObject;
    SearchPage searchObject;
    DurationListPage durationListObject;

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Search By Valid Duration")
    @Feature("Search By Duration")
    @Epic("Search")
    public void searchByDuration() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnCompletedInitiatives();
        existInitiativesObject.getDataForFirstInitiative();

        homeObject = new HomePage(driver);
        homeObject.clickOnSearchIcon();
        homeObject.scrollDown();

        searchObject = new SearchPage(driver);
        //searchObject.clickOnClearButton();
        searchObject.clickOnDurationList();

        durationListObject = new DurationListPage(driver);
        durationListObject.selectDuration(Helper.generateRandomNumber2(0,4));
        searchObject.clickOnSearchButton();

        existInitiativesObject.VerifyThatSearchByDurationIsTrue();
        //searchObject.clickOnClearButton();
        SetURL.refreshPage();

        Thread.sleep(3000);
    }
}
