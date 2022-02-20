package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US03_WidgetsPage {

    public US03_WidgetsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Date Picker']")
    public WebElement dataPickerTab;

    @FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[1]")
    public WebElement dateSelected1;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement selectMonths;

    @FindBy(id = "datePickerMonthYearInput")
    public WebElement dateLastTab;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement selectYear;

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgetTab;

    public WebElement getDay(int day) {
     return Driver.getDriver().findElement(By.xpath("(//*[contains(@class,'react-datepicker__day react-datepicker__day')])[" + (day) + "]"));
    }
}