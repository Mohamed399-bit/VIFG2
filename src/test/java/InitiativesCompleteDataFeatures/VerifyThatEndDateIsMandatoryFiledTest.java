/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 01/06/2023 - Script created.
 */

package InitiativesCompleteDataFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;
import utilities.Helper;
import utilities.SetURL;

public class VerifyThatEndDateIsMandatoryFiledTest extends TestBase {
    ExistInitiativesPage existInitiativesObject;
    InitiativeDetailsPage initiativeDetailsObject;
    initiativeFundingStatusFiledPage initiativeFundingStatusFiledObject;
    InitiativeClassificationPage initiativeClassificationObject;
    InitiativeAchievedSavingsPage initiativeAchievedSavingsObject;
    OwnerEntityPage ownerEntityObject;
    CalenderPage calenderObject;
    SavePopupPage savePopupObject;
    ErrorMessagePage errorMessageObject;

    int randomNumMonth = Helper.generateRandomNumber2(0,11);
    int randomYear = Helper.generateRandomNumber2(2020,2023);
    int randomNumDay = Helper.generateRandomNumber2(1,30);

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify That Duration Is Mandatory Field")
    @Feature("Complete Data For Uncompleted Initiative")
    @Epic("Uncompleted Initiative")
    public void VerifyThatDurationIsMandatoryField() throws InterruptedException {

        existInitiativesObject = new ExistInitiativesPage(driver);
        existInitiativesObject.clickOnUnCompletedInitiatives();
        Thread.sleep(2000);
        existInitiativesObject.getDataForFirstInitiative();
        existInitiativesObject.scrollDown();
        existInitiativesObject.clickOnEditInitiativeNumber(existInitiativesObject.UICNumber);
        System.out.println("Initiative Name : " + existInitiativesObject.initiativeNameTxt);

        initiativeDetailsObject = new InitiativeDetailsPage(driver);
        initiativeDetailsObject.waitUntilPageLoaded();
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
        calenderObject.selectYearByIndex(Integer.toString(randomYear));
        calenderObject.selectDay(Integer.toString(randomNumDay));

        initiativeDetailsObject.clickOnSaveButton();

        savePopupObject = new SavePopupPage(driver);
        savePopupObject.clickOnSaveButton();

        errorMessageObject = new ErrorMessagePage(driver);
        errorMessageObject.VerifyThatErrorMessageDisplay("جميع البيانات المطلوبة بشكل صحيح");

        initiativeDetailsObject.VerifyFromEndDateValidationMessage("تاريخ انتهاء المبادرة");
        initiativeDetailsObject.clickOnBackButton();

        SetURL.refreshPage();

        Thread.sleep(2000);

    }
}
