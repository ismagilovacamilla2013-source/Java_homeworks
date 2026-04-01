package com.example.lesson_9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class BlockTitleTest {
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
            System.out.println("Окно cookies не найдено или уже закрыто");
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]")
        ));
        String actualTitle = title.getText().replace("\n", " ").trim();
        String expectedTitle = "Онлайн пополнение без комиссии";
        assertEquals(expectedTitle, actualTitle, "Название блока не соответствует!");
        System.out.println();
    }
}
