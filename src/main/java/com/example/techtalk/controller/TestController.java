package com.example.techtalk.controller;

import com.example.techtalk.dao.LineDao;
import com.example.techtalk.dao.SectionDao;
import com.example.techtalk.dao.StationDao;
import com.example.techtalk.entity.Fare;
import com.example.techtalk.entity.Line;
import com.example.techtalk.entity.Line2;
import com.example.techtalk.entity.Section;
import com.example.techtalk.entity.Station;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    LineDao lineDao;

    @Autowired
    SectionDao sectionDao;

    @Autowired
    StationDao stationDao;

    @GetMapping("/line")
    public ResponseEntity saveLine() {
        Station upStation = new Station("교대역");
        Station downStation= new Station("교대역");
        Section section = new Section(upStation, downStation);
        Line line = new Line("2호선", section);

        stationDao.save(upStation);
        stationDao.save(downStation);
        Section savedSection  = sectionDao.save(section);

        Line save = lineDao.save(line);
        section.setLine(save);




        Section byId = sectionDao.findById(savedSection.getId());
        return ResponseEntity.ok().body(byId);

    }

}
