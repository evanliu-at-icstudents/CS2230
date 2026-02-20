package com.gradescope.datastructures;

/**
 * Represents a Motorcycle vehicle.
 * <p>
 * A Motorcycle is a concrete subclass of {@link Vehicle} with
 * a specific horsepower constraint and an optional sidecar feature.
 * </p>
 */
public class Motorcycle extends Vehicle {

    /** Indicates whether the motorcycle has a sidecar attached. */
    private boolean sidecar;

    /**
     * Constructs a Motorcycle with the specified attributes.
     *
     * @param price the price of the motorcycle (validated in {@link Vehicle})
     * @param hp the horsepower (must be either 50 or 75)
     * @param miles the mileage of the motorcycle (validated in {@link Vehicle})
     * @param sidecar whether the motorcycle has a sidecar
     * @throws IllegalArgumentException if horsepower is invalid
     */
    public Motorcycle(double price, int hp, double miles, boolean sidecar) {
        super(price, hp, miles);
        this.sidecar = sidecar;
    }

    /**
     * Sets the horsepower for the motorcycle.
     * <p>
     * Valid horsepower values are 50 or 75 only.
     * </p>
     *
     * @param hp the horsepower to set
     * @throws IllegalArgumentException if hp is not 50 or 75
     */
    @Override
    public void setHorsepower(int hp) {
        if (hp != 50 && hp != 75) {
            throw new IllegalArgumentException("Invalid Motorcycle HP");
        }
        setInternalHorsepower(hp);
    }

    /**
     * Returns whether this motorcycle has a sidecar.
     *
     * @return {@code true} if the motorcycle has a sidecar,
     *         {@code false} otherwise
     */
    public boolean hasSidecar() {
        return sidecar;
    }

    /**
     * Sets whether this motorcycle has a sidecar.
     *
     * @param sidecar {@code true} to attach a sidecar,
     *                {@code false} otherwise
     */
    public void setSidecar(boolean sidecar) {
        this.sidecar = sidecar;
    }

    /**
     * Returns a formatted string representation of this Motorcycle.
     *
     * @return a string describing the motorcycle's price, horsepower,
     *         mileage, and sidecar status
     */
    @Override
    public String toString() {
        return String.format(
                "Motorcycle: Price: $%.2f, Horsepower: %d, Mileage: %.1f miles, Sidecar: %b",
                getPrice(), getHorsepower(), getMileage(), sidecar);
    }
}