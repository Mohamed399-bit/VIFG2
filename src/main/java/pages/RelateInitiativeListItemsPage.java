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

public class RelateInitiativeListItemsPage extends PageBase{
    public RelateInitiativeListItemsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 45);
    }

    By initiativeList = By.xpath("//ul[@role='listbox']");
    List<WebElement> Items = getElement(initiativeList).findElements(By.tagName("li"));

    public void selectInitiative(int index){
        System.out.println("Initiative Name is : " + Items.get(index).getText());
        clickOnButtonUsingJavaScript(Items.get(index));
        waitUntilLoaderDisappear();
    }

    public void VerifyThaInitiativeIsSelected(int index){
        Assert.assertTrue(Items.get(index).isSelected());
    }
}
