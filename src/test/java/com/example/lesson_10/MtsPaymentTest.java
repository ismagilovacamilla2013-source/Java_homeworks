package com.example.lesson_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPaymentTest extends BaseTest {

    @Test
    public void testPlaceholdersForConnectionService() {
        mtsPage.selectConnectionService();

        assertEquals("Номер телефона", mtsPage.getPhonePlaceholder());
        assertEquals("Сумма", mtsPage.getAmountPlaceholder());
        assertEquals("E-mail для отправки чека", mtsPage.getEmailPlaceholder());
    }

    @Test
    public void testPlaceholdersForHomeInternet() {
        mtsPage.selectHomeInternetService();

        assertEquals("Номер абонента", mtsPage.getHomeInternetPhonePlaceholder());
        assertEquals("Сумма", mtsPage.getHomeInternetAmountPlaceholder());
        assertEquals("E-mail для отправки чека", mtsPage.getHomeInternetEmailPlaceholder());
    }

    @Test
    public void testPlaceholdersForInstallment() {
        mtsPage.selectInstallmentService();

        assertEquals("Номер счета на 44", mtsPage.getInstallmentAccountPlaceholder());
        assertEquals("Сумма", mtsPage.getInstallmentAmountPlaceholder());
        assertEquals("E-mail для отправки чека", mtsPage.getInstallmentEmailPlaceholder());
    }

    @Test
    public void testPlaceholdersForDebt() {
        mtsPage.selectDebtService();

        assertEquals("Номер счета на 2073", mtsPage.getDebtAccountPlaceholder());
        assertEquals("Сумма", mtsPage.getDebtAmountPlaceholder());
        assertEquals("E-mail для отправки чека", mtsPage.getDebtEmailPlaceholder());
    }

    @Test
    public void testPaymentForCommunicationService() {
        String testPhone = "297777777";
        String testAmount = "10";
        String testEmail = "test@example.com";

        PaymentModal modal = mtsPage
                .selectConnectionService()
                .enterPhone(testPhone)
                .enterAmount(testAmount)
                .enterEmail(testEmail)
                .clickContinue();

        String buttonText = modal.getAmountOnButton();
        assertTrue(buttonText.contains(testAmount));
        assertTrue(buttonText.contains("BYN"));

        assertTrue(modal.getPhoneDisplayed().contains("375" + testPhone));

        assertEquals("Номер карты", modal.getCardNumberPlaceholder());
        assertEquals("CVC", modal.getCvcPlaceholder());
        assertEquals("Имя и фамилия на карте", modal.getCardholderPlaceholder());

        assertTrue(modal.isVisaIconDisplayed());
    }
}