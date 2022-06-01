package com.example.techtalk.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.techtalk.entity.Fare;
import com.example.techtalk.entity.Line;
import com.example.techtalk.entity.Line2;
import com.example.techtalk.entity.Section;
import com.example.techtalk.entity.Station;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
class Line2DaoTest {

    @LocalServerPort
    int port;

    @Autowired
    EntityManager entityManager;

    @Autowired
    LineDao lineDao;

    @Autowired
    SectionDao sectionDao;

    @Autowired
    StationDao stationDao;
//
//    @Test
//    void save() throws SQLException {
//        Line line = new Line("2호선");
//        Station upStation = new Station("교대역");
//        Station downStation= new Station("교대역");
//        Section section = new Section(line, upStation, downStation);
//
//        lineDao.save(line);
//        stationDao.save(upStation);
//        stationDao.save(upStation);
//        Section savedSection = sectionDao.save(section);
//
//        Section byId = sectionDao.findById(savedSection.getId());
//        assertThat(savedSection.getLine().getName()).isEqualTo(line.getName());
//    }

}
