package com.example.lesson_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentModal {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By paymentFrame = By.xpath("//iframe[contains(@class, 'payment-widget-iframe')]");
    private final By payButton = By.xpath("//button[contains(@class, 'colored')]");
    private final By phoneDisplay = By.xpath("//div[contains(@class, 'pay-description__text')]/span");
    private final By cardNumberLabel = By.xpath("//input[@formcontrolname='creditCard']/following-sibling::label");
    private final By cvcLabel = By.xpath("//input[@formcontrolname='cvc']/following-sibling::label");
    private final By cardholderLabel = By.xpath("//input[@formcontrolname='holder']/following-sibling::label");
    private final By visaIcon = By.xpath("//img[contains(@src, 'visa-system')]");

    public PaymentModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        switchToPaymentFrame();
    }

    private void switchToPaymentFrame() {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFrame));
        driver.switchTo().frame(frame);
    }

    public String getAmountOnButton() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(payButton));
        return button.getText();
    }

    public String getPhoneDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneDisplay));
        return element.getText();
    }

    public String getCardNumberPlaceholder() {
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel));
        return label.getText();
    }

    public String getCvcPlaceholder() {
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLabel));
        return label.getText();
    }

    public String getCardholderPlaceholder() {
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(cardholderLabel));
        return label.getText();
    }

    public boolean isVisaIconDisplayed() {
        return driver.findElements(visaIcon).size() > 0;
    }
}