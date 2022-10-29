package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    // Стрелочка открывающая текст вопроса 1
    private final By showQuest_1 = By.id("accordion__heading-0");
    // Окно текста вопроса 1
    private final By displayQuest_1 = By.xpath(".//div/p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    // Стрелочка открывающая текст вопроса 2
    private final By showQuest_2 = By.id("accordion__heading-1");
    // Окно текста вопроса 2
    private final By displayQuest_2 = By.xpath(".//div/p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    // Стрелочка открывающая текст вопроса 3
    private final By showQuest_3 = By.id("accordion__heading-2");
    // Окно текста вопроса 3
    private final By displayQuest_3 = By.xpath(".//div/p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    // Стрелочка открывающая текст вопроса 4
    private final By showQuest_4 = By.id("accordion__heading-3");

    // Окно текста вопроса 4
    private final By displayQuest_4 = By.xpath(".//div/p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    // Стрелочка открывающая текст вопроса 5
    private final By showQuest_5 = By.id("accordion__heading-4");
    // Окно текста вопроса 5
    private final By displayQuest_5 = By.xpath(".//div/p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    // Стрелочка открывающая текст вопроса 6
    private final By showQuest_6 = By.id("accordion__heading-5");
    // Окно текста вопроса 6
    private final By displayQuest_6 = By.xpath(".//div/p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    // Стрелочка открывающая текст вопроса 7
    private final By showQuest_7 = By.id("accordion__heading-6");
    // Окно текста вопроса 7
    private final By displayQuest_7 = By.xpath(".//div/p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");
    // Стрелочка открывающая текст вопроса 8
    private final By showQuest_8 = By.id("accordion__heading-7");
    // Окно текста вопроса 8
    private final By displayQuest_8 = By.xpath(".//div/p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");
    private final WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public By showQuest(int numberQuest) {
        if (numberQuest == 1) {
            return showQuest_1;
        } else if (numberQuest == 2) {
            return showQuest_2;
        } else if (numberQuest == 3) {
            return showQuest_3;
        } else if (numberQuest == 4) {
            return showQuest_4;
        } else if (numberQuest == 5) {
            return showQuest_5;
        } else if (numberQuest == 6) {
            return showQuest_6;
        } else if (numberQuest == 7) {
            return showQuest_7;
        } else {
            return showQuest_8;
        }
    }

    public By displayQuest(int numberQuest) {
        if (numberQuest == 1) {
            return displayQuest_1;
        } else if (numberQuest == 2) {
            return displayQuest_2;
        } else if (numberQuest == 3) {
            return displayQuest_3;
        } else if (numberQuest == 4) {
            return displayQuest_4;
        } else if (numberQuest == 5) {
            return displayQuest_5;
        } else if (numberQuest == 6) {
            return displayQuest_6;
        } else if (numberQuest == 7) {
            return displayQuest_7;
        } else
            return displayQuest_8;
    }
}
