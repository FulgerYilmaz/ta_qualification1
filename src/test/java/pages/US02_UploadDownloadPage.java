package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US02_UploadDownloadPage {
    public US02_UploadDownloadPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//span[.='Upload and Download']")
    public WebElement uploadTab;

    @FindBy(xpath ="//input[@id='uploadFile']")
    public WebElement chooseFileButton;

    @FindBy(xpath ="//p[@id='uploadedFilePath']")
    public WebElement selectFileVerifyTab;

    @FindBy(xpath ="//*[@id='downloadButton']")
    public WebElement downLoad;


}
