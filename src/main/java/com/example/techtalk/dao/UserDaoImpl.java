package com.example.techtalk.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.techtalk.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Long save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        em.flush();
        return user.getId();
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }
}
