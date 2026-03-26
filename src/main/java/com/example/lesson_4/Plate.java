package com.example.lesson_4;

public class Plate {
    private int foodAmount;

    public Plate(int foodAmount) {
        this.foodAmount = Math.max(foodAmount, 0);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + foodAmount);
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды!");
        }
    }
    public boolean decreaseFood(int amount) {
        if (amount > 0 && amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }
    public int getFoodAmount() {
        return foodAmount;
    }
    @Override
    public String toString() {
        return foodAmount + " еды";
    }
}