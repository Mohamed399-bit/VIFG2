package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ValidationMessageForOwnerDetailsPage extends PageBase{
    public ValidationMessageForOwnerDetailsPage(WebDriver driver) {
        super(driver);
    }

    List<WebElement> validationMessageOwner = driver.findElements(By.xpath("//span[@class='text-danger ng-star-inserted']"));

    public void verifyThatValidationMessageForOwnerNameDisplayed(String message){
        System.out.println("Validation Message For Owner Name : " + validationMessageOwner.get(0).getText().contains(message));
        Assert.assertTrue(validationMessageOwner.get(0).getText().contains(message));
    }

    public void verifyThatValidationMessageForOwnerEmailDisplayed(String message){
        System.out.println("Validation Message For Owner Email : " + validationMessageOwner.get(1).getText().contains(message));
        Assert.assertTrue(validationMessageOwner.get(1).getText().contains(message));
    }

    public void verifyThatValidationMessageForOwnerPhoneDisplayed(String message){
        System.out.println("Validation Message For Phone Email : " + validationMessageOwner.get(2).getText().contains(message));
        Assert.assertTrue(validationMessageOwner.get(2).getText().contains(message));
    }
}
