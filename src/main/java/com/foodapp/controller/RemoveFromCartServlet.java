package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get Menu ID
        int menuId = Integer.parseInt(request.getParameter("menuId"));

        // Get Session
        HttpSession session = request.getSession();

        // Get Cart
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart != null) {

            // Remove selected item
            cart.removeIf(item -> item.getMenuId() == menuId);

        }

        // Save cart again
        session.setAttribute("cart", cart);

        // Go back to cart page
        response.sendRedirect("cart.jsp");
    }
}