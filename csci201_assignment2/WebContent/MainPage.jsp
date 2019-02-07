<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="weatherReader.Weather, weatherReader.WeatherReader" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	function hideLoc(x){
		if (x.checked) {
		     document.getElementById("Location").style.visibility = "hidden";
		     document.getElementById("SearchBox").style.visibility = "visible";
		  }
	}
	function hideCity(x){
		if (x.checked) {
		     document.getElementById("SearchBox").style.visibility = "hidden";
		     document.getElementById("Location").style.visibility = "visible";
		  }
	}
	</script>
	<meta charset="UTF-8">
	<title>WeatherLookUp</title>
	<%WeatherReader w = new WeatherReader();
	String path = getServletContext().getRealPath("/weather.txt");
	w.parseFile("weather.txt", path);%>
	<style>
	<%if(w.isLegal){%>
	img.background{
	width: 100%;
  	height: 100%;
  	position: absolute;
  	left: 0px;
  	top: 0px;
  	z-index: -1;
  	filter: blur(5px);
	}
	/*
	body{
	background-image: url("image/background.jpg");
  	background-repeat: no-repeat;
  	backgournd-position: center;
  	background-size:cover;
  	}
  	*/
  	.header{
  	position:relative;
  	top:-20px;
  	background-color:black;
  	height:50px;
  	width: 100%;
  	padding:0;
  	}
  	.header h1{
  	position:relative;
  	left:20px;
  	top:15px;
  	color:white;

  	font-family: "Savoye Let";
  	}
  	.container{
  	
  	width:350px;
	margin:50px auto 5px auto;
  	}
  	img{
		width:350px;
  	}
  	#SearchBox{
  	position:relative;
  	text-align:center;
  	margin-top: -20px;
  	}
  	#Location{
  	position:relative;
  	text-align:center;
  	margin-top: -40px;
  	}
  	#SearchBox input[type="text"]{
  	background: rgba(255,255,255,0.5);;
  	border: 2px solid white;
  	color:white;
  	font-size:16px;
  	width:30%;
  	height: 30px;
  	}
  	#Location input[type="text"]{
  	background: rgba(255,255,255,0.5);;
  	border: 2px solid white;
  	color:white;
  	font-size:16px;
  	width:15%;
  	height: 30px;
  	}
  	input[type="image"]{
  	position:relative;
  	top:9px;
  	margin-left: -40px;
  	width:auto;
  	height: 28px;
  	}
  	.radioClass{
  	text-align:center;
  	}
  	.display{
  	position:relative;
  	top:10px;
  	text-align:center;
  	}
  	input[type="submit"]{
  	background-color: transparent;
  	border-radius: 10%;
  	color: white;
  	padding: 3px 20px;
  	text-align: center;
  	text-decoration: none;
  	display: inline-block;
  	font-size: 16px;
  	margin: 4px 2px;
  	}
  	
  	<%}%>
	</style>
	
	
	
</head>
	<body>
	<%
	if(!w.isLegal){
		String message = w.ErrorMessage;
	%>
	ErrorMessage:<br><%=message%>
	<%}
	else{%>
	<img class="background" src="image/background.jpg" >
	<div class="header">
		<h1>WeatherMeister</h1>
	</div>
	<div class= "container">
		<img src = "image/logo.png" alt="logo">
	</div>
	
	<div id= "SearchBox">
		<form action = "result.jsp" method = post>
		<input type="text" name="cityname" value="Los Angeles">
		<input type="image" src="image/magnifying_glass.jpg" alt="Submit" />
		</form>
	</div>
	<div id= "Location" style="visibility:hidden">
		<form action = "Backend" method = post>
			<input type="text" name="Latitude" value="Latitude">
			<input type="text" name="Longitude" value="Longitude">
			<input type="image" src="image/magnifying_glass.jpg" alt="Submit" />
		</form>
	</div>
	
	<div class="radioClass">
		<input type="radio" onchange="hideLoc(this)" name="choice" checked> <b style="color:white;">City</b>
		<input type="radio" onchange="hideCity(this)" name="choice"> <b style="color:white;">Location(Lat./Long.)</b>
	</div>
	<div class="display">
		<form action = "Backend" method = post>
			<input type="submit" name="button" value="Display All">
		</form>
	</div>
	




<% }%>
	</body>
</html>