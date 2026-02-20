package com.gradescope.datastructures;

/**
 * Represents a Sedan vehicle.
 * <p>
 * A Sedan is a type of {@link MotorVehicle} that includes
 * a seating capacity attribute and specific horsepower constraints.
 * </p>
 */
public class Sedan extends MotorVehicle {

    /** The number of seats available in the sedan. */
    private int seatingCapacity;

    /**
     * Constructs a Sedan with the specified attributes.
     *
     * @param price the vehicle price (validated in {@link Vehicle})
     * @param hp the horsepower (must be 200, 400, or 600)
     * @param miles the vehicle mileage (validated in {@link Vehicle})
     * @param zts the 0–60 mph time in seconds (validated in {@link MotorVehicle})
     * @param seats the seating capacity (must be between 1 and 8 inclusive)
     * @param color the vehicle color
     * @throws IllegalArgumentException if horsepower or seating capacity is invalid
     */
    public Sedan(double price, int hp, double miles, double zts, int seats, String color) {
        super(price, hp, miles, zts, color);
        setSeatingCapacity(seats);
    }

    /**
     * Sets the horsepower for the sedan.
     * <p>
     * Valid horsepower values are 200, 400, or 600.
     * </p>
     *
     * @param hp the horsepower value
     * @throws IllegalArgumentException if hp is invalid
     */
    @Override
    public void setHorsepower(int hp) {
        if (hp != 200 && hp != 400 && hp != 600) {
            throw new IllegalArgumentException("Invalid Sedan HP");
        }
        setInternalHorsepower(hp);
    }

    /**
     * Sets the seating capacity.
     *
     * @param seats number of seats (must be between 1 and 8 inclusive)
     * @throws IllegalArgumentException if seats is outside valid range
     */
    public void setSeatingCapacity(int seats) {
        if (seats < 1 || seats > 8) {
            throw new IllegalArgumentException("Invalid seats");
        }
        this.seatingCapacity = seats;
    }

    /**
     * Returns the seating capacity.
     *
     * @return number of seats
     */
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * Returns a formatted string representation of this Sedan.
     *
     * @return string describing the sedan's attributes
     */
    @Override
    public String toString() {
        return String.format(
                "Sedan: Price: $%.2f, Horsepower: %d, Mileage: %.1f miles, ZeroToSixty: %.2f sec, Seating Capacity: %d, Color: %s",
                getPrice(), getHorsepower(), getMileage(), getZeroToSixty(), seatingCapacity, getColor());
    }
}