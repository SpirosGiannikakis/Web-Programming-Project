<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="loginPage.css"/>
	<title>Login</title>
<style>
	h1 {font-family:century gothic; color:#292F33}
	form {text-align: center;}
	label {color: #006666; font-family:century gothic;}
</style>
</head>

<body>
<center>
	<img src="logo3.png" alt="logo">
	<br/><br/>
<center>
<h1>Login</h1>
<br/><br/>
<form method = "post" action = "SellerLogin">
	<label for="username">Username:</label>
	<br/>
	<input type="text" id="username" name="username">
	<br/><br/>
	<br/><br/>
	<label for="password">Password:</label>
	<br/>
	<input type="text" id="password" name="password">
	<br/><br/>
	<button class="button button1">Login</button>
	<br/><br/>
</form>
</body>
</html>






