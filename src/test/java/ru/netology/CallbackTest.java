package ru.netology;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldTestHappyPath1() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Иванова Анна");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestHappyPath2() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Мамин-Сибиряк Дмитрий");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestHappyPath3() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Орудж бей Байат");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestHappyPath4() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Привет");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathName1() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=name] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathName2() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Peter Petrov");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=name] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathName3() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("11111");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=name] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }


    @Test
    public void shouldTestUnhappyPathName4() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("IvanIvanov2");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=name] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathName5() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("1!л -");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=name] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathPhone1() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Павел Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("79333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=phone] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathPhone2() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Павел Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("793333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=phone] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathPhone3() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Павел Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+793333333333");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=phone] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathPhone4() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Павел Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("79333333333+");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=phone] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathPhone5() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Павел Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=phone] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathPhone6() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Павел Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+7933-333-33-33");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=phone] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathPhone7() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Павел Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("Плюс семь");
        driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector(".input_invalid[data-test-id=phone] span.input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestUnhappyPathCheckbox() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Павел Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
        //driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй";
        String actual = driver.findElement(By.cssSelector("label[data-test-id=agreement].input_invalid")).getText().trim();
        assertEquals(expected, actual);
    }
}
