package com.gradescope.datastructures;

public class Boat extends WaterVehicle {
    // Company name for boat
    private String companyName;

    public Boat(double price, double miles, double weight, String companyName) {
        // Boats are always 300 HP
        super(price, 300, miles, weight);
        this.companyName = companyName;
    }

    // Force boat HP to 300
    @Override
    public void setHorsepower(int hp) {
        if (hp != 300) {
            throw new IllegalArgumentException("Boat HP must be 300");
        }
        setInternalHorsepower(300);
    }

    // Getter for company
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return String.format("Boat: Price: $%.2f, Horsepower: %d, Mileage: %.1f, Weight: %.1f lbs, Company: %s",
                getPrice(), getHorsepower(), getMileage(), getWeight(), companyName);
    }
}