/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 17/08/2023 - Script created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RelatedInitiativePage extends PageBase{
    public RelatedInitiativePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
    }

    By VrpProgramList = By.xpath("//ncgr-dropdown[@formcontrolname='vrpProgram']");

    By relatedInitiative = By.xpath("//ncgr-dropdown[@formcontrolname='relatedInitiative']");
    By UICCodeTxt = By.xpath("//input[@formcontrolname='uic']");
    public void clickOnVrpProgramList() throws InterruptedException {
        clickButton(VrpProgramList);
        Thread.sleep(1000);
        waitUntilLoaderDisappear();
    }

    public void clickOnRelatedInitiativeList() throws InterruptedException {
        Thread.sleep(2000);
        clickButton(relatedInitiative);
        waitUntilLoaderDisappear();
    }

    public void getUICCode() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("UIC Code Is : " + getTxt(UICCodeTxt));
    }
}
