package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Страница оформленной заявки заказа
public class IssueOrderPage {

    // Заголовок "Заказ оформлен"
    private static final By THE_ORDER_IS_ISSUE_HEADER = By.xpath(".//div[text()=\"Заказ оформлен\"]");

    private WebDriver driver;

    public IssueOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderIssueVisible() {
        WebElement notFoundElement = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(THE_ORDER_IS_ISSUE_HEADER));
        return notFoundElement.isDisplayed();
    }
}
