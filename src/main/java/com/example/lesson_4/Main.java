package com.example.lesson_4;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Щарик");
        Dog dog2 = new Dog("Рэкс");
        Cat cat1 = new Cat("Локи", 10);
        Cat cat2 = new Cat("Мурка", 15);
        dog1.run(600);
        dog2.run(300);
        dog1.swim(5);
        dog1.swim(15);
        cat1.run(100);
        cat2.run(250);
        cat1.swim(5);
        cat2.swim(10);
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Из них собак: " + Dog.getDogCount());
        System.out.println("Из них котов: " + Cat.getCatCount());
        Plate plate = new Plate(25);
        System.out.println("В миске: " + plate);
        Cat[] cats = {
                new Cat("Васька", 10),
                new Cat("Персик", 15),
                new Cat("Снежок", 8),
                new Cat("Барсик", 12),
                new Cat("Том", 5)
        };
        System.out.println();
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " - " + cat.isFull() + " аппетит: " + getFull(cat));
        }
        for (int i = 0; i < cats.length; i++) {
            System.out.print(i + 1);
            cats[i].eat(plate);
        }
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " - " + cat.isFull());
        }
        System.out.println("После кормления: " + plate);
        System.out.println("Добавляем еду в миску:");
        plate.addFood(20);
        System.out.println("После добавления: " + plate);
        System.out.println("Кормим котов:");
        int hungryCats = 0;
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                hungryCats++;
                cat.eat(plate);
            }
        }
        if (hungryCats == 0) {
            System.out.println("Все коты уже сыты!");
        }
        System.out.println(plate);
        System.out.println("Состояние котов:");
        for (Cat cat : cats) {
            System.out.println("  " + cat.getName() + " - " + cat.isFull());
        }
    }
    private static int getFull(Cat cat){
        return cat.getFull();
    }
}
