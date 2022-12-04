package ru.netology;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

        @AfterEach
        void tearDown () {
            driver.quit();
            driver = null;
        }

        @Test
        public void shouldTestHappyPath1 () {
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
        public void shouldTestHappyPath2 () {
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
        public void shouldTestHappyPath3 () {
            driver.get("http://localhost:9999");
            driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Орудж бей Байат");
            driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79333333333");
            driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
            driver.findElement(By.className("button")).click();
            String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
            String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
            assertEquals(expected, actual);
        }
    }
