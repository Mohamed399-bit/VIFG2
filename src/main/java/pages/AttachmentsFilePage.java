package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AttachmentsFilePage extends PageBase{
    public AttachmentsFilePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 45);
    }

    By file = By.tagName("ncgr-file-attachments");

    public void waitUntilFileUploaded(){
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(file)));
        System.out.println("File Uploaded");

    }

}
