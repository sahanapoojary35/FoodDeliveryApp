<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
    Integer orderId = (Integer) request.getAttribute("orderId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>

<style>

body{
    font-family: Arial;
    background:#f5f5f5;
}

.container{
    width:40%;
    margin:auto;
    margin-top:80px;
    background:white;
    padding:30px;
    text-align:center;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

h1{
    color:green;
}

button{
    background:orange;
    border:none;
    padding:10px 20px;
    color:white;
    cursor:pointer;
    margin-top:20px;
}

button:hover{
    background:darkorange;
}

</style>

</head>

<body>

<div class="container">

<h1>🎉 Order Confirmed!</h1>

<h2>Order ID: <%=orderId%></h2>

<p>Thank you for ordering with us 🍔</p>

<a href="home.jsp">
    <button>Back to Home</button>
</a>

</div>

</body>
</html>