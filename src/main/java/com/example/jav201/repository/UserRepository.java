package com.example.jav201.repository;

import com.example.jav201.model.User;
import com.example.jav201.ultis.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<User> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        String jpql = "Select u from User u";
        TypedQuery<User> query = session.createQuery(jpql);
        return query.getResultList();
    }

    public List<User> page() {
        int page = 1;     // bắt đầu từ 1
        int size = 3;
        List<User> data = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Query<User> q = session.createQuery(
                    "SELECT u FROM User u",
                    User.class
            );
            q.setFirstResult((page - 1) * size);
            q.setMaxResults(size);
            data = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        List<User> userList = userRepository.page();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
