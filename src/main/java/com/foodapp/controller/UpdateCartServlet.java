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

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get values from cart page
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Get session
        HttpSession session = request.getSession();

        // Get cart
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart != null) {

            for (CartItem item : cart) {

                if (item.getMenuId() == menuId) {

                    item.setQuantity(quantity);
                    break;

                }
            }
        }

        // Save updated cart
        session.setAttribute("cart", cart);

        // Go back to cart page
        response.sendRedirect("cart.jsp");
    }
}