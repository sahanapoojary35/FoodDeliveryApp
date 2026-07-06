package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.dao.impl.RestaurantDAOImpl;
import com.foodapp.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurants")
public class RestaurantServlet extends HttpServlet {

    private RestaurantDAO restaurantDAO = new RestaurantDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 🔥 Get all restaurants from DB
            List<Restaurant> restaurantList = restaurantDAO.getAllRestaurants();

            // 🔥 Send data to JSP
            request.setAttribute("restaurants", restaurantList);

            // 🔥 Forward to JSP page
            request.getRequestDispatcher("restaurants.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}