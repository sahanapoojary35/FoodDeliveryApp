package com.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * SignupServlet
 * This servlet handles the signup request.
 */

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Default constructor
    public SignupServlet() {
        super();
    }

    // Executes when the browser sends a GET request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Signup</title></head>");
        out.println("<body>");
        out.println("<h2>Signup Servlet is Working!</h2>");
        out.println("</body>");
        out.println("</html>");
    }

    // Executes when the browser submits the form
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Read values from signup.jsp
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        out.println("<html>");
        out.println("<head><title>Signup Success</title></head>");
        out.println("<body>");
        out.println("<h2>Signup Successful!</h2>");
        out.println("<p>Name : " + name + "</p>");
        out.println("<p>Email : " + email + "</p>");
        out.println("<p>Phone : " + phone + "</p>");
        out.println("<p>Address : " + address + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}