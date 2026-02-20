package com.gradescope.datastructures;

import java.util.Random;
import java.util.Arrays;

/**
 * Driver class used to run the vehicle inventory application.
 * <p>
 * This class generates a randomized inventory of different {@link Vehicle}
 * types, sorts them using their natural ordering (price first, then mileage),
 * and prints the sorted results.
 * </p>
 */
public class Driver {

    /**
     * Entry point of the application.
     * <p>
     * The program:
     * <ol>
     *     <li>Creates an array of 20 {@link Vehicle} objects.</li>
     *     <li>Randomly generates different vehicle types.</li>
     *     <li>Sorts them using {@link Comparable} implementation.</li>
     *     <li>Prints the sorted inventory.</li>
     * </ol>
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        /** Array storing the vehicle inventory. */
        Vehicle[] inventory = new Vehicle[20];

        /** Random number generator for vehicle attributes. */
        Random rand = new Random();

        /** Available color options for applicable vehicles. */
        String[] colors = {"Red", "Blue", "Black", "White"};

        // Populate inventory with random vehicles
        for (int i = 0; i < 20; i++) {

            // Randomly determine vehicle type (0–4)
            int type = rand.nextInt(5);

            // Generate random price within valid Vehicle range
            double price = 5000 + (rand.nextDouble() * 45000);

            // Generate random mileage (0–10000)
            double miles = rand.nextDouble() * 10000;

            try {
                if (type == 0) {
                    inventory[i] = new Sedan(
                            price,
                            200,
                            miles,
                            5.5,
                            5,
                            colors[rand.nextInt(4)]
                    );
                } else if (type == 1) {
                    inventory[i] = new Coupe(
                            price,
                            400,
                            miles,
                            4.2,
                            colors[rand.nextInt(4)],
                            rand.nextBoolean()
                    );
                } else if (type == 2) {
                    inventory[i] = new Motorcycle(
                            price,
                            75,
                            miles,
                            rand.nextBoolean()
                    );
                } else if (type == 3) {
                    inventory[i] = new Boat(
                            price,
                            miles,
                            2500,
                            "Yamaha"
                    );
                } else {
                    inventory[i] = new Canoe(
                            price,
                            2,
                            miles,
                            100,
                            colors[rand.nextInt(4)]
                    );
                }
            } catch (Exception e) {
                // Retry this index if randomly generated values fail validation
                i--;
            }
        }

        /**
         * Sort inventory using natural ordering defined in {@link Vehicle#compareTo(Vehicle)}.
         * Primary sort: price.
         * Secondary sort: mileage.
         */
        Arrays.sort(inventory);

        /**
         * Print the sorted inventory.
         */
        for (Vehicle v : inventory) {
            System.out.println(v.toString());
        }
    }
}