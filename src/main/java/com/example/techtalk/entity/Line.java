package com.example.techtalk.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Line {
    @Id @GeneratedValue
    @Column(name = "line_id")
    private Long id;

    private String name;

    @OneToMany
    private List<Section> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Section section) {
        this.name = name;
        this.sections.add(section);
    }

    public Line() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
