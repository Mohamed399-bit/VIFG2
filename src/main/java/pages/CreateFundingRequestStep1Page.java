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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CreateFundingRequestStep1Page extends PageBase{
    public CreateFundingRequestStep1Page(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
        jse = (JavascriptExecutor) driver;
    }

    By searchTabs = By.xpath("//div[@class='d-flex mb-4']");
    By validatedBtn = By.xpath("//button[@type='submit']");
    By validationMessageForInitiative = By.xpath("//span[@class='text-danger']");
    List<WebElement> searchTabsItem =getElement(searchTabs).findElements(By.tagName("ncgr-radio-button"));

    public void clickOnUICTab () throws InterruptedException {
        waitUntilLoaderDisappear();
        Thread.sleep(1500);
        scrollToBottom2();
        searchTabsItem.get(0).click();
        Thread.sleep(1500);
        waitUntilLoaderDisappear();
    }

    public void clickOnInitiativeNameTab () throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        searchTabsItem.get(1).click();
        Thread.sleep(1500);
        waitUntilLoaderDisappear();
    }

    public void VerifyFromInitiativeNameValidationMessage(String message){
        Assert.assertTrue(getTxt(validationMessageForInitiative).contains(message));
        System.out.println("validation Message For Initiative Name IS : " +  getTxt(validationMessageForInitiative));
    }

    public void VerifyFromInitiativeUICValidationMessage(String message){
        Assert.assertTrue(getTxt(validationMessageForInitiative).contains(message));
        System.out.println("validation Message For Initiative UIC IS : " +  getTxt(validationMessageForInitiative));
    }

    public void clickOnValidateButton() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom3();
        clickButton(validatedBtn);
        Thread.sleep(1500);
        waitUntilLoaderDisappear();
    }
}
