package com.example.jav201.repository;

import com.example.jav201.model.Favorite;
import com.example.jav201.model.User;
import com.example.jav201.ultis.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class FavoriteRepo {

    public List<Favorite> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        String jpql = "Select u from Favorite u where u.idUser.id ='U001'";
        TypedQuery<Favorite> query = session.createQuery(jpql);
        return query.getResultList();
    }

    public static void main(String[] args) {
        FavoriteRepo favoriteRepo = new FavoriteRepo();
        List<Favorite> favorites = favoriteRepo.getList();
        for (Favorite favorite : favorites) {
//            if (favorite.getIdUser().getId().equals("U001")) {
            System.out.println(favorite.getIdVideo().getTitle());
//            }
        }
    }
}
