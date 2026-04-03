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

public class MoreDetailsLinkTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.mts.by");

        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]")
            ));
            cookieButton.click();
            System.out.println(" Окно cookies закрыто");
        } catch (Exception e) {
            System.out.println("Окно cookies не появилось или уже закрыто");
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testMoreDetailsLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Подробнее') and contains(text(),'сервисе')]")
        ));
        String currentUrl = driver.getCurrentUrl();
        link.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
        String newUrl = driver.getCurrentUrl();
        assertNotEquals(currentUrl, newUrl, "Ссылка не работает!");

    }
}
