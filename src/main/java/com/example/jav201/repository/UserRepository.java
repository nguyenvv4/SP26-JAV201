package com.example.jav201.repository;

import com.example.jav201.model.Favorite;
import com.example.jav201.model.User;
import com.example.jav201.model.Video;
import com.example.jav201.ultis.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    public List<User> page(int page) {
        int size = 3;
        List<User> data = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Query<User> q = session.createQuery(
                    "SELECT u FROM User u",
                    User.class
            );
            q.setFirstResult(page * size);
            q.setMaxResults(size);
            data = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void add(User user) {
        System.out.println(user);
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction tran = session.beginTransaction();
        try {
            session.save(user);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        }
    }

    public void delete(User user) {
        System.out.println(user);
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction tran = session.beginTransaction();
        try {
            session.delete(user);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        }
    }

    public void update(User user) {
        System.out.println(user);
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction tran = session.beginTransaction();
        try {
            // dung saveOrUpdate khi Id tu tang.
            // neu khong truyen id(Trong TH id tu tang => tu hieu ham save duoc chay
            // nguoc lai la update
            //session.saveOrUpdate(user);
            // trong trong hop id khong tu tang=> dung ham update
            session.update(user);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        }
    }

    public User findById(String idUser) {
        Session session = HibernateUtils.getFACTORY().openSession();
        String jpql = "Select u from User u where u.id = :id";
        TypedQuery<User> query = session.createQuery(jpql);
        // "id" la :id trong jpql
        query.setParameter("id", idUser);
        return query.getSingleResult();
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
//        List<User> userList = userRepository.getList();
//        for (User user : userList) {
//            System.out.println(user.getFavorites());
//        }


    }

}
