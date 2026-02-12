package com.gradescope.datastructures;

public class Canoe extends WaterVehicle {
    // Canoe has color
    private String color;

    public Canoe(double price, int hp, double miles, double weight, String color) {
        super(price, hp, miles, weight);
        this.color = color;
    }

    // Canoe specific HP rule
    @Override
    public void setHorsepower(int hp) {
        if (hp != 2 && hp != 4) {
            throw new IllegalArgumentException("Canoe HP must be 2 or 4");
        }
        setInternalHorsepower(hp);
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("Canoe: Price: $%.2f, Horsepower: %d, Mileage: %.1f, Weight: %.1f lbs, Color: %s",
                getPrice(), getHorsepower(), getMileage(), getWeight(), color);
    }
}