package com.example.jav201.controller;

import java.io.*;
import java.util.List;

import com.example.jav201.model.User;
import com.example.jav201.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UserControllerServlet", value = {
        "/user/create",
        "/user/show",
        "/user/detail",
        "/user/update",
        "/user/delete",
})
public class UserController extends HttpServlet {

    UserRepository userRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/user/show")) {
//            Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
            List<User> listUser = userRepository.getList();
            request.setAttribute("list", listUser);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else if (uri.contains("/user/detail")) {
            String id = request.getParameter("id");
            User user = userRepository.findById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        } else if (uri.contains("/user/delete")) {
            String id = request.getParameter("id");
            User user = userRepository.findById(id);
            userRepository.delete(user);
            response.sendRedirect("/user/show");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/user/create")) {
            // thuc hien them
            // lay thong tin cua user tren form theo thuoc tinh name cua o input
            String id = request.getParameter("id");
            String name = request.getParameter("fullName");
            String email = request.getParameter("email");
            String pw = request.getParameter("password");
            Boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
            // luu y thu tu phai giong trong user
//            User user = new User(id, pw, name, email, admin);
//            System.out.println(user.toString());
//            userRepository.add(user);
//            response.sendRedirect("/user/show");
        } else if (uri.contains("/user/update")) {
            String id = request.getParameter("id");
            String name = request.getParameter("fullName");
            String email = request.getParameter("email");
            String pw = request.getParameter("password");
            Boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
//            User user = new User(id, pw, name, email, admin);
//            userRepository.update(user);
            response.sendRedirect("/user/show");
        }
    }
}