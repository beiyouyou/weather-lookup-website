<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="WeatherReader.*,java.util.List, java.util.Collections, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<%HttpSession ses = request.getSession();
	String account = (String)ses.getAttribute("Account");
	System.out.println("result page session:" + account);
	%>
	<script>
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
	$(document).ready(function(){
	 	 $("#titlelogo").click(function(){
	 		window.location.href = "index.jsp";
	    	
	   	 });
	  	});
	</script>
	<%String result = (String)request.getAttribute("choice"); 
	List<Weather> cities = new ArrayList<>();
	//Collections.sort(cities, new SortbyA_Z());
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
  	 #map{
  	position:relative;
  	top:9px;
  	border-radius: 10%;
  	margin-left: 10px;
  	width:auto;
  	height: 32px;
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
  	font-family: Light;
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
  	#TableBox{
  	overflow-y:auto;
  	height:60%;
  	max-height:60%;
  	}
  	table{
  	border-spacing: 0;
  	background: rgba(255,255,255,0.2);
  	margin-left:5%;
  	border-radius: 10px;
  	border: 1px solid white;
  	}
  	th, td {
  		border-bottom: 1px solid #ddd;
	}
  	tr {
  	height: 55px;
  	text-align:center;
  	color:white;
  	font-size:25px;
	}
	input[type="submit"]{
	color:white;
	border: none;
  	background-color: inherit;
	font-size:25px;
	}
	#googleMap{
  	visibility:hidden;
  	position:absolute;
  	left:20%;
  	width:60%;
  	height:400px;
  	margin-top: -800px;
  	}
  	</style>
	
<meta charset="UTF-8">
<title>Result Page</title>
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
				<input id= "lat" type="text" name="Latitude" value="Latitude" onfocus="this.value=''">
				<input id = "long" type="text" name="Longitude" value="Longitude" onfocus="this.value=''">
				<input type="image" src="image/magnifying_glass.jpg" alt="Submit" />
				<img id="map" src="image/MapIcon.png" alt="map" />
			</form>
		</div>
		<span class="radioClass">
		<input type="radio" onchange="hideLoc(this)" name="choice" checked> <b style="color:white;">City</b>
		<input type="radio" onchange="hideCity(this)" name="choice"> <b style="color:white;">Location(Lat./Long.)</b>
		</span>
	</div>
	<div id="title" style="visibility:hidden"><h1 id="title2">All Cities</h1></div>
	<div id="TableBox">
	<table id="Table" style="width:60%">
  		<tr>
    		<th>City Name</th>
    		<th>Temp.Low</th> 
    		<th>Temp.High</th>
  		</tr>
  		<tr>
   			 <td></td>
   		 	 <td></td> 
   		 	 <td></td>
 		</tr>
 		<tr>
  	  		<td></td>
    		<td></td> 
    		<td></td>
  		</tr>
  		<tr>
  			<td></td>
    		<td></td> 
    		<td></td>
  		</tr>
  		<tr>
  			<td> </td>
    		<td> </td> 
    		<td> </td>
  		</tr>
  		<tr>
  			<td> </td>
    		<td> </td> 
    		<td> </td>
  		</tr>
  		<tr>
  			<td> </td>
    		<td> </td> 
    		<td> </td>
  		</tr>
  		<tr>
  			<td> </td>
    		<td> </td> 
    		<td> </td>
  		</tr>
	</table>
	</div>
	<div id="selectBox" style="visibility:hidden">
	<h2>Sort by:</h2>
	<select id="sorting" onchange="sortFunction()" >
  		<option value="0">City Name A-Z</option>
 	 	<option value="1">City Name Z-A</option>
  		<option value="2">Temp.Low ASC</option>
  		<option value="3">Temp.Low DESC</option>
  		<option value="4">Temp.high ASC</option>
  		<option value="5">Temp.high DESC</option>
	</select>
	</div>
	<div id="googleMap"></div>
	<script>
	$(document).ready(function(){
 	 $("#map").click(function(){
 		$("#googleMap").css("visibility","visible");
    	
   	 });
  	});
	</script>
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
	
	<script>
	<%
	Weather city = (Weather)request.getSession().getAttribute("city");
	System.out.println("table: " + city);
	if(city!= null){%>
	var x = document.getElementById("Table").rows[1].cells;
	var form = document.createElement("FORM");
	form.setAttribute("id", "0");
	x[0].appendChild(form);

	var y = document.createElement("INPUT");
	 y.setAttribute("type", "submit");
	 y.setAttribute("name", "detailCity");
	 y.setAttribute("value", "<%=city.getCity()%>");
	document.getElementById("0").appendChild(y);
	x[1].innerHTML = "<%=city.getDayLow()%>";
	x[2].innerHTML = "<%=city.getDayHigh()%>";
	<%}
	else if(city == null){%>
		document.getElementById("title2").innerHTML="No city matches the search";
		document.getElementById("title2").style.visibility="visible";
		document.getElementById("Table").style.visibility="hidden";
	<%}%>
	</script>
	
	
	
	
	
	
	
	</body>
</html>