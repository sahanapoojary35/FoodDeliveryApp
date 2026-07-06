<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.CartItem"%>

<%
    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    double total = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f5f5f5;
}

.container{
    width:80%;
    margin:auto;
    margin-top:30px;
}

h1{
    text-align:center;
}

table{
    width:100%;
    border-collapse:collapse;
    background:white;
}

th,td{
    padding:12px;
    border:1px solid #ddd;
    text-align:center;
}

th{
    background:orange;
    color:white;
}

input[type=number]{
    width:60px;
    padding:5px;
}

button{
    padding:8px 15px;
    border:none;
    border-radius:5px;
    cursor:pointer;
    color:white;
}

.update{
    background:green;
}

.update:hover{
    background:darkgreen;
}

.remove{
    background:red;
}

.remove:hover{
    background:darkred;
}

.checkout{
    margin-top:20px;
    text-align:right;
}

.checkout button{
    background:blue;
}

.checkout button:hover{
    background:darkblue;
}

.empty{
    text-align:center;
    font-size:20px;
    color:gray;
    margin-top:20px;
}

</style>

</head>

<body>

<div class="container">

<h1>🛒 My Cart</h1>

<table>

<tr>
    <th>Food Item</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Subtotal</th>
    <th>Action</th>
</tr>

<%
if(cart != null && !cart.isEmpty()){

    for(CartItem item : cart){

        total += item.getSubtotal();
%>

<tr>

    <td><%=item.getItemName()%></td>

    <td>₹<%=item.getPrice()%></td>

    <td>

        <form action="updateCart" method="post">

            <input type="hidden" name="menuId"
                   value="<%=item.getMenuId()%>">

            <input type="number"
                   name="quantity"
                   value="<%=item.getQuantity()%>"
                   min="1">

            <button type="submit" class="update">Update</button>

        </form>

    </td>

    <td>₹<%=item.getSubtotal()%></td>

    <td>
        <a href="removeFromCart?menuId=<%=item.getMenuId()%>">
            <button type="button" class="remove">Remove</button>
        </a>
    </td>

</tr>

<%
    }

}else{
%>

<tr>
    <td colspan="5" class="empty">
        Your Cart is Empty
    </td>
</tr>

<%
}
%>

</table>

<h2>Total : ₹<%=total%></h2>

<!-- ✅ FIXED CHECKOUT FLOW -->
<div class="checkout">

    <form action="checkout.jsp" method="get">
        <button type="submit">
            Proceed To Checkout
        </button>
    </form>

</div>

</div>

</body>
</html>