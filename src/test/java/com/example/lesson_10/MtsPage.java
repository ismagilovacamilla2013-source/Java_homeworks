package com.example.lesson_10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By acceptCookiesButton = By.xpath("//button[contains(text(), 'Принять')]");
    private final By dropdownHeader = By.xpath("//button[contains(@class, 'select__header')]");
    private final By dropdownList = By.xpath("//ul[contains(@class, 'select__list')]");
    private final By connectionOption = By.xpath("//p[@class='select__option' and contains(text(), 'Услуги связи')]");
    private final By homeInternetOption = By.xpath("//p[@class='select__option' and contains(text(), 'Домашний интернет')]");
    private final By installmentOption = By.xpath("//p[@class='select__option' and contains(text(), 'Рассрочка')]");
    private final By debtOption = By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]");
    private final By phoneField = By.id("connection-phone");
    private final By amountField = By.id("connection-sum");
    private final By emailField = By.id("connection-email");
    private final By homeInternetPhoneField = By.id("internet-phone");
    private final By homeInternetAmountField = By.id("internet-sum");
    private final By homeInternetEmailField = By.id("internet-email");
    private final By installmentAccountField = By.id("score-instalment");
    private final By installmentAmountField = By.id("instalment-sum");
    private final By installmentEmailField = By.id("instalment-email");
    private final By debtAccountField = By.id("score-arrears");
    private final By debtAmountField = By.id("arrears-sum");
    private final By debtEmailField = By.id("arrears-email");
    private final By continueButton = By.xpath("//button[contains(@class, 'button__default') and contains(text(), 'Продолжить')]");

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        driver.get("https://www.mts.by/");
        acceptCookies();
    }

    private void acceptCookies() {
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptBtn.click();
        } catch (Exception e) {
            System.out.println("Cookie уже приняты");
        }
    }

    private void selectService(By optionLocator, By expectedFieldLocator) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownHeader));
        dropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownList));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        option.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectedFieldLocator));
    }

    public MtsPage selectConnectionService() {
        selectService(connectionOption, phoneField);
        return this;
    }

    public MtsPage selectHomeInternetService() {
        selectService(homeInternetOption, homeInternetPhoneField);
        return this;
    }

    public MtsPage selectInstallmentService() {
        selectService(installmentOption, installmentAccountField);
        return this;
    }

    public MtsPage selectDebtService() {
        selectService(debtOption, debtAccountField);
        return this;
    }

    public MtsPage enterPhone(String phone) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
        element.clear();
        element.sendKeys(phone);
        element.sendKeys(Keys.TAB);
        return this;
    }

    public MtsPage enterAmount(String amount) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        element.clear();
        element.sendKeys(amount);
        return this;
    }

    public MtsPage enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        element.clear();
        element.sendKeys(email);
        return this;
    }

    public String getPhonePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountField)).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).getAttribute("placeholder");
    }

    public String getHomeInternetPhonePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeInternetPhoneField)).getAttribute("placeholder");
    }

    public String getHomeInternetAmountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeInternetAmountField)).getAttribute("placeholder");
    }

    public String getHomeInternetEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homeInternetEmailField)).getAttribute("placeholder");
    }

    public String getInstallmentAccountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentAccountField)).getAttribute("placeholder");
    }

    public String getInstallmentAmountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentAmountField)).getAttribute("placeholder");
    }

    public String getInstallmentEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentEmailField)).getAttribute("placeholder");
    }

    public String getDebtAccountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(debtAccountField)).getAttribute("placeholder");
    }

    public String getDebtAmountPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(debtAmountField)).getAttribute("placeholder");
    }

    public String getDebtEmailPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(debtEmailField)).getAttribute("placeholder");
    }

    public PaymentModal clickContinue() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        button.click();

        By iframeLocator = By.xpath("//iframe[contains(@class, 'payment-widget-iframe')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));

        return new PaymentModal(driver);
    }
}