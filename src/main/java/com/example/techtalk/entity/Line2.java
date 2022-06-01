package com.example.techtalk.entity;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Line2 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Fare fare;

    public Line2(Long id, String name, Fare fare) {
        this.id = id;
        this.name = name;
        this.fare = fare;
    }

    public Line2(String name, Fare fare) {
        this.name = name;
        this.fare = fare;
    }

    public Line2() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Fare getFare() {
        return fare;
    }
}
