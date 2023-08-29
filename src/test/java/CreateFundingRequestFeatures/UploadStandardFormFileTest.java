package CreateFundingRequestFeatures;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AttachmentsFilePage;
import pages.CreateFundingRequestStep1_1Page;
import tests.TestBase;

public class UploadStandardFormFileTest extends TestBase {

    CreateFundingRequestStep1_1Page createFundingRequestStepObject;
    AttachmentsFilePage attachmentsFileObject;
    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Upload Standard Form File")
    @Feature("Upload Standard Form File")
    @Epic("Funding Request")
    public void UploadStandardFormFile() throws InterruptedException {

        createFundingRequestStepObject = new CreateFundingRequestStep1_1Page(driver);
        createFundingRequestStepObject.UploadFile();

        attachmentsFileObject = new AttachmentsFilePage(driver);
        attachmentsFileObject.waitUntilFileUploaded();

        Thread.sleep(7000);
    }
}
