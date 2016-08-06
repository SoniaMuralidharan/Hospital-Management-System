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
<title>Patient History</title>
<link rel="stylesheet" href="Script/scrip.css" type="text/css">
<script type="text/javascript" language="JavaScript">
	function radioWithText(d) {
		document.getElementById('patientId').style.display = "none";
		document.getElementById('FNLN').style.display = "none";
		document.getElementById(d).style.display = 'inline';
	}
</script>
</head>
<body background="image/pattern.jpg">
	<div height="25%">
		<%@include file="Header.html"%>
	</div>

	<%
		List<String> errorList = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			errorList.add("");
		}
		if (request.getAttribute("errorList") != null) {
			errorList = (ArrayList<String>) request
					.getAttribute("errorList");
		}
	%>

	<ul class="tab">
		<li><a href="EnrollPatient.jsp">Enroll Patient</a></li>
		<li><a href="AddPhysician.jsp">Add Physician</a></li>
		<li><a href="PhysicianSearch.jsp">Search Physician</a></li>
		<li><a href="PatientDiagnosis.jsp">Patient Diagnosis Details</a>
		</li>
		<li><a href="PatientHistory.jsp">Patient History</a></li>
	</ul>

	<%
		String errMsg = "";
		if (request.getAttribute("errMsg") != null) {
			errMsg = (String) request.getAttribute("errMsg");
		}
	%>
	
	<h4 style='color: maroon;'><%=errMsg%></h4>
	<h3 align="right">
		Welcome
		<%=session.getAttribute("UserName")%>
		!!
	</h3>
	<center>
		<h1 style="color: white; background-color: #610B21;">PATIENT
			HISTORY</h1>

		<hr>
		<span class="err"><%=errorList.get(0)%></span><br>
		<span class="err"><%=errorList.get(1)%></span><br>
		<span class="err"><%=errorList.get(2)%></span>
		
		<form method='post' action='PatientHistoryController' style="background-color: #F8E4CC; width: 50%" class="field">


			<p align="left"><input type="radio" value="chkPatientId" name='chkPatientId'
				id="chkPatientId" onclick="javascript:radioWithText('patientId')"
				checked="checked" >Search through Patient Id <br>
			
			<div id="patientId" style="display: visible;">
				Patient ID : <input type='text' name='PatientId'
					style='height: 25px; width: 200px;' placeholder='Patient Id'  maxlength=10> 

			</div>


			(Or)
			<br><br>
			 <p align="left"><input type="radio" value="chkPatientFNLN"
				name='chkPatientId' id="chkPatientId"
				onclick="javascript:radioWithText('FNLN')" unchecked>First Name & Last Name <br>
			<br>
			<div id="FNLN" style="display: none;">

				First Name : <input type='text' name='firstName' id="firstName"
					style='height: 25px; width: 200px;'  placeholder='First Name'  maxlength=75>
				<br>
				<br> Last Name : <input type='text' name='lastName'
					id="lastName" style='height: 25px; width: 200px;'  placeholder='Last Name'  maxlength=75> 

			</div>

			<br>
			<br>
			<input type='submit' name='patientRegister' value='Register' class="button">
		</form>
		
		<div style='position: fixed; top: 40%; right: 2%;'>
		<table border='5'>
			<tr>
				<td><h4 style='color: maroon;'><%=errMsg%></h4></td>
			</tr>
		</table>
	</div>
	
	</center>
	<br><br>
	<hr>
	<u><center><h3>INSTRUCTIONS</h3></center></u>
	<ul type="disc">
	<li><b>Profile Id</b> must be already registered.
	<li><b>First name</b> can contain only alphabets and space. <u>Ex:</u>
					Rakesh Sharma
	<li><b>Last name</b> can contain only alphabets and space. <u>Ex:</u>
					Rama Rao
	</ul>
	
	<div
		style="background-color: navy; text-align: center; font-weight: bold; color: white; height: 5%; position:relative; ; bottom: 0px; width: 100%">
		@Copyright 2016-2017</div>

</body>
</html>