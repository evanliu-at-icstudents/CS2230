package com.gradescope.datastructures;

/**
 * Abstract base class representing a generic Vehicle.
 * <p>
 * This class provides common attributes such as price, mileage, and horsepower,
 * along with validation logic. It implements {@link Comparable} to allow vehicles
 * to be sorted primarily by price and secondarily by mileage.
 * </p>
 * 
 * <p>
 * This class cannot be instantiated directly. Subclasses must implement
 * their own horsepower validation rules.
 * </p>
 */
public abstract class Vehicle implements Comparable<Vehicle> {

    /** The price of the vehicle in USD. */
    private double price;

    /** The mileage of the vehicle in miles. */
    private double mileage;

    /** The horsepower of the vehicle. */
    private int horsepower;

    /**
     * Constructs a Vehicle with the specified price, horsepower, and mileage.
     * Validation is performed through setter methods.
     *
     * @param price the price of the vehicle (must be between 5000 and 50000 inclusive)
     * @param horsepower the horsepower value (validated by subclass implementation)
     * @param mileage the mileage of the vehicle (must be non-negative)
     * @throws IllegalArgumentException if price or mileage are outside valid range
     */
    public Vehicle(double price, int horsepower, double mileage) {
        setPrice(price);
        setHorsepower(horsepower);
        setMileage(mileage);
    }

    /**
     * Returns the price of the vehicle.
     *
     * @return the vehicle price in USD
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the vehicle after validating the value.
     *
     * @param price the price to set (must be between 5000 and 50000 inclusive)
     * @throws IllegalArgumentException if price is outside the allowed range
     */
    public void setPrice(double price) {
        if (price < 5000 || price > 50000) {
            throw new IllegalArgumentException("Price must be between $5,000 and $50,000");
        }
        this.price = price;
    }

    /**
     * Returns the mileage of the vehicle.
     *
     * @return the mileage in miles
     */
    public double getMileage() {
        return mileage;
    }

    /**
     * Sets the mileage of the vehicle after validating the value.
     *
     * @param mileage the mileage to set (must be non-negative)
     * @throws IllegalArgumentException if mileage is negative
     */
    public void setMileage(double mileage) {
        if (mileage < 0) {
            throw new IllegalArgumentException("Mileage cannot be negative");
        }
        this.mileage = mileage;
    }

    /**
     * Returns the horsepower of the vehicle.
     *
     * @return the horsepower value
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Sets the internal horsepower field after validation.
     * <p>
     * Intended for use by subclasses once their specific validation
     * logic has been applied.
     * </p>
     *
     * @param hp the validated horsepower value
     */
    protected void setInternalHorsepower(int hp) {
        this.horsepower = hp;
    }

    /**
     * Sets the horsepower of the vehicle.
     * <p>
     * Subclasses must implement their own validation rules
     * before calling {@link #setInternalHorsepower(int)}.
     * </p>
     *
     * @param horsepower the horsepower value to set
     * @throws IllegalArgumentException if subclass validation fails
     */
    public abstract void setHorsepower(int horsepower);

    /**
     * Compares this vehicle with another vehicle for ordering.
     * <p>
     * Vehicles are sorted:
     * <ul>
     *   <li>Primarily by price (ascending)</li>
     *   <li>Secondarily by mileage (ascending)</li>
     * </ul>
     * </p>
     *
     * @param other the vehicle to compare against
     * @return a negative integer, zero, or a positive integer as this vehicle
     *         is less than, equal to, or greater than the specified vehicle
     */
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