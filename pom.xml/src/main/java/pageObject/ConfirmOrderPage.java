package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Страница подстверждения оформления заказза
public class ConfirmOrderPage {

    // Заголовок "Хотите оформить заказ?"
    private static final By WOULD_YOU_LIKE_TO_CONFIRM_ORDER_HEADER = By.xpath(".//div[@class=\"Order_ModalHeader__3FDaJ\"][text()=\"Хотите оформить заказ?\"]");
    // Кнопка подтверждения заказаз "Да"
    private final By CONFIRM_YES_BITTON = By.xpath(".//button[text()=\"Да\"]");

    private WebDriver driver;

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderConfirmFormVisible() {
        WebElement notFoundElement = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(WOULD_YOU_LIKE_TO_CONFIRM_ORDER_HEADER));
        return notFoundElement.isDisplayed();
    }

    public ConfirmOrderPage clickConfirmYesButton() {
        driver.findElement(CONFIRM_YES_BITTON).click();
        return this;
    }
}
