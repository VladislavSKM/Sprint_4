import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.*;

public class SamokatOrderTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void makeOrderTopButton() {
        MainPageSamokat mainPage = new MainPageSamokat(driver);
        // (Форма 1) Главная страница Самоката
        mainPage.open();
        mainPage.clickOrderTopButton();
        // (Форма 2) Страница оформления заказаз
        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.isOrderFormVisible();
        pageOrder.sendOrderFirstName("Винсент");
        pageOrder.sendOrderLastNane("Вега");
        pageOrder.sendOrderAddress("Голандия, Амстердам");
        pageOrder.sendOrderMetro("Международная");
        pageOrder.sendOrderPhone("+79772708357");
        pageOrder.clickConfirmOrderButton();
        // (Форма 3) Страница заказаз "Про аренду"
        RentInfoPage rentInfoPage = new RentInfoPage(driver);
        rentInfoPage.isOrderAboutRentVisible();
        rentInfoPage.clickDataOrderButton();
        rentInfoPage.clickDataPickerOrderButton();
        rentInfoPage.clickRentalPeriodOrderField();
        rentInfoPage.clickRentalPeriodOneDayOrderButton();
        rentInfoPage.clickGreykColorSamokatOrderButton();
        rentInfoPage.sendCommentForCourier("Позвонить за час");
        rentInfoPage.clickConfirmOrderButton();
        // (Форма 4) Страница подтверждения заказза
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driver);
        confirmOrderPage.isOrderConfirmFormVisible();
        confirmOrderPage.clickConfirmYesButton();
        // (Форма 5) Страница успшеного заказа
        IssueOrderPage issueOrderPage = new IssueOrderPage(driver);
        issueOrderPage.isOrderIssueVisible();
    }

    @Test
    public void makeOrderBottomButton() {
        MainPageSamokat mainPage = new MainPageSamokat(driver);
        // (Форма 1) Главная страница Самоката
        mainPage.open();
        mainPage.scrollToTheBottomOrderButton();
        mainPage.clickOrderBottomButton();
        // (Форма 2) Страница оформления заказаз
        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.isOrderFormVisible();
        pageOrder.sendOrderFirstName("Джулс");
        pageOrder.sendOrderLastNane("Уиннфилд");
        pageOrder.sendOrderAddress("США, Лос-Анджелес");
        pageOrder.sendOrderMetro("Китай-город");
        pageOrder.sendOrderPhone("+79777777777");
        pageOrder.clickConfirmOrderButton();
        // (Форма 3) Страница заказаз "Про аренду"
        RentInfoPage rentInfoPage = new RentInfoPage(driver);
        rentInfoPage.isOrderAboutRentVisible();
        rentInfoPage.clickDataOrderButton();
        rentInfoPage.clickDataPickerOrderButton();
        rentInfoPage.clickRentalPeriodOrderField();
        rentInfoPage.clickRentalPeriodTwoDaysOrderButton();
        rentInfoPage.clickBlackColorSamokatOrderButton();
        rentInfoPage.sendCommentForCourier("Не звонить");
        rentInfoPage.clickConfirmOrderButton();
        // (Форма 4) Страница подтверждения заказза
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driver);
        confirmOrderPage.isOrderConfirmFormVisible();
        confirmOrderPage.clickConfirmYesButton();
        // (Форма 5) Страница успшеного заказа
        IssueOrderPage issueOrderPage = new IssueOrderPage(driver);
        issueOrderPage.isOrderIssueVisible();
    }

    @After
    public void tearDown() throws Exception {
        MainPageSamokat mainPage = new MainPageSamokat(driver);
        mainPage.makeScreenShot();
        driver.quit();
    }
}
