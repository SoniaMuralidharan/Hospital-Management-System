<%@page import="com.hms.model.PatientTO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

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
<title>Success !</title>
<link rel="stylesheet" href="Script/scrip.css" type="text/css">
</head>
<body background="image/pattern.jpg">
<div height="25%">
		<%@include file="Header.html"%>
	</div>
<ul class="tab">
  <li><a href="EnrollPatient.jsp">Enroll Patient</a></li>
  <li><a href="AddPhysician.jsp">Add Physician</a></li>
  <li><a href="PhysicianSearch.jsp">Search Physician</a></li>
   <li><a href="PatientDiagnosis.jsp">Patient Diagnosis Details</a></li>
  <li><a href="PatientHistory.jsp">Patient History</a></li>
</ul>
<h3 align="right">
		Welcome
		<%=session.getAttribute("UserName")%>
		!!
	</h3>
	<hr>
<br>
<center>
<h1>Registration Successfull !!! ...</h1> 

<br>
<table style="width: 467px; height: 301px;color: white;font-size: large; text-align: center;" background="image/card.png" >
<tr>
<th>Patient Id : <%=session.getAttribute("patientId")%></th>
</tr>
</table>
</center>

<br><br>
<div
		style="background-color: navy; text-align: center; font-weight: bold; color: white; height: 5%; position:relative; ; bottom: 0px; width: 100%">
		@Copyright 2016-2017</div>

</body>
</html>