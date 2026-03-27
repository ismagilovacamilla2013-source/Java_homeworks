package com.example.lesson_6;

import java.util.*;
public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (phoneBook.containsKey(lastName)) {
            List<String> phones = phoneBook.get(lastName);
            phones.add(phoneNumber);
            System.out.println("Добавлен телефон: " + phoneNumber + " для " + lastName);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            phoneBook.put(lastName, phones);
            System.out.println("Добавлена запись: " + lastName + " - " + phoneNumber);
        }
    }

    public void get(String lastName) {
        if (phoneBook.containsKey(lastName)) {
            List<String> phones = phoneBook.get(lastName);
            System.out.println("Телефоны для " + lastName + ":");
            for (String phone : phones) {
                System.out.println("  " + phone);
            }
        } else {
                System.out.println("Фамилия " + lastName + " не найдено");
        }
    }

    public void printAll() {
        if (phoneBook.isEmpty()) {
            System.out.println("Справочник пуст");
        } else {
            for (String lastName : phoneBook.keySet()) {
                List<String> phones = phoneBook.get(lastName);
                System.out.println(lastName + ": " + phones);
            }
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7-911-123-45-67");
        phoneBook.add("Петров", "+7-922-234-56-78");
        phoneBook.add("Сидорова", "+7-933-345-67-89");
        phoneBook.add("Иванов", "+7-944-456-78-90");
        phoneBook.add("Иванов", "+7-955-567-89-01");
        phoneBook.add("Кузнецов", "+7-966-678-90-12");

        phoneBook.printAll();
        System.out.println(" ПОИСК ТЕЛЕФОНОВ ");
        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Смирнов");
    }
}
