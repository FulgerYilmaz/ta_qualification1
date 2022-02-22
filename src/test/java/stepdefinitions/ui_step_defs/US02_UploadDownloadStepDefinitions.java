package stepdefinitions.ui_step_defs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US02_UploadDownloadPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;

public class US02_UploadDownloadStepDefinitions {

    US02_UploadDownloadPage uploadDownloadPage = new US02_UploadDownloadPage();
    Actions actions = new Actions(Driver.getDriver());

    @And("user clicks the upload button")
    public void user_clicks_the_upload_button() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitAndClick(uploadDownloadPage.uploadTab, 1);
    }

    @Given("user chooses the file button")
    public void user_chooses_the_file_button() {
        uploadDownloadPage.chooseFileButton.sendKeys("C:/Users/Asus/Pictures/message.png");
    }

    @Given("verify the visibility of the selected file")
    public void verify_the_visibility_of_the_selected_file() {
        System.out.println(uploadDownloadPage.selectFileVerifyTab.getText());
        Assert.assertTrue(uploadDownloadPage.selectFileVerifyTab.getText().contains("message"));
    }

    @Given("user download a file")
    public void user_download_a_file() {
        ReusableMethods.waitFor(1);
        uploadDownloadPage.downLoad.click();
    }

    @Given("Verify the visibility of the downloaded file")
    public void Verify_the_visibility_of_the_downloaded_file() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(Files.exists(Paths.get("C:/Users/Asus/Downloads/sampleFile.jpeg")));
    }
}
