package com.example.jav201.repository;

import com.example.jav201.model.Favorite;
import com.example.jav201.model.User;
import com.example.jav201.ultis.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class UserRepo {
    public List<User> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        String jpql = "Select u from User u ";
        TypedQuery<User> query = session.createQuery(jpql);
        return query.getResultList();
    }
}
