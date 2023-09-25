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
import pages.*;
import tests.TestBase;
import utilities.Helper;
import utilities.SetURL;

public class CancelCompleteInitiativeDataTest extends TestBase {

    ExistInitiativesPage existInitiativesObject;
    InitiativeDetailsPage initiativeDetailsObject;
    initiativeFundingStatusFiledPage initiativeFundingStatusFiledObject;
    InitiativeClassificationPage initiativeClassificationObject;
    InitiativeAchievedSavingsPage initiativeAchievedSavingsObject;
    OwnerEntityPage ownerEntityObject;
    CalenderPage calenderObject;
    HomePage homeObject;
    int randomNumMonth = Helper.generateRandomNumber2(0,11);
    int randomYear = Helper.generateRandomNumber2(2020,2022);
    int randomNumDay = Helper.generateRandomNumber2(1,30);
    int randomNumMonth2 = Helper.generateRandomNumber2(0,11);
    int randomYear2 = Helper.generateRandomNumber2(2023,2024);
    int randomNumDay2 = Helper.generateRandomNumber2(1,30);
    int durationNumber = Helper.generateRandomNumber2(10,30);
    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Cancel Complete Initiative Data")
    @Feature("Cancel Complete Initiative Data")
    @Epic("Uncompleted Initiative")
    public void CancelCompleteInitiativeData() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnUnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        existInitiativesObject.scrollDown();
        existInitiativesObject.clickOnEditInitiativeNumber(existInitiativesObject.UICNumber);
        System.out.println("Initiative Name : " + existInitiativesObject.initiativeNameTxt);

        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.enterStrategicObjective(Helper.generateRandomWords2(50));
        initiativeDetailsObject.clickOnOwnerList();

        ownerEntityObject = new OwnerEntityPage(driver);
        ownerEntityObject.SelectEntity(Helper.generateRandomNumber2(0,10));

        initiativeDetailsObject.clickOnInitiativeFundingStatus();

        initiativeFundingStatusFiledObject = new initiativeFundingStatusFiledPage(driver);
        initiativeFundingStatusFiledObject.SelectInitiativeFundingStatus(Helper.generateRandomNumber2(0,3));

        initiativeDetailsObject.clickOnInitiativeClassification();

        initiativeClassificationObject = new InitiativeClassificationPage(driver);
        initiativeClassificationObject.SelectInitiativeClassification(Helper.generateRandomNumber2(0,1));

        initiativeDetailsObject.enterApprovedCosts(Helper.generateRandomNumber(5)+"000");
        initiativeDetailsObject.clickOnEditIcon();

        initiativeAchievedSavingsObject = new InitiativeAchievedSavingsPage(driver);
        initiativeAchievedSavingsObject.enterInitiativeAchievedSavings(Helper.generateRandomNumber(3)+"000");

        initiativeDetailsObject.enterInitiativeDescription(Helper.generateRandomWords2(400));
        initiativeDetailsObject.clickOnCalenderIcon();

        calenderObject = new CalenderPage(driver);
        calenderObject.selectMonthByIndex(randomNumMonth);
        calenderObject.selectYearByText(Integer.toString(randomYear));
        calenderObject.selectDay(Integer.toString(randomNumDay));

        initiativeDetailsObject.clickOnCalenderEndDateIcon();

        calenderObject.selectYearByText(Integer.toString(randomYear2));
        calenderObject.selectMonthByIndex(randomNumMonth2);
        calenderObject.selectDay(Integer.toString(randomNumDay2));
        initiativeDetailsObject.clickOnCancelButton();

        Thread.sleep(2000);
        homeObject = new HomePage(driver);
        homeObject.verifyThatUserLoggedIn("المبادرات القائمة");

        SetURL.refreshPage();

        Thread.sleep(2000);

    }
}
