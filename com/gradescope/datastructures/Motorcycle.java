package com.gradescope.datastructures;

public class Motorcycle extends Vehicle {
    // Sidecar attribute
    private boolean sidecar;

    public Motorcycle(double price, int hp, double miles, boolean sidecar) {
        super(price, hp, miles);
        this.sidecar = sidecar;
    }

    // Motorcycle specific HP rule
    @Override
    public void setHorsepower(int hp) {
        if (hp != 50 && hp != 75) {
            throw new IllegalArgumentException("Invalid Motorcycle HP");
        }
        setInternalHorsepower(hp);
    }

    // Getter for sidecar
    public boolean hasSidecar() {
        return sidecar;
    }

    @Override
    public String toString() {
        return String.format("Motorcycle: Price: $%.2f, Horsepower: %d, Mileage: %.1f miles, Sidecar: %b",
                getPrice(), getHorsepower(), getMileage(), sidecar);
    }
}