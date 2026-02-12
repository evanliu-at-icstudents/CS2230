package com.gradescope.datastructures;

public class Coupe extends MotorVehicle {
    // Boolean for convertible status
    private boolean convertible;

    public Coupe(double price, int hp, double miles, double zts, String color, boolean convertible) {
        super(price, hp, miles, zts, color);
        this.convertible = convertible;
    }

    // Coupe specific HP rule
    @Override
    public void setHorsepower(int hp) {
        if (hp != 200 && hp != 400 && hp != 600) {
            throw new IllegalArgumentException("Invalid Coupe HP");
        }
        setInternalHorsepower(hp);
    }

    // Getter for boolean
    public boolean isConvertible() {
        return convertible;
    }

    @Override
    public String toString() {
        return String.format("Coupe: Price: $%.2f, Horsepower: %d, Mileage: %.1f miles, ZeroToSixty: %.2f sec, Color: %s, Convertible: %b",
                getPrice(), getHorsepower(), getMileage(), getZeroToSixty(), getColor(), convertible);
    }
}