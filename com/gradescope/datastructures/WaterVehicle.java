package com.gradescope.datastructures;

/*
 * Helper abstract class for watercraft
 * to handle shared weight attribute
 */
abstract class WaterVehicle extends Vehicle {
    private double weight;

    public WaterVehicle(double price, int hp, double miles, double weight) {
        // Call to base class
        super(price, hp, miles);
        // Weight validation
        setWeight(weight);
    }

    // Gets weight
    public double getWeight() {
        return weight;
    }

    // Validates weight is positive
    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        this.weight = weight;
    }
}