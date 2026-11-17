package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.HashMap;
import java.util.List;

public class Vehicle extends Asset {
    // Properties
    private String makeModel;
    private int year;
    private int odometer;

    // Constructor
    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // Methods
    @Override
    public BigDecimal getValue() {
        BigDecimal deductionPercent = new BigDecimal("0");
        BigDecimal cost = getOriginalCost();
        BigDecimal value;

        // Cars age from the current year
        int age = Year.now().getValue() - year;

        if (age <= 3) {
            // 3% off
            deductionPercent = new BigDecimal("0.03");
        } else if (age <= 6) {
            // 6% off
            deductionPercent = new BigDecimal("0.06");
        } else if (age <= 10) {
            // 8% off
            deductionPercent = new BigDecimal("0.08");
        }

        if (age > 10) {
            // Set the cars value to just $1,000
            value = new BigDecimal("1000.00");
        } else {
            // Subtract the deduction from the vehicles value.
            BigDecimal deduction = cost.multiply(deductionPercent);
            value = cost.subtract(deduction);
        }

        // Check if the makeModel is not a Honda or Toyota
        if (!makeModel.contains("Honda") && !makeModel.contains("Toyota")) {
            // If the odometer has more than 100,000 miles it qualifies for a reduced price
            if (odometer > 100000) {
                // Take 25% off the FINAL value, instead of adding 0.25 to the percent
                value = value.multiply(new BigDecimal("0.75"));
            }
        }

        // Return vehicle price rounded to 2 decimal places
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    // Getters & setters
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
