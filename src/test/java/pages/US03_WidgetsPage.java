package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US03_WidgetsPage {

    public US03_WidgetsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'January'))]")
    public List<WebElement> january;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'February'))]")
    public List<WebElement> february;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'March'))]")
    public List<WebElement> march;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'April'))]")
    public List<WebElement> april;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'May'))]")
    public List<WebElement> may;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'June'))]")
    public List<WebElement> june;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'July'))]")
    public List<WebElement> july;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'August'))]")
    public List<WebElement> august;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'September'))]")
    public List<WebElement> september;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'October'))]")
    public List<WebElement> october;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'November'))]")
    public List<WebElement> november;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and (contains (@aria-label,'December'))]")
    public List<WebElement> december;

    @FindBy(xpath = "//span[.='Date Picker']")
    public WebElement dataPickerTab;

    @FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[1]")
    public WebElement dateSelected1;

    @FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[2]")
    public WebElement dateSelected2;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement selectMonths;

    @FindBy(id = "datePickerMonthYearInput")
    public WebElement dateLastTab;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement selectYear;

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']")
    public WebElement spaceClick;

    @FindBy(xpath = "//div[@class='react-datepicker__month-read-view']")
    public WebElement selectDateMonth;

    @FindBy(xpath = "//div[@class='react-datepicker__year-read-view']")
    public WebElement selectDateYear;

    @FindBy(id = "dateAndTimePickerInput")
    public WebElement DateResultTab;

    @FindBy(xpath= "//*[text()='Widgets']")
    public WebElement widgetTab;

    @FindBy(xpath = "(//div[@class='react-datepicker__year-option'])[12]")
    public WebElement yearUndoTab;

    public WebElement getHour(String hour) {

        return Driver.getDriver().findElement(By.xpath("//li[contains(@class,'react-datepicker__time-list-item ') and text()='" + hour + "']"));
    }


    public WebElement getYear(String year) {

        return Driver.getDriver().findElement(By.xpath("//div[contains(@class,'react-datepicker__year-option') and text()='" + year + "']"));
    }


    public WebElement getMonth(int month) {

        return Driver.getDriver().findElement(By.xpath("(//div[contains(@class,'react-datepicker__month-option')])[" + month + "]"));
    }


    public WebElement getDay(int day) {

        return Driver.getDriver().findElement(By.xpath("(//*[contains(@class,'react-datepicker__day react-datepicker__day')])[" + (day) + "]"));
    }
}