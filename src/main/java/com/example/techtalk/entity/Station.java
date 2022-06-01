package com.example.techtalk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {

    @Id @GeneratedValue
    @Column(name = "station_id")
    private Long id;

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public Station() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
