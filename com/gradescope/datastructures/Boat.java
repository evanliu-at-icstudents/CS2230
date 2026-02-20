package com.gradescope.datastructures;

/**
 * Represents a Boat vehicle.
 * <p>
 * A Boat is a type of {@link WaterVehicle} with a fixed horsepower
 * of 300 and a company name attribute.
 * </p>
 */
public class Boat extends WaterVehicle {

    /** The manufacturing company of the boat. */
    private String companyName;

    /**
     * Constructs a Boat.
     * <p>
     * Boats always have a horsepower of 300.
     * </p>
     *
     * @param price the boat price (validated in {@link Vehicle})
     * @param miles the boat mileage (validated in {@link Vehicle})
     * @param weight the boat weight (validated in {@link WaterVehicle})
     * @param companyName the company name (must not be null or blank)
     * @throws IllegalArgumentException if companyName is null or blank
     */
    public Boat(double price, double miles, double weight, String companyName) {
        super(price, 300, miles, weight);
        setCompanyName(companyName);
    }

    /**
     * Sets the horsepower for the boat.
     * <p>
     * Boats must always have exactly 300 horsepower.
     * </p>
     *
     * @param hp the horsepower value
     * @throws IllegalArgumentException if hp is not 300
     */
    @Override
    public void setHorsepower(int hp) {
        if (hp != 300) {
            throw new IllegalArgumentException("Boat HP must be 300");
        }
        setInternalHorsepower(300);
    }

    /**
     * Returns the company name.
     *
     * @return manufacturer name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the company name.
     *
     * @param companyName the company name (must not be null or blank)
     * @throws IllegalArgumentException if companyName is null or blank
     */
    public void setCompanyName(String companyName) {
        if (companyName == null || companyName.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be null or blank");
        }
        this.companyName = companyName;
    }

    /**
     * Returns a formatted string representation of this Boat.
     *
     * @return string describing the boat's attributes
     */
    @Override
    public String toString() {
        return String.format(
                "Boat: Price: $%.2f, Horsepower: %d, Mileage: %.1f, Weight: %.1f lbs, Company: %s",
                getPrice(), getHorsepower(), getMileage(), getWeight(), companyName);
    }
}