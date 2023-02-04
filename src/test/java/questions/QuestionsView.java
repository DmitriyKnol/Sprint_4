package questions;

import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

@RunWith(Parameterized.class)
public class QuestionsView {
    WebDriver driver;
    MainPage mainPage = new MainPage(driver);
    private final int numberOfQuest;
    private final String expectedText;

    public QuestionsView(int numberOfQuest, String expectedText) {
        this.numberOfQuest = numberOfQuest;
        this.expectedText = expectedText;
    }

    @Before
    public void initObjects() {
        driver = new ChromeDriver();
        driver.get(mainPage.getUrl());
        WebElement element = driver.findElement(By.cssSelector("#accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Parameterized.Parameters
    public static Object[][] getQuest() {


        return new Object[][]{
                {1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };

    }

    @Test
    public void QuestionsViewTest() {
        driver.findElement(mainPage.showQuest(numberOfQuest)).click();
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(mainPage.displayQuest(numberOfQuest)));
        assertEquals("Текст не получен", expectedText, driver.findElement(mainPage.displayQuest(numberOfQuest)).getText());
    }

    @After
    public void quit() {
        driver.quit();
    }

}
