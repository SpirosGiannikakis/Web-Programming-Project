<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"  href="loginPage.css"/>
<style>
	h1 {font-family:century gothic; color:#292F33}
	label {color: #006666; font-family:century gothic;}
</style>
<head>
<center><img src="logo3.png" alt="logo">
	</br></br>
	<center><h1>Register a new Seller</h1>
</head>
<body>
<form method="get" action= "AdminServlet">
	<label for="name">Name:</label>
	</br>
	<input type="text" id="name" name="name">
	</br></br>
	<label for="surname">Surname:</label>
	</br>
	<input type="text" id="surname" name="surname">
	</br></br>
	<label for="username">Username:</label>
	</br>
	<input type="text" id="username" name="username">
	</br></br>
	<label for="password">Password:</label>
	</br>
	<input type="text" id="password" name="password">
	</br></br></br></br>
	
	<a href="startPage.jsp"><button  class="button button2">Cancel</button></a>
	<button class="button button1">Register</button>
	</br></br>
</form>
</br></br></br>
<center><a href="loginPage.html">
  <img src="logout.png" alt="Logout" width="30"; height="30";>
  </a>
  <p>Logout</p>
</body>