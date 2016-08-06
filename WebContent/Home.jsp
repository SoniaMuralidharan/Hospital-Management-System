<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/JavaScript">
history.pushState(null, null, document.title);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.title);
});
</script>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="Script/scrip.css" type="text/css">
</head>
<body background="image/bg.jpg" style=" background-repeat: no-repeat;background-size:cover;  ">
<div style="background-color:navy; text-align: center; height:10%; width:100%; color: white; font-weight: bold;">
<form method="post" action="LoginController" >
<table>
<tr>
<td><img src="image/Logo4.png" style="left: 0; top:5%; height: 70%;"></td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp</td>
<td>UserName :</td><td><input type="text" name="UserName" placeholder="Enter the username"></td>
<td>Password :</td><td><input type="password" name="Password" placeholder="Password"></td>
<td><input type="submit" value="Login"></td>
<td><input type="reset" value="Reset"></td>
</tr>
</table>
</form>
</div>

<%
String errMsg="";
if(request.getAttribute("errMsg")!=null){
	errMsg=(String)request.getAttribute("errMsg");
}
%>

<ul class="tab">
  <li><a href="Home.jsp">Home</a></li>
  <li><a href="About.html">About</a></li>
</ul>
<div style='position: fixed; top: 10%; right: 2%;'>
		<table border='5' style="background-color: navy;">
			<tr>
				<td><h4 style='color:white;'><%=errMsg%></h4></td>
			</tr>
		</table>
	</div>
<div style="background-color:navy; text-align: center; font-weight:bold; color:white; height:5%; position: absolute; bottom: 0px; width: 100%">
@Copyright 2016-2017
</div>
</body>
</html>