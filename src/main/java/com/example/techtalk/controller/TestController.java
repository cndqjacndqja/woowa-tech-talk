package com.example.techtalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techtalk.dao.LineDao;
import com.example.techtalk.dao.SectionDao;
import com.example.techtalk.dao.StationDao;
import com.example.techtalk.entity.Line;
import com.example.techtalk.entity.Section;
import com.example.techtalk.entity.Station;

@RestController
public class TestController {

    @Autowired
    LineDao lineDao;

    @Autowired
    SectionDao sectionDao;

    @Autowired
    StationDao stationDao;

    @GetMapping("/line")
    public ResponseEntity<Section> saveLine() {
        Station upStation = new Station("교대역");
        Station downStation = new Station("강남역");
        Station newStation = new Station("역삼역");

        Section section1 = new Section(upStation, downStation);
        Section section2 = new Section(downStation, newStation);

        Line line = new Line("2호선", List.of(section1, section2));
        section1.setLine(line);
        section2.setLine(line);

        stationDao.save(upStation);
        stationDao.save(downStation);
        stationDao.save(newStation);

        lineDao.save(line);

        sectionDao.save(section1);
        sectionDao.save(section2);

        Section byId = sectionDao.findById(section1.getId());
        return ResponseEntity.ok().body(byId);
    }

}
