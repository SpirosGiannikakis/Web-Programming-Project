<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="loginPage.css"/>
<style type="text/css">
	h1 {font-family:century gothic; color:#292F33}
	label {color: #006666; font-family:century gothic;}
</style>
<title>Add new Client</title>
<center>
	<img src="logo3.png" alt="logo">
	</br></br>
<center>
<h1>Add a new Client</h1>
</head>

<body>
<form method="post" action= "SellerServlet">
<!--  input type="hidden" name="requestType" value="Insert" /> -->
	<label for="name">Name:</label>
	</br>
	<input type="text" id="name" name="name">
	</br></br>
	<label for="surname">Surname:</label>
	</br>
	<input type="text" id="surname" name="surname">
	</br></br>
	<label for="phoneNumber">Phone Number:</label>
	</br>
	<input type="text" id="phoneNumber" name="phone">
	</br></br>
	<label for="afm">AFM:</label>
	</br>
	<input type="text" id="afm" name="afm" >
	</br></br>
	<label for="username">Username:</label>
	</br>
	<input type="text" id="username" name = "username">
	</br></br>
	<label for="password">Password:</label>
	</br>
	<input type="text" id="password"  name="password">
	</br></br></br></br>
	
	<a href="startPage.jsp"><button  class="button button2">Cancel</button></a>
	<button class="button button1" type="submit">Add</button>
	</br></br>
</form>
<br><br><br>
<center>
	<a href="SellerLogout">
  		<img src="logout.png" alt="Logout" width="30"; height="30";>
  	</a>
  <p>Logout</p>
</body>
</html>



