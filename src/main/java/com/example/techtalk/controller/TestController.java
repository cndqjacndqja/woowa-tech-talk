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
        Station downStation= new Station("강남역");
        Station newStation= new Station("역삼역");

        Section section1 = new Section(upStation, downStation);
        Section section2 = new Section(downStation, newStation);

        Line line = new Line("2호선", List.of(section1, section2));
        stationDao.save(upStation);
        stationDao.save(downStation);
        stationDao.save(newStation);

        Line savedLine = lineDao.save(line);
        Section savedSection1  = sectionDao.save(section1);
        Section savedSection2  = sectionDao.save(section2);

        savedSection1.setLine(savedLine);
        savedSection2.setLine(savedLine);

        Section byId = sectionDao.findById(savedSection1.getId());
        return ResponseEntity.ok().body(byId);
    }

}
