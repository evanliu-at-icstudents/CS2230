package com.gradescope.datastructures;

public class Sedan extends MotorVehicle {
    // Seating capacity is unique to Sedans
    private int seatingCapacity;

    public Sedan(double price, int hp, double miles, double zts, int seats, String color) {
        super(price, hp, miles, zts, color);
        setSeatingCapacity(seats);
    }

    // Sedan specific HP rule
    @Override
    public void setHorsepower(int hp) {
        if (hp != 200 && hp != 400 && hp != 600) {
            throw new IllegalArgumentException("Invalid Sedan HP");
        }
        setInternalHorsepower(hp);
    }

    // Sedan must have 1-8 seats
    public void setSeatingCapacity(int seats) {
        if (seats < 1 || seats > 8) {
            throw new IllegalArgumentException("Invalid seats");
        }
        this.seatingCapacity = seats;
    }

    // Getter for capacity
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    // Learned something new here, I didn't know how the java String.format() used varargs for variable arguments.
    // Analyzing the source code was interesting
    @Override
    public String toString() {
        return String.format("Sedan: Price: $%.2f, Horsepower: %d, Mileage: %.1f miles, ZeroToSixty: %.2f sec, Seating Capacity: %d, Color: %s",
                getPrice(), getHorsepower(), getMileage(), getZeroToSixty(), seatingCapacity, getColor());
    }
}