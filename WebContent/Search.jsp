<%@page import="com.hms.model.PhysicianSearchTO"%>
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
		<li><a href="PatientDiagnosis.jsp">Patient Diagnosis Details</a>
		</li>
		<li><a href="PatientHistory.jsp">Patient History</a></li>
	</ul>
	<h3 align="right">
		Welcome
		<%=session.getAttribute("UserName")%>
		!!
	</h3>
	<hr>
	<br>
	<br>
	<center>
		<table border="5" cellspacing="2">
			<tr>
				<th>Physician Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Department Name</th>
				<th>Educational Qualification</th>
				<th>Years of experience</th>
				<th>State</th>
				<th>Insurance plan</th>
				<th>Shift</th>
			</tr>
			<%
				PhysicianSearchTO physicianSearchTo = new PhysicianSearchTO();
				ArrayList<PhysicianSearchTO> pl = (ArrayList<PhysicianSearchTO>) request
						.getAttribute("plist");
				if (pl.size() == 0) {
			%>
			<h3>No records found !</h3>
			<%
					} else {
						for (int i = 0; i < pl.size(); i++) {
						physicianSearchTo = pl.get(i);
			%>
			<tr>
				<td><%=physicianSearchTo.getPhysicianId()%></td>
				<td><%=physicianSearchTo.getPhysicianFirstName()%></td>
				<td><%=physicianSearchTo.getPhysicianLastName()%></td>
				<td><%=physicianSearchTo.getDepartmentName()%></td>
				<td><%=physicianSearchTo.getEducationalQualification()%></td>
				<td><%=physicianSearchTo.getYearsOfExcperience()%></td>
				<td><%=physicianSearchTo.getState()%></td>
				<td><%=physicianSearchTo.getInsurancePlan()%></td>
				<td><%=physicianSearchTo.getShiftTimings()%></td>
				<%
					}
					}
				%>
			</tr>
		</table>
	</center>
	<div
		style="background-color: navy; text-align: center; font-weight: bold; color: white; height: 5%; position: absolute; bottom: 0px; width: 100%">
		@Copyright 2016-2017</div>

</body>
</html>