<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Checkout</title>

<style>

body{
    font-family:Arial;
    background:#f5f5f5;
}

.container{
    width:40%;
    margin:40px auto;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

h1{
    text-align:center;
}

input,textarea,select{

    width:100%;
    padding:10px;
    margin-top:8px;
    margin-bottom:15px;

}

button{

    width:100%;
    padding:12px;
    background:green;
    color:white;
    border:none;
    border-radius:5px;
    font-size:16px;
    cursor:pointer;

}

button:hover{

    background:darkgreen;

}

</style>

</head>

<body>

<div class="container">

<h1>Checkout</h1>

<form action="checkout" method="post">

<label>Customer Name</label>

<input type="text" name="customerName" required>

<label>Delivery Address</label>

<textarea name="address" rows="4" required></textarea>

<label>Payment Mode</label>

<select name="paymentMode">

<option>UPI</option>

<option>Cash</option>

<option>Card</option>

</select>

<button type="submit">

Place Order

</button>

</form>

</div>

</body>

</html>