package com.example.techtalk.dao;

import com.example.techtalk.entity.Line;
import com.example.techtalk.entity.Line2;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LineDao {

    private final EntityManager entityManager;

    public LineDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Line save(Line line) {
        entityManager.persist(line);
        return line;
    }

    public Line findById(Long id) {
        return entityManager.find(Line.class, id);
    }
}
