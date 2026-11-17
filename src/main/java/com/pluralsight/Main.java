package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create list of asset objects
        ArrayList<Asset> assets = new ArrayList<>();

        // Create 2 houses
        House house1 = new House(
                "Main Home","2008-03-15", new BigDecimal("80000"),
                "100 Oak Street",3,1500,2000
        );
        House house2 = new House(
                "Vacation Home","2020-03-15", new BigDecimal("250000"),
                "50 Elm street",1,3500,10000
        );

        // Add them to assets
        assets.add(house1);
        assets.add(house2);

        // Create 2 cars
        Vehicle car1 = new Vehicle("Father's car","2025",new BigDecimal("35000"),
                "Tesla Model 3",2025,35000);
        Vehicle car2 = new Vehicle("Sons car","2019",new BigDecimal("6000"),
                "Toyota Corolla",2010,95000);

        // Add them to assets
        assets.add(car1);
        assets.add(car2);

        // Loop through assets and display makeModel and house address
        for (Asset asset : assets) {
            if (asset instanceof House) {
                System.out.println(
                        "House (" + asset.getDescription() + ")" +
                                "\nAcquired date: " + asset.getDateAcquired() +
                                "\nPaid: " + asset.getOriginalCost() +
                                "\nAddress: " + ((House) asset).getAddress() +
                                "\nCurrent value: " + asset.getValue()
                );
            } else if (asset instanceof Vehicle) {
                System.out.println(
                        "Vehicle (" + asset.getDescription() + ")" +
                                "\nAcquired date: " + asset.getDateAcquired() +
                                "\nPaid: " + asset.getOriginalCost() +
                                "\nMake / Model: " + ((Vehicle) asset).getMakeModel() +
                                "\nYear: " + ((Vehicle) asset).getYear() +
                                "\nCurrent value: " + asset.getValue()
                );
            }
            System.out.println();
        }
    }
}