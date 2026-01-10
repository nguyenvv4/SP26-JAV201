package com.example.jav201.repository;

import com.example.jav201.model.User;
import com.example.jav201.ultis.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {

    public List<User> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        String jpql ="Select u from User u";
        TypedQuery<User> query = session.createQuery(jpql);
        return query.getResultList();
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        List<User> userList = userRepository.getList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
