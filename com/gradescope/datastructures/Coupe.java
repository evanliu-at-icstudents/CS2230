package com.gradescope.datastructures;

/**
 * Represents a Coupe vehicle.
 * <p>
 * A Coupe is a type of {@link MotorVehicle} that may optionally
 * be convertible and follows specific horsepower rules.
 * </p>
 */
public class Coupe extends MotorVehicle {

    /** Indicates whether the coupe is convertible. */
    private boolean convertible;

    /**
     * Constructs a Coupe with the specified attributes.
     *
     * @param price the vehicle price (validated in {@link Vehicle})
     * @param hp the horsepower (must be 200, 400, or 600)
     * @param miles the vehicle mileage (validated in {@link Vehicle})
     * @param zts the 0–60 mph time in seconds (validated in {@link MotorVehicle})
     * @param color the vehicle color
     * @param convertible whether the coupe is convertible
     * @throws IllegalArgumentException if horsepower is invalid
     */
    public Coupe(double price, int hp, double miles, double zts, String color, boolean convertible) {
        super(price, hp, miles, zts, color);
        this.convertible = convertible;
    }

    /**
     * Sets the horsepower for the coupe.
     *
     * @param hp horsepower value (must be 200, 400, or 600)
     * @throws IllegalArgumentException if hp is invalid
     */
    @Override
    public void setHorsepower(int hp) {
        if (hp != 200 && hp != 400 && hp != 600) {
            throw new IllegalArgumentException("Invalid Coupe HP");
        }
        setInternalHorsepower(hp);
    }

    /**
     * Returns whether this coupe is convertible.
     *
     * @return true if convertible, false otherwise
     */
    public boolean isConvertible() {
        return convertible;
    }

    /**
     * Sets the convertible status.
     *
     * @param convertible true to make convertible, false otherwise
     */
    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    /**
     * Returns a formatted string representation of this Coupe.
     *
     * @return string describing the coupe's attributes
     */
    @Override
    public String toString() {
        return String.format(
                "Coupe: Price: $%.2f, Horsepower: %d, Mileage: %.1f miles, ZeroToSixty: %.2f sec, Color: %s, Convertible: %b",
                getPrice(), getHorsepower(), getMileage(), getZeroToSixty(), getColor(), convertible);
    }
}