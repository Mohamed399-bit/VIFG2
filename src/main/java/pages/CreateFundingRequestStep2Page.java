package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateFundingRequestStep2Page extends PageBase{
    public CreateFundingRequestStep2Page(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
    }


    List<WebElement> RequestTypeList = driver.findElements(By.name("requestFundingTypeId"));
    List<WebElement> CapexAndOpexTxt = driver.findElements(By.xpath("//input[@type='number']"));

    List<WebElement> tables = driver.findElements(By.xpath("//table[@role='table']"));

    WebElement costTable = tables.get(0);
    WebElement currentYearCost = tables.get(1);
    WebElement revenueTable = tables.get(2);

    public void clickOnStudyOnly(){
        click(RequestTypeList.get(0));
    }

    public void clickOnNewFunding(){
        click(RequestTypeList.get(1));
    }

    public void clickOnReturnFunding(){
        click(RequestTypeList.get(2));
    }

    public void enterCapex(String capex){
        CapexAndOpexTxt.get(0).sendKeys(capex);
    }

    public void enterOpex(String opex){
        CapexAndOpexTxt.get(1).sendKeys(opex);
    }

    public void enterTotalCost(String value){

        WebElement tbody = costTable.findElement(By.tagName("tbody"));
        List<WebElement> trs = tbody.findElements(By.tagName("tr"));
        for (WebElement ele : trs){
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            for (WebElement ele2 : tds.subList( 1, tds.size()-1)){

                WebElement editIcon = ele2.findElement(By.xpath("//span[@class='icon-edit ms-5 text-success ng-star-inserted']"));
                editIcon.click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='number']")));
                WebElement input = ele2.findElement(By.xpath("//input[@type='number']"));
                input.sendKeys(value);
            }
        }
    }

    public void enterYearlyCost(String value){
        WebElement tbody = currentYearCost.findElement(By.tagName("tbody"));
        List<WebElement> trs = tbody.findElements(By.tagName("tr"));
        for (WebElement ele : trs){
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            for (WebElement ele2 : tds.subList( 1, tds.size()-1)){

                WebElement editIcon = ele2.findElement(By.xpath("//span[@class='icon-edit ms-5 text-success ng-star-inserted']"));
                editIcon.click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='number']")));
                WebElement input = ele2.findElement(By.xpath("//input[@type='number']"));
                input.sendKeys(value);
            }
        }
    }

    public void enterRevenuePerYear(String value){
        WebElement tbody = revenueTable.findElement(By.tagName("tbody"));
        List<WebElement> trs = tbody.findElements(By.tagName("tr"));
        for (WebElement ele : trs){
            List<WebElement> tds = ele.findElements(By.tagName("td"));
            for (WebElement ele2 : tds.subList( 1, tds.size()-1)){

                WebElement editIcon = ele2.findElement(By.xpath("//span[@class='icon-edit ms-5 text-success ng-star-inserted']"));
                editIcon.click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='number']")));
                WebElement input = ele2.findElement(By.xpath("//input[@type='number']"));
                input.sendKeys(value);
            }
        }
    }
}
