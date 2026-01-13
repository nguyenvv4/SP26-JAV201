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
})
public class UserController extends HttpServlet {

    UserRepository userRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/user/show")) {
            Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
            List<User> listUser = userRepository.page(pageNo);
            request.setAttribute("list", listUser);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}