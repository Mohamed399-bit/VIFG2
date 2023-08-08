package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AccountDataDetailsPage extends PageBase{
    public AccountDataDetailsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
    }

    By accountDetails = By.xpath("//td[@colspan='4']");
    List<WebElement> amounts = getElement(accountDetails).findElements(By.tagName("p"));
    WebElement contractAmount = amounts.get(0);
    WebElement costAmount = amounts.get(1);
    WebElement allocateAmount = amounts.get(2);
    WebElement actualAmount = amounts.get(3);
    WebElement actualAmount2 = amounts.get(4);

    public void VerifyThatDataIsAppear(){

        Assert.assertNotEquals(contractAmount.getText(),"");
        System.out.println("Contract Amount is : " + contractAmount.getText());
        Assert.assertNotEquals(costAmount.getText(),"");
        System.out.println("Cost Amount is : " + costAmount.getText());
        Assert.assertNotEquals(allocateAmount.getText(),"");
        System.out.println("Allocate Amount is : " + allocateAmount.getText());
        Assert.assertNotEquals(actualAmount.getText(),"");
        System.out.println("Actual Amount is : " + actualAmount.getText());
        Assert.assertNotEquals(actualAmount2.getText(),"");
        System.out.println("Actual Amount2 is : " + actualAmount2.getText());

    }
}
