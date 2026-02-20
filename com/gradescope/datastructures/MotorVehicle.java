package com.gradescope.datastructures;

/**
 * Abstract helper class representing a motorized vehicle.
 * <p>
 * This class extends {@link Vehicle} and adds attributes specific
 * to motorized vehicles, including 0–60 mph acceleration time
 * and color.
 * </p>
 *
 * <p>
 * This class has package-private visibility because it is intended
 * to be used only as a helper superclass within the package.
 * </p>
 */
abstract class MotorVehicle extends Vehicle {

    /** The time (in seconds) it takes the vehicle to accelerate from 0 to 60 mph. */
    private double zeroToSixty;

    /** The color of the vehicle. */
    private String color;

    /**
     * Constructs a MotorVehicle with the specified attributes.
     *
     * @param price the vehicle price (validated in {@link Vehicle})
     * @param hp the horsepower (validated by subclass implementation)
     * @param miles the vehicle mileage (validated in {@link Vehicle})
     * @param zeroToSixty the 0–60 mph acceleration time in seconds (must be between 1 and 10)
     * @param color the vehicle color (no validation applied)
     * @throws IllegalArgumentException if zeroToSixty is outside the valid range
     */
    public MotorVehicle(double price, int hp, double miles, double zeroToSixty, String color) {
        super(price, hp, miles);
        setZeroToSixty(zeroToSixty);
        this.color = color;
    }

    /**
     * Returns the 0–60 mph acceleration time.
     *
     * @return acceleration time in seconds
     */
    public double getZeroToSixty() {
        return zeroToSixty;
    }

    /**
     * Sets the 0–60 mph acceleration time after validation.
     *
     * @param time acceleration time in seconds (must be between 1 and 10 inclusive)
     * @throws IllegalArgumentException if time is outside the allowed range
     */
    public void setZeroToSixty(double time) {
        if (time < 1 || time > 10) {
            throw new IllegalArgumentException("ZeroToSixty must be between 1 and 10 seconds");
        }
        this.zeroToSixty = time;
    }
    
    /**
     * Returns the color of the vehicle.
     *
     * @return the vehicle color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the vehicle.
     * <p>
     * No validation is performed.
     * </p>
     *
     * @param color the new color
     */
    public void setColor(String color) {
        this.color = color;
    }
}