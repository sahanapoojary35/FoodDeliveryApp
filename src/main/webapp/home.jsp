<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<%
    // Get logged-in user from session
    String userName = (String) session.getAttribute("userName");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food Delivery Home</title>
</head>

<body>

<h1>🍔 Food Delivery App</h1>

<hr>

<!-- 🔐 LOGIN CHECK -->
<% if (userName != null) { %>

    <h2>Welcome, <%= userName %> 👋</h2>

    <a href="logout">Logout</a>

<% } else { %>

    <h2>Welcome Guest 👋</h2>

    <a href="login.jsp">Login</a> |
    <a href="signup.jsp">Sign Up</a>

<% } %>

<hr>

<!-- 🍽️ APP FEATURES -->
<h2>Available Services</h2>

<ul>
    <li>🍴 View Restaurants</li>
    <li>📋 Browse Menu</li>
    <li>🛒 Add to Cart</li>
    <li>💳 Place Orders</li>
</ul>
<a href="restaurants">👉 Click here to View Restaurants</a>
<hr>

<!-- 🔥 SAMPLE SECTION (you will connect DB later) -->
<h3>Featured Restaurants</h3>

<div>
    <p>🍕 Pizza Palace</p>
    <p>🍔 Burger Hub</p>
    <p>🍜 Chinese Wok</p>
    <p>🍛 Spice Garden</p>
</div>

</body>
</html>