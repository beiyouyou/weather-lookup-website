<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <% String errormsg = (String)request.getAttribute("RerrorMSG");
  	if(errormsg != null && errormsg.length() > 0){%>
  <script>
  $(document).ready(function(){
	 	$("#msg").text("<%=errormsg%>");
	  	});
  </script>
<% }%>
  <script>
  $(document).ready(function(){
	 	 $("#log").click(function(){
	 		window.location.href = "login.jsp";
	   	 });
	  	});
	$(document).ready(function(){
	 	 $("#reg").click(function(){
	 		window.location.href = "register.jsp";
	   	 });
	  	});
	$(document).ready(function(){
	 	 $("#weatherlogo").click(function(){
	 		window.location.href = "index.jsp";
	   	 });
	  	});
  </script>
  <title>register</title>
  <style>
  @font-face {
   	font-family: regular;
   	src: url(AvenirNext-UltraLight.tff);
	}
	.background{
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
  	#box{
  	width:500px;
  	height:500px;
  	text-align:center;
  	background: rgba(255,255,255,0.4);
  	border-radius: 10px;
  	position: absolute;
	top:0;
	bottom: 0;
	left: 0;
	right: 0;
  	margin: auto;
  	}
  	 #profile{
  	position:relative;
  	width:140px;
  	height:140px;
  	top:-40px;
  	}
  	#username{
  	position:relative;
  	top:-20px;
  	width:80%;
  	height:30px;
  	}
  	#password{
  	width:80%;
  	height:30px;
  	}
  	#Cpassword{
  	position:relative;
  	top:20px;
  	width:80%;
  	height:30px;
  	}
  	#b1{
  	position:relative;
  	top:-20px;
  	left:-140px;
  	font-size:20px;
  	font-family: "Courier New", Courier, monospace;
  	color:white;
  	}
  	#b2{
  	position:relative;
  	top:0px;
  	left:-140px;
  	font-size:20px;
  	font-family: "Courier New", Courier, monospace;
  	color:white;
  	}
  	#b3{
  	position:relative;
  	top:20px;
  	left:-100px;
  	font-size:20px;
  	font-family: "Courier New", Courier, monospace;
  	color:white;
  	}
  	#button{
  	position:relative;
  	top:70px;
  	text-align: center;
  	border-radius:20px;
  	background-color:#FEA347;
 	border: none;
  	color: white;
  	width:120px;
  	height:40px;
  	font-size: 24px;
  	}
  	#msg{
  	position:relative;
  	top:30px;
  	left:-100px;
  	font-size:16px;
  	color:red;
  	}
  	</style>
  </head>
    <body>
    <img class="background" src="image/background.jpg" >
	  <div class="header">
		<h1 id="weatherlogo">WeatherMeister</h1>
		<h1 id="log">Login</h1>
		<h1 id="reg">Register</h1>
	  </div>
	  <div id="box">
	  <img id="profile" alt="profile" src="image/profile.png">
	 	<form action = "reg_manage" method = get>
	 	<b id="b1">Username</b><br>
		<input id= "username" type="text" name="username" value="" onfocus="this.value=''" ><br>
		<b id="b2">Password</b><br>
		<input id="password" type="password" name="password" value="" onfocus="this.value=''"/><br>
		<b id="b3">Confirm Password</b><br>
		<input id="Cpassword" type="password" name="Cpassword" value="" onfocus="this.value=''"/><br>
		<b id="msg"></b><br>
		<input id="button" type="submit" name="login" value="Register" >
		</form>
	 </div>
    </body>
</html>