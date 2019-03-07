<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="WeatherReader.*,java.util.List,BackEnd.*"  %>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>Insert title here</title>
	<%String account = (String)request.getSession().getAttribute("Account");
	List <String> result = validation.searchResult(account);%>
	<style>	
	@font-face{
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
  	 #profile{
  	color:white;
  	position:relative;
  	display: inline;
  	left:70%;
  	top:20px;
  	font-family: "Courier New", Courier, monospace;
 	font-size:24px;
  	color:white;
  	}
  	#signout{
  	color:white;
  	position:relative;
  	display: inline;
  	left:72%;
  	top:20px;
  	font-family: "Courier New", Courier, monospace;
  	font-size:24px;
  	color:white;
  	}
  	#searchmsg{
  	margin-top:0%;
  	font-family: "Courier New", Courier, monospace;
  	font-size:40px;
  	color:white;
  	}
  	#TableBox{
  	overflow-y:auto;
  	height:50%;
  	top:20px;
  	max-height:50%;
  	position:relative;
  	left:35%;
  	}
  	table{
  	border-spacing: 0;
  	background: rgba(255,255,255,0.2);
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
  	<script>
  	$(document).ready(function(){
  	 	 $("#searchmsg").text("<%=account%>'s Search History");
  	  	});
  	$(document).ready(function(){
 	 	 $("#weatherlogo").click(function(){
 	 		window.location.href = "index.jsp";
 	 	 });
 	  	});
  	$(document).ready(function(){
	 	 $("#signout").click(function(){
		 	 window.location.href = "index2.jsp";
	   	 });
	  	});
  	</script>
  </head>
	<body>
	  <img class="background" src="image/background.jpg" >
	  <div class="header">
		<h1 id="weatherlogo">WeatherMeister</h1>
		<h1 id="profile">Profile</h1>
		<h1 id="signout">Sign Out</h1>
	  </div>
	  <div id="searchmsg" style="text-align:center">
	  Username's Search History</div>
	  <div id="TableBox">
	  <table id="Table" style="width:30%">
  		<tr>
    		<th></th>
  		</tr>
  		<tr>
   			 <td></td>
 		</tr>
 		<tr>
  	  		<td></td>
  		</tr>
  		<tr>
  			<td></td>
  		</tr>
  		<tr>
  			<td> </td>
  		</tr>
  		<tr>
  			<td> </td>
  		</tr>
  		<tr>
  			<td> </td>
  		</tr>
  		<tr>
  			<td> </td>
  		</tr>
	</table>
	</div>
	<script>
	var index = 0;
	<%for(int i = 0; i <result.size(); i++){
		if (i>=7){%>
		var table = document.getElementById("Table");
		var row = table.insertRow(index);
		var cell1 = row.insertCell(0);
		cell1.innerHTML = "<%=result.get(i)%>";
		index++;
		<%}
		else{%>
		var x = document.getElementById("Table").rows[index].cells;
		var form = document.createElement("FORM");
		x[0].innerHTML = "<%=result.get(i)%>";
		index++;
		<%}
	}%>
	</script>
	</body>
</html>