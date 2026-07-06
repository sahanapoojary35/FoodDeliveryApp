package com.foodapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import com.foodapp.model.CartItem;
import com.foodapp.DBUtil.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        // safety check
        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        String address = request.getParameter("address");
        String paymentMode = request.getParameter("paymentMode");

        double totalAmount = 0;

        for (CartItem item : cart) {
            totalAmount += item.getSubtotal();
        }

        int orderId = 0;

        try (Connection conn = DBConnection.getConnection()) {

            // ==============================
            // 1. INSERT INTO ORDERS TABLE
            // ==============================
            String orderSql =
                    "INSERT INTO orders (user_id, restaurant_id, total_amount, delivery_address, payment_mode, order_status, order_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(orderSql);

            ps.setInt(1, 1);
            ps.setInt(2, 1);
            ps.setDouble(3, totalAmount);
            ps.setString(4, address);
            ps.setString(5, paymentMode);
            ps.setString(6, "PLACED");
            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            ps.executeUpdate();

            // ==============================
            // GET LAST ORDER ID (SAFE WAY)
            // ==============================
            PreparedStatement psOrder = conn.prepareStatement(
                    "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1"
            );

            ResultSet rsOrder = psOrder.executeQuery();

            if (rsOrder.next()) {
                orderId = rsOrder.getInt(1);
            }

            // ==============================
            // 2. INSERT INTO ORDER ITEMS
            // ==============================
            String itemSql =
                    "INSERT INTO order_items (order_id, menu_id, quantity, item_price, subtotal) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement psItem = conn.prepareStatement(itemSql);

            for (CartItem item : cart) {

                psItem.setInt(1, orderId);
                psItem.setInt(2, item.getMenuId());
                psItem.setInt(3, item.getQuantity());
                psItem.setDouble(4, item.getPrice());
                psItem.setDouble(5, item.getSubtotal());

                psItem.addBatch();
            }

            psItem.executeBatch();

            // ==============================
            // 3. CLEAR CART
            // ==============================
            session.removeAttribute("cart");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ==============================
        // 4. SEND TO JSP
        // ==============================
        request.setAttribute("orderId", orderId);

        request.getRequestDispatcher("order-success.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}