package com.foodapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.foodapp.DBUtil.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT user_id, name, email FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                // ✅ LOGIN SUCCESS
                HttpSession session = request.getSession();
                session.setAttribute("userId", rs.getInt("user_id"));
                session.setAttribute("userName", rs.getString("name"));
                session.setAttribute("userEmail", rs.getString("email"));

                // 🔥 ALWAYS REDIRECT (fixes blank page issue)
                response.sendRedirect("home.jsp");

            } else {

                // ❌ LOGIN FAILED → back to login page
                response.sendRedirect("login.jsp?error=InvalidCredentials");
            }

        } catch (Exception e) {
            e.printStackTrace();

            // ❌ NEVER leave blank page
            response.sendRedirect("login.jsp?error=ServerError");
        }
    }
}