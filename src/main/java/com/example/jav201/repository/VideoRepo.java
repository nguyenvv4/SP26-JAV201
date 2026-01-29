package com.example.jav201.repository;

import com.example.jav201.model.Favorite;
import com.example.jav201.model.Video;
import com.example.jav201.ultis.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class VideoRepo {
    public List<Video> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        String jpql = "Select u from Video u ";
        TypedQuery<Video> query = session.createQuery(jpql);
        return query.getResultList();
    }
}
