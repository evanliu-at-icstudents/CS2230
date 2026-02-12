package com.gradescope.datastructures;

//Abstract base class to prevent instantiation
public abstract class Vehicle implements Comparable<Vehicle> {
    private double price;
    private double mileage;
    private int horsepower;

    // Data validation
    public Vehicle(double price, int horsepower, double mileage) {
        setPrice(price);
        setHorsepower(horsepower);
        setMileage(mileage);
    }

    // Gets price
    public double getPrice() {
        return price;
    }

    // Check price before setting
    public void setPrice(double price) {
        if (price < 5000 || price > 50000) {
            throw new IllegalArgumentException("Price must be between $5,000 and $50,000");
        }
        this.price = price;
    }

    // Gets mileage
    public double getMileage() {
        return mileage;
    }

    // Check mileage before setting
    public void setMileage(double mileage) {
        if (mileage < 0) {
            throw new IllegalArgumentException("Mileage cannot be negative");
        }
        this.mileage = mileage;
    }

    // Gets Horsepower
    public int getHorsepower() {
        return horsepower;
    }

    // Helper for subclasses to set the shared variable after validation
    protected void setInternalHorsepower(int hp) {
        this.horsepower = hp;
    }

    public abstract void setHorsepower(int horsepower); // Subclasses have specific HP rules

    @Override
    public int compareTo(Vehicle other) {
        // Primary sort: Price
        if (Math.abs(this.price - other.price) > 0.01) {
            return Double.compare(this.price, other.price);
        }

        // Secondary sort: Mileage
        return Double.compare(this.mileage, other.mileage);
    }
}