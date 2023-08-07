package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AccountDataDetailsPage extends PageBase{
    public AccountDataDetailsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
    }

    By accountDetails = By.xpath("//td[@colspan='4']");
    List<WebElement> p = getElement(accountDetails).findElements(By.tagName("p"));
    WebElement contractAmount = p.get(0);
    WebElement costAmount = p.get(1);
    WebElement allocateAmount = p.get(2);
    WebElement ActualAmount = p.get(3);
    WebElement ActualAmount2 = p.get(4);

    public void VerifyThatDataIsAppear(){

        Assert.assertNotEquals(contractAmount.getText(),"");
        System.out.println("Contract Amount is : " + contractAmount.getText());
        Assert.assertNotEquals(costAmount.getText(),"");
        System.out.println("Cost Amount is : " + costAmount.getText());
        Assert.assertNotEquals(allocateAmount.getText(),"");
        System.out.println("Allocate Amount is : " + allocateAmount.getText());
        Assert.assertNotEquals(ActualAmount.getText(),"");
        System.out.println("Actual Amount is : " + ActualAmount.getText());
        Assert.assertNotEquals(ActualAmount2.getText(),"");
        System.out.println("Actual Amount2 is : " + ActualAmount2.getText());

    }
}
