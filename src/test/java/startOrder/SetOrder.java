package startOrder;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;
import pom.RegistrationOrderPage;
import pom.SelectModelOrderPage;


import java.time.Duration;

import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class SetOrder {

    private final String firstName;
    private final String secondName;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String duration;
    private final int colour;
    private final String comment;
    private final String date;
    private final int typeButton;
    WebDriver driver = new ChromeDriver();
    MainPage mainPage = new MainPage(driver);
    RegistrationOrderPage registrationOrderPage = new RegistrationOrderPage(driver);
    SelectModelOrderPage selectModelOrderPage = new SelectModelOrderPage(driver);

    public SetOrder(String firstName, String secondName, String address, String metro, String phoneNumber, String date, String duration, int colour, String comment, int typeButton) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.duration = duration;
        this.colour = colour;
        this.comment = comment;
        this.date = date;
        this.typeButton = typeButton;
    }

    @Before
    public void initOrder() {
        driver.get(mainPage.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Parameterized.Parameters
    public static Object[][] getQuest() {
        return new Object[][]{
                {"Алексей", "Быков", "Луганская", "Черкизовская", "892223332524", "3.11.22", "сутки", 1, "Быстрее бы", 1},
                {"Дмитрий", "Алексеев", "Салютная", "Сокольники", "892225532524", "4.12.22", "двое суток", 2, "Приехать в 17.00", 1},
                {"Валерий", "Петров", "Театральная", "Лубянка", "892223332644", "30.10.22", "трое суток", 1, "Буду рад", 1},
                {"Алексей", "Быков", "Луганская", "Черкизовская", "892223332524", "3.11.22", "сутки", 1, "Быстрее бы", 2},
                {"Дмитрий", "Алексеев", "Салютная", "Сокольники", "892225532524", "4.12.22", "двое суток", 2, "Приехать в 17.00", 2},
                {"Валерий", "Петров", "Театральная", "Лубянка", "892223332644", "30.10.22", "трое суток", 1, "Буду рад", 2},

        };
    }

    @Test
    public void SetOrderClickOnButtonUp() {
        registrationOrderPage.clickButtonOrder(typeButton);
        registrationOrderPage.enterValueOrder(firstName, secondName, address, metro, phoneNumber);
        selectModelOrderPage.enterPeremetres(date, duration, comment, colour);
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(selectModelOrderPage.getDisplaySuccessful()));
        MatcherAssert.assertThat(driver.findElement(selectModelOrderPage.getDisplaySuccessful()).getText(), startsWith("Заказ оформлен"));
    }

    @After
    public void quit() {
        driver.quit();
    }

}
