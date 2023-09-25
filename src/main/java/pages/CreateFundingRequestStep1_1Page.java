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

public class CreateFundingRequestStep1_1Page extends PageBase{
    public CreateFundingRequestStep1_1Page(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
        jse = (JavascriptExecutor) driver;
    }

    By relatedByRadioBtn = By.xpath("//span[@class='ncgr-inputswitch__slider ncgr-inputswitch__slider-large']");
    By initiativeOwnerNameTxt = By.xpath("//input[@formcontrolname='initiativeOwnerName']");
    By initiativeOwnerEmailTxt = By.xpath("//input[@formcontrolname='initiativeOwnerEmail']");
    By initiativeOwnerPhoneTxt = By.id("phone");
    By administrativeRegions = By.xpath("//ncgr-multi-select[@formcontrolname='administrativeRegions']");
    By expandArrow = By.xpath("//button[@class='ncgr-element ncgr-ripple ncgr-button-raised px-2 ms-3 ncgr-button-text ncgr-button ncgr-component']");
    List<WebElement> uploadedFiles = driver.findElements(By.xpath("//ncgr-fileupload"));
    By nextBtn = By.xpath("//button[@class='ncgr-element ncgr-ripple ncgr-button-arrow-reverse ms-3 ncgr-button ncgr-component']");
//    List<WebElement> validationMessage = driver.findElements(By.xpath("//span[@class='text-danger']"));
//    List<WebElement> validationMessageOwner = driver.findElements(By.xpath("//span[@class='text-danger ng-star-inserted']"));

    public void clickOnRelatedByBtn() throws InterruptedException {
        Thread.sleep(1800);
        scrollToBottom();
        Thread.sleep(1500);
        scrollToBottom();
        clickButton(relatedByRadioBtn);
        waitUntilLoaderDisappear();
    }

    public void enterInitiativeOwnerData(String name ,String email , String phone) throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom2();
        Thread.sleep(1500);
        scrollToBottom2();
        setTextWebElement(initiativeOwnerNameTxt,name);
        System.out.println("Owner Name : " + name);
        setTextWebElement(initiativeOwnerEmailTxt,email);
        System.out.println("Owner Email : " + email);
        setTextWebElement(initiativeOwnerPhoneTxt,phone);
        System.out.println("Owner Phone : " + phone);
    }

    public void clickOnAdministrativeRegions(){
        clickButton(administrativeRegions);
        waitUntilLoaderDisappear();
    }

    public void VerifyThatManinDataIsDisplay(){
        System.out.println("Main data Section is Display : " + getElement(expandArrow).isDisplayed());
        Assert.assertTrue(getElement(expandArrow).isDisplayed());
    }

    public void UploadFile() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom();
        Thread.sleep(1500);
        scrollToBottom();
        Thread.sleep(1500);
        scrollToBottom();
        //System.out.println("Size is : " + uploadedFiles.size());

        Thread.sleep(1000);
       // String fileName = "Test.pdf";
        //String filePath = System.getProperty("user.dir") + "/Uploads/" + fileName;
//        System.out.println(filePath);
        WebElement fileInput = uploadedFiles.get(0).findElement(By.xpath("//input[@type='file']"));
        //fileInput.sendKeys(filePath);
        uploadFile(fileInput);

    }

    public void clickOnNextButton() throws InterruptedException {
        Thread.sleep(1500);
        scrollToBottom();
        Thread.sleep(1500);
        scrollToBottom();
        clickButton(nextBtn);
    }



}
