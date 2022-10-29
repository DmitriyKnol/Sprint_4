package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class RegistrationOrderPage {

    // Кнопка "Заказать Вверху страницы"
    private final By buttonOrderUp = By.xpath(".//div[@Class='Header_Nav__AGCXC']/button[text()='Заказать']");

    // Кнопка "Заказать внизу страницы"
    private final By buttonOrderDown = By.xpath(".//div[@Class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    // Поле Имя
    private final By inputFirstName = By.xpath(".//input[@placeholder='* Имя']");

    // Поле Фамилия
    private final By inputSecondName = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле Адес
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле Станция метро
    private final By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");

    // Поле Телефон
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка далее, после заполнение регистрационных данных
    private final By buttonNext = By.xpath(".//div[@Class='Order_NextButton__1_rCA']/button[text()='Далее']");

    private final WebDriver driver;

    public RegistrationOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonOrderUp() {
        driver.findElement(buttonOrderUp).click();
    }

    public void clickButtonOrderDown() {
        driver.findElement(buttonOrderDown).click();
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void inputValueFirstName(String firstName) {
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    public void inputValueSecondName(String secondName) {
        driver.findElement(inputSecondName).sendKeys(secondName);
    }

    public void inputValueAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void inputValueMetro(String metro) {
        new Actions(driver).moveToElement(driver.findElement(inputMetro)).click().sendKeys(metro)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    public void inputValuePhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }

    public void clickButtonOrder(int type) {
        if (type == 1) {
            clickButtonOrderUp();
        } else {
            WebElement element = driver.findElement(buttonOrderDown);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            clickButtonOrderDown();
        }
    }

    public void enterValueOrder(String firstName, String secondName, String address, String metro, String phoneNumber) {
        inputValueFirstName(firstName);
        inputValueSecondName(secondName);
        inputValueAddress(address);
        inputValueMetro(metro);
        inputValuePhoneNumber(phoneNumber);
        clickButtonNext();
    }

}
