package pageObject;

import org.junit.Assert;
import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainPageSamokat {

    // Главная страница "Яндекс Самокат"
    private static final String PAGE_URL = "http://qa-scooter.praktikum-services.ru/";
    // Кнопка "Заказать" сверху
    private static final By TOP_ORDER_BUTTON = By.xpath(".//button[@class=\"Button_Button__ra12g\"][text()=\"Заказать\"]");
    // Кнопка "Заказать" сниззу
    private static final By BOTTOM_ORDER_BUTTON = By.xpath(".//button[@class=\"Button_Button__ra12g Button_UltraBig__UU3Lp\"][text()=\"Заказать\"]");
    // Заголовок "Вопросы о важном"
    private static final By QUESTION_HEADER = By.xpath(".//div[text()=\"Вопросы о важном\"]");
    // Элемент "Текст вопроса"
    private final By actualQuestion = By.className("accordion__button");
    // Элемент "Текст ответа"
    private final By actualAnswer = By.className("accordion__panel");

    private WebDriver driver;

    public MainPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public MainPageSamokat open() {
        driver.get(PAGE_URL);
        return this;
    }

    public MainPageSamokat clickOrderTopButton() {
        driver.findElement(TOP_ORDER_BUTTON).click();
        return this;
    }

    public MainPageSamokat clickOrderBottomButton() {
        driver.findElement(BOTTOM_ORDER_BUTTON).click();
        return this;
    }

    public void scrollToTheQuestionsHeader() {
        WebElement questionHeader = driver.findElement(QUESTION_HEADER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionHeader);
    }

    public void scrollToTheBottomOrderButton() {
        WebElement questionHeader = driver.findElement(BOTTOM_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionHeader);
    }

    public void clickQuestionButton(int id) {
        List<WebElement> actualQuestionList = driver.findElements(actualQuestion);
        actualQuestionList.get(id).click();
    }

    public void checkQuestionText(String expectedQuestionText, String actualQuestionText) {
        Assert.assertEquals("Значения не совпадают", expectedQuestionText, actualQuestionText);
    }

    public void checkAnswerText(String expectedAnswerText, String actualAnswerText) {
        Assert.assertEquals("Значения не совпадают", expectedAnswerText, actualAnswerText);
    }

    public String getActualQuestionText(int id) {
        List<WebElement> actualQuestionList = driver.findElements(actualQuestion);
        return actualQuestionList.get(id).getText();
    }

    public String getActualAnswerText(int id) {
        List<WebElement> actualAnswersList = driver.findElements(actualAnswer);
        return actualAnswersList.get(id).getText();
    }

    public void makeScreenShot() throws Exception {
        File scrFirle = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path target = Path.of("./image.png");
        Files.delete(target);
        Files.copy(scrFirle.toPath(), target);
    }

}
