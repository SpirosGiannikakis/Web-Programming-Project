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
	<center><h1>Create a new Program</h1>
</head>
<body>
<form method="post" action= "AdminServlet">
	<label for="pname">Program Name:</label>
	</br>
	<input type="text" id="pname" name="pname">
	</br></br>
	<label for="calls">Calls:</label>
	</br>
	<input type="text" id="calls" name="calls">
	</br></br>
	<label for="sms">SMS:</label>
	</br>
	<input type="text" id="sms" name="sms">
	</br></br>
	<label for="data">Data:</label>
	</br>
	<input type="text" id="data" name="data">
	</br></br>
	<label for="price">Price:</label>
	</br>
	<input type="text" id="price" name="price">
	</br></br></br></br>
	<a href="startPage.jsp"><button  class="button button2">Cancel</button></a>
	<button class="button button1">Create</button>
	</br></br>
</form>
</br></br></br>
<center><a href="loginPage.html">
  <img src="logout.png" alt="Logout" width="30"; height="30";>
  </a>
  <p>Logout</p>
</body>