package com.example.lib.repository;

import com.example.lib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private EntityManager entityManager;

    public User findUserAccount(String username) {
        try {
            String sql = "Select e from " + User.class.getName() + " e " //
                    + " Where e.username = :username ";

            Query query = entityManager.createQuery(sql, User.class);
            query.setParameter("username", username);

            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
