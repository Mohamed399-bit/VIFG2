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

import java.util.List;

public class AdministrativeRegionsPage extends PageBase{
    public AdministrativeRegionsPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    By administrativeRegionsList = By.xpath("//ul[@role='listbox']");
    By headerOfSection = By.xpath("//h5[contains(text(),'المناطق الادارية المستهدفة')]");
    List<WebElement> listItems = getElement(administrativeRegionsList).findElements(By.tagName("li"));

    public void     selectAdministrativeRegions (int index) throws InterruptedException {
        System.out.println("Administrative Regions is : " + listItems.get(index).getText());
        clickOnButtonUsingJavaScript(listItems.get(index));
        Thread.sleep(1500);
       // clickOnButtonUsingJavaScript(getElement(headerOfSection));
        clickButton(headerOfSection);
    }

}
