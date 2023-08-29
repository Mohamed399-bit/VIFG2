package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ValidationMessageForFirstStepPage extends PageBase{
    public ValidationMessageForFirstStepPage(WebDriver driver) {
        super(driver);
    }

    By validationMessageForProgramNameTxt = By.xpath("//ncgr-dropdown[@optionvalue='code']/following-sibling::div[@class='ng-star-inserted']");
    By validationMessageForInitiativeNameTxt = By.xpath("//ncgr-dropdown[@optionvalue='initiativeId']/following-sibling::div[@class='ng-star-inserted']");
    By validationMessageForAdministrativeRegionsTxt = By.xpath("//ncgr-multi-select[@formcontrolname='administrativeRegions']/following-sibling::div[@class='ng-star-inserted']");
    By validationMessageForOwnerNameTxt = By.xpath("//input[@formcontrolname='initiativeOwnerName']/following-sibling::div[@class='ng-star-inserted']");
    By validationMessageForOwnerEmailTxt = By.xpath("//input[@formcontrolname='initiativeOwnerEmail']/following-sibling::div[@class='ng-star-inserted']");
    By validationMessageForOwnerPhoneTxt = By.xpath("//ncgr-telinput[@formcontrolname='initiativeOwnerPhone']/following-sibling::div[@class='ng-star-inserted']");


    public void verifyThatValidationMessageForProgramNameDisplayed(String message){
        System.out.println("Validation Message For Program Name : " + getTxt(validationMessageForProgramNameTxt));
        Assert.assertTrue(getTxt(validationMessageForProgramNameTxt).contains(message));
    }

    public void verifyThatValidationMessageForInitiativeNameDisplayed(String message){
        System.out.println("Validation Message For Program Name : " + getTxt(validationMessageForInitiativeNameTxt));
        Assert.assertTrue(getTxt(validationMessageForInitiativeNameTxt).contains(message));
    }

    public void verifyThatValidationMessageForAdministrativeRegionsDisplayed(String message){
        System.out.println("Validation Message For Administrative Regions : " + getTxt(validationMessageForAdministrativeRegionsTxt));
        Assert.assertTrue(getTxt(validationMessageForAdministrativeRegionsTxt).contains(message));
    }

    public void verifyThatValidationMessageForOwnerNameDisplayed(String message){
        System.out.println("Validation Message For Owner Name : " + getTxt(validationMessageForOwnerNameTxt));
        Assert.assertTrue(getTxt(validationMessageForOwnerNameTxt).contains(message));
    }
    public void verifyThatValidationMessageForOwnerEmailDisplayed(String message){
        System.out.println("Validation Message For Owner Email : " + getTxt(validationMessageForOwnerEmailTxt));
        Assert.assertTrue(getTxt(validationMessageForOwnerEmailTxt).contains(message));
    }
    public void verifyThatValidationMessageForOwnerPhoneDisplayed(String message){
        System.out.println("Validation Message For Phone Email : " + getTxt(validationMessageForOwnerPhoneTxt));
        Assert.assertTrue(getTxt(validationMessageForOwnerPhoneTxt).contains(message));
    }

}
