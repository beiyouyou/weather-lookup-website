<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="weatherReader.Weather, weatherReader.WeatherReader,java.util.List" %>
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
	<%String result = (String)request.getAttribute("choice"); 
	WeatherReader w = new WeatherReader();
	String path = getServletContext().getRealPath("/weather.txt");
	w.parseFile("weather.txt", path);
	List<Weather> cities = w.getCities();
	%>
	<style type="text/css">
	img.background{
	width: 100%;
  	height: 100%;
  	position: absolute;
  	left: 0px;
  	top: 0px;
  	z-index: -1;
  	filter: blur(5px);
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
  	table{
  	border-spacing: 0;
  	background: rgba(255,255,255,0.2);
  	margin-left:5%;
  	margin-top:5%;
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
  	</style>
	
<meta charset="UTF-8">
<title>Result Page</title>
</head>
  <body>
	<img class="background" src="image/background.jpg" >
	<div class="header">
		<a href="MainPage.jsp" >WeatherMeister</a>
		<div id= "SearchBox">
			<form action = "Backend" method = get>
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
		<span class="radioClass">
		<input type="radio" onchange="hideLoc(this)" name="choice" checked> <b style="color:white;">City</b>
		<input type="radio" onchange="hideCity(this)" name="choice"> <b style="color:white;">Location(Lat./Long.)</b>
		</span>
	</div>
	<%if(result.equals("displayAll")){ %>
	<div><h1>All Cities</h1></div>
	<%} %>
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
	<script>
	<% if(result.equals("displayAll")){
	%>
	var index = 0;
	<%for(int i = 0; i <cities.size(); i++){%>
	var x = document.getElementById("Table").rows[index +1].cells;
	x[0].innerHTML = "<%=cities.get(i).getCity()%>";
	x[1].innerHTML = "<%=cities.get(i).getDayLow()%>";
	x[2].innerHTML = "<%=cities.get(i).getDayHigh()%>";
	index++;
	<%}
	}
	else if(result.equals("city")){
	Weather city1 = w.findCity((String)request.getParameter("cityname"));
	if(city1!= null){%>

	var x = document.getElementById("Table").rows[1].cells;
	x[0].innerHTML = "<%=city1.getCity()%>";
	x[1].innerHTML = "<%=city1.getDayLow()%>";
	x[2].innerHTML = "<%=city1.getDayHigh()%>";
	<%}
	}
	else if(result.equals("location")){
	double latitude = Double.parseDouble(request.getParameter("Latitude"));
	double longitude = Double.parseDouble(request.getParameter("Longitude"));
	Weather city2 = w.findCity(latitude, longitude);%>
	var x = document.getElementById("Table").rows[1].cells;
	x[0].innerHTML = "<%=city2.getCity()%>";
	x[1].innerHTML = "<%=city2.getDayLow()%>";
	x[2].innerHTML = "<%=city2.getDayHigh()%>";
	<%}
	%>
	</script>
	
	
	
	
	
	
	
	</body>
</html>