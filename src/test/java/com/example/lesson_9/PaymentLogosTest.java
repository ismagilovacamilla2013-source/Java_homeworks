package com.example.lesson_9;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentLogosTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPaymentLogos() {
        List<WebElement> visa = driver.findElements(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img")
        );
        assertTrue(visa.size() > 0, "Visa не найден");
        System.out.println(" Visa найден");

        List<WebElement> verifiedByVisa = driver.findElements(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul")
        );
        assertTrue(verifiedByVisa.size() > 0, "Visa не найден");
        System.out.println("Verified by Visa найден");

        List<WebElement> mastercard = driver.findElements(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img")
        );
        assertTrue(mastercard.size() > 0, "Mastercard не найден");
        System.out.println(" Mastercard найден");

        List<WebElement> secureCode = driver.findElements(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img")
        );
        assertTrue(secureCode.size() > 0, "Mastercard SecureCode не найден");
        System.out.println(" Mastercard SecureCode найден");

        List<WebElement> belcard = driver.findElements(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img")
        );
        assertTrue(belcard.size() > 0, "Белкарт не найден");
        System.out.println(" Белкарт найден");

        System.out.println(" Все логотипы присутствуют");
    }
}
