<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html>
  <head>
  <meta charset="UTF-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
	$(document).ready(function(){
		$("#username").val(" ");
		  $("#password").val("");
		  $("#msg").text("");
	  	});
  </script>
  <title>Log in</title>
  <% String errormsg = (String)request.getAttribute("errorMSG");
  System.out.println(errormsg + request.getParameter("username"));
  	if(errormsg != null && errormsg.length() > 0){%>
  <script>
  $(document).ready(function(){
	 	$("#msg").text("<%=errormsg%>");
	  	});
  </script>
<% }%>
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
  	height:400px;
  	width:500px;
  	background: rgba(255,255,255,0.4);
  	border-radius: 10px;
  	position: absolute;
	top:0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
  	text-align: center;
  	}
  	#key{
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
  	#button{
  	position:relative;
  	top:30px;
  	text-align: center;
  	border-radius:20px;
  	background-color:#FEA347;
 	border: none;
  	color: white;
  	width:80px;
  	height:40px;
  	font-size: 24px;
  	}
  	#msg{
  	position:relative;
  	top:10px;
  	left:-130px;
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
	 	<img id="key" alt="key" src="image/Key.png">
	 	<form action = "login_manage" method = post>
	 	<b id="b1">Username</b><br>
		<input id= "username" type="text" name="username" value="" onfocus="this.value=''" ><br>
		<b id="b2">Password</b><br>
		<input id="password" type="password" name="password" value= '' /><br>
		<b id="msg"></b><br>
		<input id="button" type="submit" name="login" value="login" >
		</form>
	 </div>
    </body>
</html>