package com.example.lesson_9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class ContinueButtonTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("https://www.mts.by");

        try {
            Thread.sleep(2000);
            WebElement cookieButton = driver.findElement(By.xpath("//button[contains(text(),'Принять')]"));
            cookieButton.click();
            System.out.println(" Окно cookies закрыто");
        } catch (Exception e) {
            System.out.println("Окно cookies не найдено");
        }
    }

    @AfterEach
    public void tearDown() {
            driver.quit();
    }

    @Test
    public void testContinueButton() throws InterruptedException {

        driver.findElement(By.xpath("//*[contains(text(),'Услуги связи')]")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[contains(@placeholder, 'Номер')]")).sendKeys("297777777");
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[contains(@placeholder, 'Сумма')]")).sendKeys("10");
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[contains(@placeholder, 'E-mail')]")).sendKeys("test@example.com");
        Thread.sleep(500);


        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
        System.out.println("Кнопка нажата");

        Thread.sleep(5000);

        String pageText = driver.getPageSource();
        assertTrue(pageText.contains("Оплата"), "Форма оплаты не открылась!");

    }
}
