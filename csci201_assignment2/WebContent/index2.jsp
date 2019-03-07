<%@ page language="java" session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%request.getSession().setAttribute("Account", null); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	window.location.href = "index.jsp";
 });
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img.background{
	width: 100%;
  	height: 100%;
  	position: absolute;
  	left: 0px;
  	top: 0px;
  	z-index: -1;
  	filter: brightness(60%) blur(5px);
	}</style>
</head>
<body>
<img class="background" src="image/background.jpg" >
</body>
</html>