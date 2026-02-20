package com.gradescope.datastructures;

/**
 * Abstract helper class representing a water-based vehicle.
 * <p>
 * This class extends {@link Vehicle} and adds a shared weight
 * attribute common to watercraft.
 * </p>
 *
 * <p>
 * This class has package-private visibility because it is intended
 * to be used only as a helper superclass within the package.
 * </p>
 */
abstract class WaterVehicle extends Vehicle {

    /** The weight of the water vehicle. */
    private double weight;

    /**
     * Constructs a WaterVehicle with the specified attributes.
     *
     * @param price the vehicle price (validated in {@link Vehicle})
     * @param hp the horsepower (validated by subclass implementation)
     * @param miles the vehicle mileage (validated in {@link Vehicle})
     * @param weight the vehicle weight (must be greater than 0)
     * @throws IllegalArgumentException if weight is less than or equal to 0
     */
    public WaterVehicle(double price, int hp, double miles, double weight) {
        super(price, hp, miles);
        setWeight(weight);
    }

    /**
     * Returns the weight of the vehicle.
     *
     * @return the vehicle weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the vehicle after validation.
     *
     * @param weight the weight to set (must be greater than 0)
     * @throws IllegalArgumentException if weight is less than or equal to 0
     */
    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        this.weight = weight;
    }
}