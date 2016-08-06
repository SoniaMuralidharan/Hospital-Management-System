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
<title>Physician Search</title>
<link rel="stylesheet" href="Script/scrip.css" type="text/css">
</head>
<body background="image/pattern.jpg">
	<div height="25%">
		<%@include file="Header.html"%>
	</div>
	<%
		if (request.getAttribute("found") == null) {
			response.sendRedirect("PhysicianSearchController");
		}

		List<String> errorList = new ArrayList<String>();
		for (int i = 0; i < 1; i++) {
			errorList.add("");
		}
		if (request.getAttribute("errorList") != null) {
			errorList = (ArrayList<String>) request
					.getAttribute("errorList");
		}

		List<String> insuranceList = new ArrayList<String>();
		if (session.getAttribute("insuranceList") != null) {
			insuranceList = (ArrayList<String>) session
					.getAttribute("insuranceList");
		}

		List<String> stateList = new ArrayList<String>();
		if (session.getAttribute("stateList") != null) {
			stateList = (ArrayList<String>) session
					.getAttribute("stateList");
		}

		List<String> departmentList = new ArrayList<String>();
		if (session.getAttribute("departmentList") != null) {
			departmentList = (ArrayList<String>) session
					.getAttribute("departmentList");
		}
	%>
	<%
		String errMsg = "";
		if (request.getAttribute("errMsg") != null) {
			errMsg = (String) request.getAttribute("errMsg");
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
	<h3 align="right">
		Welcome
		<%=session.getAttribute("UserName")%>
		!!
	</h3>
	<center>
		<h1 style="color: white; background-color: #610B21;">PHYSICIAN
			SEARCH</h1>
	</center>
	<hr>
	<form method='post' action='PhysicianSearchController'>
		<table align='center' cellspacing='10'
			style="background-color: #F8E4CC" width=50%>
			<tr>
				<td class="field">Sorting : (Optional)</td>
				<td><select name='Sort' style='height: 25px; width: 200px;'>
						<option value="-"><--SELECT--></option>
						<option value="First Name">First Name</option>
						<option value="Last Name">Last Name</option>
				</select></td>
			</tr>
		</table>
		<br>
		<br>
		<table align='center' cellspacing='10'
			style="background-color: #F8E4CC" width=50%>
			<tr>
				<td class="field">State :</td>
				<td><select name='State' style='height: 25px; width: 200px;'>
						<option value="-"><--SELECT--></option>
						<%
							for (String name : stateList) {
						%>
						<option value="<%=name%>"><%=name%></option>
						<%
							}
						%>
				</select>
				</td>
				<td><span class="err"><%=errorList.get(0)%></span>
				</td>
			</tr>
			<tr>
				<td class="field">Insurance Plan :</td>
				<td><select name='InsurancePlan'
					style='height: 25px; width: 200px;'>
						<option value="-"><--SELECT--></option>
						<%
							for (String plan : insuranceList) {
						%>
						<option value="<%=plan%>"><%=plan%></option>
						<%
							}
						%>
				</select>
				</td>
			</tr>

			<tr>
				<td class="field">Department Name :</td>
				<td><select name='departmentName'
					style='height: 25px; width: 200px;'>
						<option value="-"><--SELECT--></option>
						<%
							for (String name : departmentList) {
						%>
						<option value="<%=name%>"><%=name%></option>
						<%
							}
						%>
				</select>
				</td>
			</tr>

			<tr>
				<td class="field">Shift Timing :</td>
				<td><select name='ShiftTimings'
					style='height: 25px; width: 200px;'>
						<option value="-"><--SELECT--></option>
						<option value="Normal">Normal Shift: 9 a.m.-6 p.m.</option>
						<option value="Morning">Morning Shift: 7 a.m.-2 p.m.</option>
						<option value="Evening">Evening Shift: 2 p.m.-10 p.m.</option>
						<option value="Night">Night Shift: 10 p.m.-4 a.m.</option>
				</select></td>
			</tr>

			<tr>
				<td colspan='2'><input type='submit' name='Search'
					value='Search' class="button"></td>
			</tr>
		</table>
	</form>

	<div style='position: fixed; top: 40%; right: 2%;'>
		<table border='5'>
			<tr>
				<td><h4 style='color: maroon;'><%=errMsg%></h4></td>
			</tr>
		</table>
	</div>
	
	<hr>
	<u><center><h3>INSTRUCTIONS</h3></center></u>
	<ul type="disc">
	<li>Search can be based upon any of the mentioned criteria.<br>
			<u>Ex:</u> <br><b>Shift Timings :</b> Morning Shift: 7 a.m.-2 p.m.
			<br><br>
			<b>State :</b> Mizoram	<br> <b>Department Name :</b> Nephrology
			<br><br>
			<b>State :</b> TamliNadu <br> <b>Insurance Plan :</b> Religare Health Insurance <br> <b>Department Name :</b> Critical Care
			<br><br>
			<b>State :</b> Kerala <br> <b>Insurance Plan :</b> L & T Health Insurance <br> <b>Department Name :</b> Endoscopy <br> <b>Shift Timings :</b> Morning Shift: 7 a.m.-2 p.m.
	</ul>
	<div
		style="background-color: navy; text-align: center; font-weight: bold; color: white; height: 5%; position:relative ; bottom: 0px; width: 100%">
		@Copyright 2016-2017</div>

</body>
</html>