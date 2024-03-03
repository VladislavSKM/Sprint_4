package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Форма оформления заказза
public class PageOrder {

    // Заголовок "Для кого самокат"
    private static final By WHO_IS_THE_SAMOKAT_FOR_HEADER = By.xpath(".//div[text()=\"Для кого самокат\"]");
    // Поле оформления заказа "Имя"
    private static final By FIRST_NAME_ORDER_FIELD = By.xpath(".//input[@placeholder=\"* Имя\"]");
    // Поле оформления заказа "Фамилия"
    private static final By LAST_NAME_ORDER_FIELD = By.xpath(".//input[@placeholder=\"* Фамилия\"]");
    // Поле оформления заказа "Адрес"
    private static final By ADDRESS_ORDER_FIELD = By.xpath(".//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    // Поле оформления заказа "Станция метро"
    private static final By METRO_ORDER_FIELD = By.xpath(".//input[@placeholder=\"* Станция метро\"]");
    // Сисок выводимых станций
    private static final String metroStationFromList = ".//div[@class='select-search has-focus']//*[text()='%s']";
    // Поле оформления заказа "Телефон"
    private static final By PHONE_ORDER_FIELD = By.xpath(".//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");
    // Кнопка "Заказать" в заказзе
    private static final By CONFIRM_ORDER_BUTTON = By.xpath(".//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");

    private WebDriver driver;

    public PageOrder(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderFormVisible() {
        WebElement notFoundElement = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(WHO_IS_THE_SAMOKAT_FOR_HEADER));
        return notFoundElement.isDisplayed();
    }

    public PageOrder clickConfirmOrderButton() {
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
        return this;
    }

    public PageOrder sendOrderLastNane(String lastName) {
        WebElement orderNameFielld = driver.findElement(LAST_NAME_ORDER_FIELD);
        orderNameFielld.clear();
        orderNameFielld.sendKeys(lastName);
        return this;
    }

    public PageOrder sendOrderFirstName(String firstName) {
        WebElement orderNameFielld = driver.findElement(FIRST_NAME_ORDER_FIELD);
        orderNameFielld.clear();
        orderNameFielld.sendKeys(firstName);
        return this;
    }

    public PageOrder sendOrderAddress(String address) {
        WebElement orderNameFielld = driver.findElement(ADDRESS_ORDER_FIELD);
        orderNameFielld.clear();
        orderNameFielld.sendKeys(address);
        return this;
    }

    public PageOrder sendOrderMetro(String metro) {
        WebElement orderNameFielld = driver.findElement(METRO_ORDER_FIELD);
        orderNameFielld.clear();
        orderNameFielld.sendKeys(metro);
        String metroSearchFormatter = String.format(metroStationFromList, metro);
        driver.findElement(By.xpath(metroSearchFormatter)).click();
        return this;
    }

    public PageOrder sendOrderPhone(String name) {
        WebElement orderNameFielld = driver.findElement(PHONE_ORDER_FIELD);
        orderNameFielld.clear();
        orderNameFielld.sendKeys(name);
        return this;
    }

}
