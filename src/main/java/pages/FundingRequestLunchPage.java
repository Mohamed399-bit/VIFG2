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
import org.testng.Assert;

public class FundingRequestLunchPage extends PageBase{
    public FundingRequestLunchPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
    }

    By fundingLabel = By.xpath("//a[@class='ncgr-ripple ncgr-element ncgr-menuitem__link ng-star-inserted ncgr-menuitem__link-active']");
    By createFundingRequestBtn = By.xpath("//button[@class='ncgr-ripple ncgr-element ncgr-button-primary ncgr-button ncgr-component']");

    public void clickOnFundingRequest(){

        clickButton(createFundingRequestBtn);
        waitUntilLoaderDisappear();
    }
    public void verifyThatUserLoggedIn(String name){
        waitUntilLoaderDisappear();
        Assert.assertEquals(getElement(fundingLabel).getText(),name);
        System.out.println("Label For Exist Initiatives : " + getElement(fundingLabel).getText());
    }
}
