package com.example.techtalk.dao;

import com.example.techtalk.entity.Section;
import com.example.techtalk.entity.Station;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StationDao {

    private final EntityManager entityManager;

    public StationDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Station save(Station station) {
        entityManager.persist(station);
        return station;
    }

    public Station findById(Long id) {
        return entityManager.find(Station.class, id);
    }
}
