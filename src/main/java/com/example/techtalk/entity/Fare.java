package com.example.techtalk.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Fare {
    private int extraFare;
    private int distanceUnitFare;

    public Fare(int extraFare, int distanceUnitFare) {
        this.extraFare = extraFare * distanceUnitFare;
        this.distanceUnitFare = distanceUnitFare;
    }

    public Fare() {

    }

    public int getExtraFare() {
        return extraFare;
    }

    public int getDistanceUnitFare() {
        return distanceUnitFare;
    }
}
