<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1 {
	font-family: century gothic;
	color: #292F33
}

label {
	color: #006666;
	font-family: century gothic;
}
</style>
<link rel="stylesheet" type="text/css"  href="loginPage.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assign program to Client</title>
<center>
	<img src="logo3.png" alt="logo"> <br />
	<br />
	<center>
		<h1>Assign a Program to a Client</h1>
		<br>
		<br>
</head>

<body>

	<form method="get" action="SellerServlet">
		<label for="phone">Client's Phone Number:</label> </br> <input type="text"
			id="phone" name="phone"> </br>
		</br> <label for="program">Program:</label> </br> <input type="text"
			id="program" name="program">
				<br>
	<br>
	<button class="button button2">Cancel</button>
	<button class="button button1" type="submit">Save</button>
	</form>
</body>
<br>
<br>
<br>
<br>
<center>
	<a href="loginPage.jsp"> <img src="logout.png" alt="Logout"
		width="30" ; height="30";>
	</a>
	<p>Logout</p>
	</body>
</html>