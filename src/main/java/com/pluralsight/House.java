package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class House extends Asset{
    // Properties
    private String address;
    private int condition; // (1 = excellent | 2 = good | 3 = fair | 4 = poor)
    private int squareFoot;
    private int lotSize;

    // Constructor
    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    // Methods
    @Override
    public BigDecimal getValue() {
        // The price per sq ft
        BigDecimal rate = new BigDecimal("0");
        switch (condition) {
            // Excellent condition, 180 per sq ft
            case 1 -> rate = new BigDecimal("180");
            // Good condition, 130 per sq ft
            case 2 -> rate = new BigDecimal("130");
            // Fair condition, 90 per sq ft
            case 3 -> rate = new BigDecimal("90");
            // Poor condition, 80 per sq ft
            case 4 -> rate = new BigDecimal("80");
        }
        // Multiply the rate per sq ft, by the ACTUAL sq ft given
        BigDecimal houseValue = rate.multiply(BigDecimal.valueOf(squareFoot));
        // Calculate lot value (0.25 * lotSize)
        BigDecimal lotValue = new BigDecimal("0.25").multiply(BigDecimal.valueOf(lotSize));
        // Add them together to get the total house value
        return houseValue.add(lotValue).setScale(2, RoundingMode.HALF_UP);
    }

    // Getters & setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
