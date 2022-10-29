package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectModelOrderPage {
    //Поле Выбора даты заказа
    private final By inputDateOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Поле выбора срока аренды
    private final By inputDurationOrder = By.xpath(".//div[@class='Dropdown-placeholder']");

    //Кнопка выбора срока "сутки"
    private final By durationOneDay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");

    //Кнопка выбора срока "двое суток"
    private final By durationTwoDay = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");

    // Поле выбора цвета "черный жемчуг"
    private final By colourBikeBlack = By.id("black");

    // Поле выбора цвета "серый"
    private final By colourBikeGrey = By.id("grey");

    // Поле для комментария
    private final By inputCommentOrder = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка "заказать" для завершения заказа
    private final By finishOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка ДА в поле Хотите оформить заказ?
    private final By ButtonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");


    // Окно Заказ оформлен
    private final By displaySuccessful = By.xpath(".//div/[@class='Order_ModalHeader__3FDaJ']");


    private final WebDriver driver;

    public By getDisplaySuccessful() {
        return displaySuccessful;
    }

    public SelectModelOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setColourBikeBlack() {
        driver.findElement(colourBikeBlack).click();
    }

    public void setColourBikeGrey() {
        driver.findElement(colourBikeGrey).click();
    }

    public void setDateOrder(String date) {
        driver.findElement(inputDateOrder).sendKeys(date, Keys.ENTER);
    }

    public void setDurationOrder(String duration) {
        driver.findElement(inputDurationOrder).click();
        driver.findElement(durationOneDay).click();

    }

    public void setCommentOrder(String comment) {
        driver.findElement(inputCommentOrder).sendKeys(comment);
    }

    public void finishOrder() {
        driver.findElement(finishOrder).click();
    }

    public void setButtonYes() {
        driver.findElement(ButtonYes).click();
    }

    public void enterPeremetres(String date, String duration, String comment, int colourBike) {
        setDateOrder(date);
        setDurationOrder(duration);
        setCommentOrder(comment);


        if (colourBike == 1) {
            WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(colourBikeBlack));
            setColourBikeBlack();
        } else {
            WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(colourBikeGrey));
            setColourBikeGrey();
        }
        finishOrder();
        setButtonYes();
    }

}
