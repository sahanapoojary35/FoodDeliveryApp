package com.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get values from menu page
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        String itemName = request.getParameter("itemName");
        double price = Double.parseDouble(request.getParameter("price"));

        // Get session
        HttpSession session = request.getSession();

        // Get cart from session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Add item to cart
        CartItem item = new CartItem(menuId, itemName, price, 1);
        cart.add(item);

        // Save cart in session
        session.setAttribute("cart", cart);

        // Open cart page
        response.sendRedirect("cart.jsp");
    }
}