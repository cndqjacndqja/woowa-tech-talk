package com.example.techtalk.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Section {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Station upStation;

    @OneToOne
    private Station downStation;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private Line line;

    public Section(Station upStation, Station downStation, Line line) {
        this.upStation = upStation;
        this.downStation = downStation;
        this.line = line;
    }

    public Section(Station upStation, Station downStation) {
        this.upStation = upStation;
        this.downStation = downStation;
    }

    public Section() {

    }

    public Long getId() {
        return id;
    }

    public Station getUpStation() {
        return upStation;
    }

    public Station getDownStation() {
        return downStation;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
