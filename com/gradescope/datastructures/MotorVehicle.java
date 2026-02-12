package com.gradescope.datastructures;

/*
 * I left this default
 * because I intend for it to be package private
 * as it is a helper class
 */
abstract class MotorVehicle extends Vehicle {
    // 0-60mph time and color attributes are unique to motorized vehicles
    private double zeroToSixty;
    private String color;

    public MotorVehicle(double price, int hp, double miles, double zeroToSixty, String color) {
        // Call to base class constructor
        super(price, hp, miles);
        // zeroToSixty needs validation
        setZeroToSixty(zeroToSixty);
        // Color is unrestricted
        this.color = color;
    }

    // Gets zeroToSixty
    public double getZeroToSixty() {
        return zeroToSixty;
    }

    // Validates if zeroToSixty is between 1-10 sec
    public void setZeroToSixty(double time) {
        if (time < 1 || time > 10) {
            throw new IllegalArgumentException("ZeroToSixty must be between 1 and 10 seconds");
        }
        this.zeroToSixty = time;
    }
    
    // Getter for color
    public String getColor() {
        return color;
    }

    // Setter for color
    public void setColor(String color) {
        this.color = color;
    }
}