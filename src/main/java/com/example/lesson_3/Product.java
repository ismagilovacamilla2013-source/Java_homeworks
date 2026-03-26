package com.example.lesson_3;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean bookingStatus;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, int price, boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Состояние бронирования покупателем: " + bookingStatus);
    }

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 17 Pro", "15.03.2025", "Apple Inc.", "USA", 89999, false);
        productsArray[2] = new Product("MacBook Air M4", "20.01.2026", "Apple Inc.", "China", 129999, true);
        productsArray[3] = new Product("Dell XPS 15", "10.02.2026", "Dell", "США", 159999, true);
        productsArray[4] = new Product("Asus", "05.03.2026", "ASUSTeK Computer Inc.", "China", 45999, false);
        for (int i = 0; i < 5; i++) {
            System.out.println("Товар #" + (i + 1) + ":");
            productsArray[i].printInfo();
        }
    }
}