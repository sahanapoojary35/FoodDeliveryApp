<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Restaurant" %>

<%
    List<Restaurant> restaurants =
        (List<Restaurant>) request.getAttribute("restaurants");
%>

<h1>Restaurants List</h1>

<% if (restaurants != null) { %>

    <% for (Restaurant r : restaurants) { %>

        <div style="border:1px solid black; padding:10px; margin:10px;">
        <img src="<%= r.getImageUrl() %>"
     alt="<%= r.getName() %>"
     width="250"
     height="170"
     style="border-radius:10px;">
        
            <h2><%= r.getName() %></h2>
            <p>Cuisine: <%= r.getCuisineType() %></p>
            <p>Address: <%= r.getAddress() %></p>
            <p>Rating: <%= r.getRating() %></p>
            <a href="menu?restaurantId=<%= r.getRestaurantId() %>">
    View Menu
</a>
        </div>

    <% } %>

<% } else { %>
    <h3>No restaurants found</h3>
<% } %>