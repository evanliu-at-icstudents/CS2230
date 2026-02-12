package com.gradescope.datastructures;

import java.util.Random;
import java.util.Arrays;

// Main class to run application
public class Driver {
    public static void main(String[] args) {
        Vehicle[] inventory = new Vehicle[20];
        Random rand = new Random();
        String[] colors = {"Red", "Blue", "Black", "White"};

        // Loop to fill 20 slots
        for (int i = 0; i < 20; i++) {
            int type = rand.nextInt(5);
            double price = 5000 + (rand.nextDouble() * 45000);
            double miles = rand.nextDouble() * 10000;

            try {
                if (type == 0) {
                    inventory[i] = new Sedan(price, 200, miles, 5.5, 5, colors[rand.nextInt(4)]);
                } else if (type == 1) {
                    inventory[i] = new Coupe(price, 400, miles, 4.2, colors[rand.nextInt(4)], rand.nextBoolean());
                } else if (type == 2) {
                    inventory[i] = new Motorcycle(price, 75, miles, rand.nextBoolean());
                } else if (type == 3) {
                    inventory[i] = new Boat(price, miles, 2500, "Yamaha");
                } else {
                    inventory[i] = new Canoe(price, 2, miles, 100, colors[rand.nextInt(4)]);
                }
            } catch (Exception e) {
                // If invalid random values, decrement loop to retry index
                i--;
            }
        }

        // Sorts by price then mileage using Comparable
        Arrays.sort(inventory);

        // Prints final inventory
        for (Vehicle v : inventory) {
            System.out.println(v.toString());
        }
    }
}