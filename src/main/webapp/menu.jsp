<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Menu"%>

<%
    // Get menu list from MenuServlet
    List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color:#f5f5f5;
}

.container{
    width:80%;
    margin:auto;
}

.card{
    background:white;
    border:1px solid #ccc;
    padding:15px;
    margin:15px 0;
    border-radius:8px;
}

.price{
    color:green;
    font-weight:bold;
}

button{
    background:orange;
    color:white;
    border:none;
    padding:8px 15px;
    border-radius:5px;
    cursor:pointer;
}

button:hover{
    background:#ff6600;
}

</style>

</head>

<body>

<div class="container">

<h1>Restaurant Menu</h1>

<%
if(menuList!=null && !menuList.isEmpty()){

for(Menu menu : menuList){
%>

<div class="card">

<h2><%=menu.getItemName()%></h2>

<p><%=menu.getDescription()%></p>
<img src="<%= menu.getImageUrl() %>" width="150" height="150">

<p>
Category :
<%=menu.getCategory()%>
</p>

<p class="price">
₹ <%=menu.getPrice()%>
</p>

<p>
Availability :
<%=menu.isAvailable() ? "Available" : "Not Available"%>
</p>

<form action="cart" method="post">

    <input type="hidden" name="menuId" value="<%=menu.getMenuId()%>">

    <input type="hidden" name="itemName" value="<%=menu.getItemName()%>">

    <input type="hidden" name="price" value="<%=menu.getPrice()%>">

    <button type="submit">Add To Cart</button>

</form>

</div>

<%
}

}
else{
%>

<h2>No Menu Items Found</h2>

<%
}
%>

</div>

</body>
</html>