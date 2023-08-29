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

import java.util.List;

public class InitiativeNameListPage extends PageBase{
    public InitiativeNameListPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 45);
    }

    By ulItem = By.xpath("//ul[@role='listbox']");
    List<WebElement> initiativeNameItem = getElement(ulItem).findElements(By.tagName("li"));

    public void SelectInitiativeName(int index){
        System.out.println("Selected Initiative Name : " + (initiativeNameItem.get(index).getText()));
        clickOnButtonUsingJavaScript(initiativeNameItem.get(index));
        waitUntilLoaderDisappear();
    }

    public void SelectInitiativeUIC(int index){
        System.out.println("Selected UIC : " + (initiativeNameItem.get(index).getText()));
        clickOnButtonUsingJavaScript(initiativeNameItem.get(index));
        waitUntilLoaderDisappear();
    }
}
