package com.example.techtalk.dao;

import com.example.techtalk.entity.Line;
import com.example.techtalk.entity.Section;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SectionDao {

    private final EntityManager entityManager;

    public SectionDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Section save(Section section) {
        entityManager.persist(section);
        return section;
    }

    public Section findById(Long id) {
        return entityManager.find(Section.class, id);
    }
}
