package com.gradescope.datastructures;

/**
 * Represents a Canoe vehicle.
 * <p>
 * A Canoe is a type of {@link WaterVehicle} with specific horsepower
 * rules and a color attribute.
 * </p>
 */
public class Canoe extends WaterVehicle {

    /** The color of the canoe. */
    private String color;

    /**
     * Constructs a Canoe with the specified attributes.
     *
     * @param price the canoe price (validated in {@link Vehicle})
     * @param hp the horsepower (must be 2 or 4)
     * @param miles the canoe mileage (validated in {@link Vehicle})
     * @param weight the canoe weight (validated in {@link WaterVehicle})
     * @param color the canoe color
     * @throws IllegalArgumentException if horsepower is invalid
     */
    public Canoe(double price, int hp, double miles, double weight, String color) {
        super(price, hp, miles, weight);
        this.color = color;
    }

    /**
     * Sets the horsepower for the canoe.
     *
     * @param hp horsepower value (must be 2 or 4)
     * @throws IllegalArgumentException if hp is invalid
     */
    @Override
    public void setHorsepower(int hp) {
        if (hp != 2 && hp != 4) {
            throw new IllegalArgumentException("Canoe HP must be 2 or 4");
        }
        setInternalHorsepower(hp);
    }

    /**
     * Returns the canoe color.
     *
     * @return canoe color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the canoe color.
     *
     * @param color the color to set (must not be null or blank)
     * @throws IllegalArgumentException if color is null or blank
     */
    public void setColor(String color) {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        this.color = color;
    }

    /**
     * Returns a formatted string representation of this Canoe.
     *
     * @return string describing the canoe's attributes
     */
    @Override
    public String toString() {
        return String.format(
                "Canoe: Price: $%.2f, Horsepower: %d, Mileage: %.1f, Weight: %.1f lbs, Color: %s",
                getPrice(), getHorsepower(), getMileage(), getWeight(), color);
    }
}