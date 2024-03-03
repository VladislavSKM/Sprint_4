package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Страница оформления заказза "Про аренду"
public class RentInfoPage {

    // Заголовок "Про аренду"
    private static final By ABOUT_RENT_HEADER = By.xpath(".//div[text()=\"Про аренду\"]");
    // Поле оформления заказа "Когда привезти самокат"
    private static final By DATE_ORDER_FIELD = By.xpath(".//input[@placeholder=\"* Когда привезти самокат\"]");
    // Поле "Комментарий для курьера"
    private static final By COMMENT_FOR_COURIER_FIELD = By.xpath(".//input[@class=\"Input_Input__1iN_Z Input_Responsible__1jDKN\"][@placeholder=\"Комментарий для курьера\"]");
    // Поле "Срок аренды"
    private static final By RENTAL_PERIOD_FIELD = By.xpath(".//div[@class=\"Dropdown-placeholder\"][text()=\"* Срок аренды\"]");
    // Дата оформления заказа
    private static final By DATE_ORDER_PICKER = By.xpath(".//div[@aria-label=\"Choose воскресенье, 3-е марта 2024 г.\"]");
    // Кнопка "Срок аренды" -> "Двое суток"
    private static final By RENTAL_PERIOD_TWO_DAYS_BITTON = By.xpath(".//div[@class=\"Dropdown-option\"][text()=\"двое суток\"]");
    // Кнопка "Срок аренды" -> "Двое суток"
    private static final By RENTAL_PERIOD_ONE_DAY_BITTON = By.xpath(".//div[@class=\"Dropdown-option\"][text()=\"сутки\"]");
    // Поле "Цвет самоката"
    private static final By SAMOKAT_COLOR_BLACK_CHECKBOX = By.xpath(".//input[@class=\"Checkbox_Input__14A2w\"][@id=\"black\"]");
    // Поле "Цвет самоката"
    private static final By SAMOKAT_GREY_BLACK_CHECKBOX = By.xpath(".//input[@class=\"Checkbox_Input__14A2w\"][@id=\"grey\"]");
    // Кнопка "Заказать" в заказзе
    private static final By CONFIRM_ORDER_BUTTON = By.xpath(".//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");

    private WebDriver driver;

    public RentInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderAboutRentVisible() {
        WebElement notFoundElement = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(ABOUT_RENT_HEADER));
        return notFoundElement.isDisplayed();
    }

    public RentInfoPage sendCommentForCourier(String comment) {
        WebElement orderNameFielld = driver.findElement(COMMENT_FOR_COURIER_FIELD);
        orderNameFielld.clear();
        orderNameFielld.sendKeys(comment);
        return this;
    }

    public RentInfoPage clickDataOrderButton() {
        driver.findElement(DATE_ORDER_FIELD).click();
        return this;
    }

    public RentInfoPage clickDataPickerOrderButton() {
        driver.findElement(DATE_ORDER_PICKER).click();
        return this;
    }

    public RentInfoPage clickRentalPeriodOrderField() {
        driver.findElement(RENTAL_PERIOD_FIELD).click();
        return this;
    }

    public RentInfoPage clickRentalPeriodTwoDaysOrderButton() {
        driver.findElement(RENTAL_PERIOD_TWO_DAYS_BITTON).click();
        return this;
    }

    public RentInfoPage clickRentalPeriodOneDayOrderButton() {
        driver.findElement(RENTAL_PERIOD_ONE_DAY_BITTON).click();
        return this;
    }


    public RentInfoPage clickBlackColorSamokatOrderButton() {
        driver.findElement(SAMOKAT_COLOR_BLACK_CHECKBOX).click();
        return this;
    }

    public RentInfoPage clickGreykColorSamokatOrderButton() {
        driver.findElement(SAMOKAT_GREY_BLACK_CHECKBOX).click();
        return this;
    }

    public RentInfoPage clickConfirmOrderButton() {
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
        return this;
    }
}
