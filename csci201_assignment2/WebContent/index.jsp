<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="WeatherReader.*" session="true" %>
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<% 
	String account = (String)request.getSession().getAttribute("Account");
	System.out.println("index session: " + account);
	if(account != null && account.length()>0){
	%>
	<script>
	$(document).ready(function(){
	 	 $("#log").css("visibility", "hidden");
	 	 $("#reg").css("visibility", "hidden");
	 	 $("#signout").css("visibility", "visible");
	 	 $("#profile").css("visibility", "visible");
	  });
	</script>
	<% }%>
	<script>
	$(document).ready(function(){
	 	 $("#signout").click(function(){
		 	 window.location.href = "index2.jsp";
	   	 });
	  	});
	$(document).ready(function(){
 	 $("#map").click(function(){
 		$("#googleMap").css("visibility","visible");
    	
   	 });
  	});
	$(document).ready(function(){
	 	 $("#log").click(function(){
	 		window.location.href = "login.jsp";
	   	 });
	  	});
	$(document).ready(function(){
	 	 $("#profile").click(function(){
	 		window.location.href = "profile.jsp";
	   	 });
	  	});
	$(document).ready(function(){
	 	 $("#reg").click(function(){
	 		window.location.href = "register.jsp";
	   	 });
	  	});
	</script>
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
	<style>	
	@font-face {
   	font-family: regular;
   	src: url(AvenirNext-UltraLight.tff);
	}
	img.background{
	width: 100%;
  	height: 100%;
  	position: absolute;
  	left: 0px;
  	top: 0px;
  	z-index: -1;
  	filter: brightness(60%) blur(5px);
	}
  	.header{
  	position:relative;
  	top:-20px;
  	background-color:black;
  	height:60px;
  	width: 100%;
  	padding:0;
  	}
  	#weatherlogo{
  	position:relative;
  	display: inline;
  	left:20px;
  	top:20px;
  	color:white;
  	font-family: "Savoye Let";
  	}
  	#log{
  	color:white;
  	position:relative;
  	display: inline;
  	left:70%;
  	top:20px;
  	font-family: "Courier New", Courier, monospace;
 	font-size:24px;
  	color:white;
  	}
  	#reg{
  	color:white;
  	position:relative;
  	display: inline;
  	left:72%;
  	top:20px;
  	font-family: "Courier New", Courier, monospace;
  	font-size:24px;
  	color:white;
  	}
  	 #profile{
  	 visibility:hidden;
  	color:white;
  	position:relative;
  	display: inline;
  	left:55%;
  	top:20px;
  	font-family: "Courier New", Courier, monospace;
 	font-size:24px;
  	color:white;
  	}
  	#signout{
  	visibility:hidden;
  	color:white;
  	position:relative;
  	display: inline;
  	left:57%;
  	top:20px;
  	font-family: "Courier New", Courier, monospace;
  	font-size:24px;
  	color:white;
  	}
  	.container{
  	
  	width:350px;
	margin:50px auto 5px auto;
  	}
  	#logo{
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
  	margin-top: -45px;
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
  	#map{
  	position:relative;
  	top:9px;
  	border-radius: 10%;
  	margin-left: 10px;
  	width:auto;
  	height: 32px;
  	}
  	.radioClass{
  	text-align:center;
  	font-family: regular;
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
  	#googleMap{
  	visibility:hidden;
  	position:absolute;
  	left:20%;
  	width:60%;
  	height:400px;
  	margin-top: -300px;
  	}
	</style>
</head>
	<body>
	<img class="background" src="image/background.jpg" >
	<div class="header">
		<h1 id="weatherlogo">WeatherMeister</h1>
		<h1 id="log">Login</h1>
		<h1 id="reg">Register</h1>
		<h1 id="profile">Profile</h1>
		<h1 id="signout">Sign Out</h1>
	</div>
	<div class= "container">
		<img id = "logo" src = "image/logo.png" alt="logo">
	</div>
	<div id= "SearchBox">
		<form action = "Backend" method = post>
		<input type="text" name="cityname" value="Los Angeles" onfocus="this.value=''">
		<input type="image" src="image/magnifying_glass.jpg" alt="Submit" />
		</form>
	</div>
	<div id= "Location" style="visibility:hidden">
		<form action = "Backend" method = post>
			<input id="lat" type="text" name="Latitude" value="Latitude" onfocus="this.value=''">
			<input id="long" type="text" name="Longitude" value="Longitude" onfocus="this.value=''">
			<input type="image" src="image/magnifying_glass.jpg" alt="Submit" />
			<img id="map" src="image/MapIcon.png" alt="map" />
		</form>
	</div>
	
	<div class="radioClass">
		<input type="radio" onchange="hideLoc(this)" name="choice" checked> <b style="color:white;">City</b>
		<input type="radio" onchange="hideCity(this)" name="choice"> <b style="color:white;">Location(Lat./Long.)</b>
	</div>
	<div class="display" style="visibility: hidden">
		<form action = "Backend" method = post>
			<input type="submit" name="Display" value="Display All">
		</form>
	</div>
	<div id="googleMap"></div>
	<script>
	function myMap() {
	var mapProp= {
	  center:new google.maps.LatLng(51.508742,-0.120850),
	  zoom:5,
	};
	var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	google.maps.event.addListener(map, 'click', function(event) {
		  placeMarker(map, event.latLng);
		  click(map, event.latLng);
		});
	}
	function placeMarker(map, location) {
		  var marker = new google.maps.Marker({
		    position: location,
		    map: map
		  });
		  var infowindow = new google.maps.InfoWindow({
		    content: 'Latitude: ' + location.lat() +
		    '<br>Longitude: ' + location.lng()
		  });
		  infowindow.open(map,marker);
	}
	function click(map, location) {
		  $("#googleMap").css("visibility", "hidden");
		  var lat = parseFloat((location.lat()).toFixed(2));
		  var lon = parseFloat((location.lng()).toFixed(2));
		  $("#lat").val(lat);
		  $("#long").val(lon);
	}
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2hZA1-QqUEJC-l0giDSWPS9cY3ki2yCg&callback=myMap"></script>

	</body>
</html>