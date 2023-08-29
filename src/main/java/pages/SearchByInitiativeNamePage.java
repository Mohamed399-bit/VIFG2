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

public class SearchByInitiativeNamePage extends PageBase{
    public SearchByInitiativeNamePage(WebDriver driver) {
        super(driver);
    }

    By arrowList = By.xpath("//div[@role='button']");

    public void clickOnArrowList() throws InterruptedException {
        Thread.sleep(1500);
        clickButton(arrowList);
    }
}
