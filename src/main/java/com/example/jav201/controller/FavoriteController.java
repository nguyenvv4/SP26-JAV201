package com.example.jav201.controller;

import java.io.*;
import java.util.Date;
import java.util.List;

import com.example.jav201.model.Favorite;
import com.example.jav201.model.User;
import com.example.jav201.model.Video;
import com.example.jav201.repository.FavoriteRepo;
import com.example.jav201.repository.UserRepo;
import com.example.jav201.repository.VideoRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "FavoriteControllerServlet", value = {"/favorite/show",
        "/favorite/save",
})
public class FavoriteController extends HttpServlet {

    FavoriteRepo favoriteRepo = new FavoriteRepo();
    VideoRepo videoRepo = new VideoRepo();
    UserRepo userRepo = new UserRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Favorite> listFavorite = favoriteRepo.getList();
        List<User> listUSer = userRepo.getList();
        // danh sach user
        List<Video> listVideo = videoRepo.getList();
        // danh sach video

        request.setAttribute("listFavorite", listFavorite);
        request.setAttribute("listUSer", listUSer);
        request.setAttribute("listVideo", listVideo);
        request.getRequestDispatcher("/favorite.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUser = request.getParameter("idUser");
        String idVideo = request.getParameter("idVideo");
        User user = new User();
        user.setId(idUser);
        Video video = new Video();
        video.setId(idVideo);
        Favorite favorite = new Favorite();
        favorite.setIdVideo(video);
        favorite.setIdUser(user);
        favorite.setLikeDate(new Date());
        favoriteRepo.save(favorite);
        response.sendRedirect("/favorite/show");
    }
}