package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DurationListPage extends PageBase{
    public DurationListPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 45);
    }

    By durationList = By.xpath("//ul[@role='listbox']");
    List<WebElement> items = getElement(durationList).findElements(By.tagName("li"));

    public void selectDuration(int durationIndex) throws InterruptedException {
        System.out.println("Search for duration item : " + items.get(durationIndex).getText());
        clickOnButtonUsingJavaScript(items.get(durationIndex));
        Thread.sleep(500);
        waitUntilLoaderDisappear();
    }
}
