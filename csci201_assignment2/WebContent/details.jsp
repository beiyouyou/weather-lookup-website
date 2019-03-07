<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="WeatherReader.*,java.util.List, java.util.Collections" %>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
	<title>City Detail</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
 	 $("#map").click(function(){
 		$("#googleMap").css("visibility","visible");
    	
   	 });
  	});
	$(document).ready(function(){
	 	 $("#titlelogo").click(function(){
	 		window.location.href = "index.jsp";
	    	
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
	<%
	Weather city =  (Weather)request.getSession().getAttribute("city");
	String Location = city.getCity() +",\n" + city.getCountry();
	String TempLow = city.getDayLow() + " degrees Fahrenheit";
	String TempHigh = city.getDayHigh() + " degrees Fahrenheit";
	String Wind = String.format("%.2f", city.getWindspeed()) + " miles/hour";
	String Humidity = city.getHumidity() +"%";
	String Coordinates = String.format("%.2f", city.getLatitude()) +"," + String.format("%.2f", city.getLongitude());
	String CurrTemp = city.getCurrentTemperature() + " degrees Fahrenheit";
	String Sunrise = city.getSunriseTime() +" , " + city.getSunsetTime();
	%>
	<style type="text/css">
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
  	top:-10px;
  	background-color:black;
  	height:50px;
  	width: 100%;
  	padding:0;
  	z-index: 1;
  	}
  	a{
  	position:relative;
  	left:20px;
  	top:15px;
  	color:white;
  	font-size: 32px;
  	font-family: "Savoye Let";
  	text-decoration: none;
  	z-index: 2;
  	}
	#SearchBox{
  	position:relative;
  	text-align:center;
  	top: -34px;
  	}
  	#Location{
  	position:relative;
  	text-align:center;
  	top: -74px;
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
  	position: absolute; 
  	top: 17px; 
  	left: 67%; 
  	display: block; 
  	}
  	h1{
  	position:relative;
  	left:5%;
  	color:white;
  	font-size: 32px;
  	
  	}
  	#selectBox{
  	position:relative;
  	font-size:24px;
  	top:-530px;
  	left:70%;
  	color:white;
  	height: 250px;
  	}
  	select{
  	position: relative;
  	top:-20px;
  	left:-20px;
  	width:200px;
  	height: 40px;
  	font-size:20px;
  	}
  	#Table{
  	margin-left:20%;
  	margin-top:50px;
  	height:80%;
  	text-align:center;
  	}
  	  	#map{
  	position:relative;
  	top:9px;
  	border-radius: 10%;
  	margin-left: 10px;
  	width:auto;
  	height: 32px;
  	}
  	#row1 img{
  	width:130px;
  	height:auto;
  	}
  	#row2 img{
  	position:relative;
  	width:130px;
  	height:auto;
  	top:-30px;
  	}
  	#row1 p{
  	position:absolute;
  	top:300px;
  	color:white;
  	font-size:28px;
  	padding-left: 45px;}
  	 #row2 p{
  	position:absolute;
  	top: 550px;
  	color:white;
  	font-size:28px;
  	padding-left: 45px;}
  	#Table h1{
  	position:relative;
  	top:-120px;
  	color:white;
  	left:-5px;
  	font-size:28px;
  	}
  	#row2 img{
  	postion:relative;
  	top:-20px;
  	}
  	#googleMap{
  	visibility:hidden;
  	position:absolute;
  	left:20%;
  	width:60%;
  	height:400px;
  	margin-top: -630px;
  	}
  	</style>
   </head>
	<body>
	<img class="background" src="image/background.jpg" >
	<div class="header">
		<a id="titlelogo" >WeatherMeister</a>
		<div id= "SearchBox">
			<form action = "Backend" method = get>
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
		<span class="radioClass">
		<input type="radio" onchange="hideLoc(this)" name="choice" checked> <b style="color:white;">City</b>
		<input type="radio" onchange="hideCity(this)" name="choice"> <b style="color:white;">Location(Lat./Long.)</b>
		</span>
	</div>
	<div id="title"><h1><%=city.getCity() %></h1></div>
		<table id="Table" style="width:60%">
  		<tr id="row1">
    		<th><img id="imgLoc" src="image/planet-earth.png" alt="earth" onclick="detail1(this)"></img>
    		<h1 id="location" onclick="img1(this)" style="visibility:hidden"><%=Location %></h1>
    		<br><p>Location</p></th>
    		<th><img id="imgflake"src="image/snowflake.png" alt="flake" onclick="detail2(this)" ></img>
    		<h1 id="DayLow" onclick="img2(this)" style="visibility:hidden"><%=TempLow %></h1>
    		<br><p>Temp Low</p></th> 
    		<th><img id="imgsun"src="image/sun.png" alt="sun" onclick="detail3(this)"></img>
    		<h1 id="DayHigh" onclick="img3(this)"style="visibility:hidden"><%=TempHigh %></h1>
    		<br><p>Temp High</p></th>
    		<th><img id="imgwind"src="image/wind.png" alt="wind" onclick="detail4(this)"></img>
    		<h1 id="Wind" onclick="img4(this)"style="visibility:hidden"><%=Wind %></h1>
    		<br><p>Wind</p></th>
  		</tr>
  		<tr id="row2">
   			 <td><img id="imgdrop"src="image/drop.png" alt="drop" onclick="detail5(this)"></img>
   			 <h1 id="Humidity" onclick="img5(this)"style="visibility:hidden"><%=Humidity %></h1>
   			 <br><p>Humidity</p></td>
   		 	 <td><img id="imgCor" src="image/LocationIcon.png" alt="Coordinates" onclick="detail6(this)"></img>
   		 	 <h1 id="Coordinates" onclick="img6(this)"style="visibility:hidden"><%=Coordinates %></h1>
   		 	 <br><p>Coordinates</p></td> 
   		 	 <td><img id="imgmet" src="image/thermometer.png" alt="meter" onclick="detail7(this)"></img>
   		 	 <h1 id="CurrTemp" onclick="img7(this)"style="visibility:hidden"><%=CurrTemp %></h1>
   		 	 <br><p>Curent Temp</p></td>
   		 	 <th><img id="imgsunrise" src="image/sunrise-icon.png" alt="sunrise" onclick="detail8(this)"></img>
   		 	 <h1 id="Sunrise/set" onclick="img8(this)"style="visibility:hidden"><%=Sunrise %></h1>
   		 	 <br><p>Sunrise/set</p></th>
 		</tr>
	</table>
	<div id="googleMap"></div>
	<script>
	function myMap() {
	var mapProp= {
	  center:new google.maps.LatLng(51.508742,-0.120850),
	  zoom:5,
	};
	var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	google.maps.event.addListener(map, 'mouseout', function(event) {
		  placeMarker(map, event.latLng);
		});
	google.maps.event.addListener(map, 'click', function(event) {
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
	<script>
	function detail1(x){
		     x.style.visibility = "hidden";
		     document.getElementById("location").style.visibility = "visible";
	}
	function img1(x){
			x.style.visibility = "hidden";
		    document.getElementById("imgLoc").style.visibility = "visible";
	}
	function detail2(x){
	     x.style.visibility = "hidden";
	     document.getElementById("DayLow").style.visibility = "visible";
	}
	function img2(x){
		x.style.visibility = "hidden";
	    document.getElementById("imgflake").style.visibility = "visible";
	}
	function detail3(x){
    x.style.visibility = "hidden";
    document.getElementById("DayHigh").style.visibility = "visible";
	}
	function img3(x){
	x.style.visibility = "hidden";
   document.getElementById("imgsun").style.visibility = "visible";
	}
	function detail4(x){
    x.style.visibility = "hidden";
    document.getElementById("Wind").style.visibility = "visible";
	}
	function img4(x){
	x.style.visibility = "hidden";
   document.getElementById("imgwind").style.visibility = "visible";
	}
	function detail5(x){
    x.style.visibility = "hidden";
    document.getElementById("Humidity").style.visibility = "visible";
	}
	function img5(x){
	x.style.visibility = "hidden";
   	document.getElementById("imgdrop").style.visibility = "visible";
	}
	function detail6(x){
    x.style.visibility = "hidden";
    document.getElementById("Coordinates").style.visibility = "visible";
	}
	function img6(x){
	x.style.visibility = "hidden";
   document.getElementById("imgCor").style.visibility = "visible";
	}
	function detail7(x){
    x.style.visibility = "hidden";
    document.getElementById("CurrTemp").style.visibility = "visible";
	}
	function img7(x){
	x.style.visibility = "hidden";
   document.getElementById("imgmet").style.visibility = "visible";
	}
	function detail8(x){
    x.style.visibility = "hidden";
    document.getElementById("Sunrise/set").style.visibility = "visible";
	}
	function img8(x){
	x.style.visibility = "hidden";
   document.getElementById("imgsunrise").style.visibility = "visible";
	}
	
	
	</script>
</html>