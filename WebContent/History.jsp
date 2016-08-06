<%@page import="com.hms.model.HistoryTO"%>
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
<script type="text/javascript">
	function gotoExcel(elemId, frmFldId) {
		var obj = document.getElementById(elemId);
		var oFld = document.getElementById(frmFldId);
		oFld.value = obj.innerHTML;

	}
</script>
</head>
<body background="image/pattern.jpg">

	<div height="25%">
		<%@include file="Header.html"%>
	</div>

	<ul class="tab">
		<li><a href="EnrollPatient.jsp">Enroll Patient</a>
		</li>
		<li><a href="AddPhysician.jsp">Add Physician</a>
		</li>
		<li><a href="PhysicianSearch.jsp">Search Physician</a>
		</li>
		<li><a href="PatientDiagnosis.jsp">Patient Diagnosis Details</a>
		</li>
		<li><a href="PatientHistory.jsp">Patient History</a>
		</li>
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
		<div id="tableData">

			<table border="5" cellspacing="2">
				<tr>
					<th>Id</th>
					<th>Patient ID</th>
					<th>Symptoms</th>
					<th>Diagnosis Provided</th>
					<th>Administered By</th>
					<th>Date of Diagnosis</th>
					<th>Follow-up required</th>
					<th>Date of follow-up</th>
					<th>Bill Amount</th>
					<th>Card Number</th>
					<th>Payment Mode</th>
				</tr>
				<%
					HistoryTO patientHistoryTo = new HistoryTO();
					ArrayList<HistoryTO> pl = (ArrayList<HistoryTO>) request
							.getAttribute("plist");
					if (pl.size() == 0) {
				%>
				<h3>No records found !</h3>
				<%
					} else {
						for (int i = 0; i < pl.size(); i++) {
							patientHistoryTo = pl.get(i);
				%>
				<tr>
					<td><%=patientHistoryTo.getId()%></td>
					<td><%=patientHistoryTo.getPatient_id()%></td>
					<td><%=patientHistoryTo.getSymptoms()%></td>
					<td><%=patientHistoryTo.getDiagnosis()%></td>
					<td><%=patientHistoryTo.getAdministered_by()%></td>
					<td><%=patientHistoryTo.getDate_of_diagnosis()%></td>
					<td><%=patientHistoryTo.getFollow_up_req()%></td>
					<td><%=patientHistoryTo.getDate_of_follow_up()%></td>
					<td><%=patientHistoryTo.getBill_amount()%></td>
					<td><%=patientHistoryTo.getCard_number()%></td>
					<td><%=patientHistoryTo.getPayment_mode()%></td>
					<%
						}
						}
					%>
				</tr>
			</table>
<br><br>
			
		</div>
		
		<form action="ExportToExcel.jsp">
				<input type="hidden" id="tableHTML" name="tableHTML" value="" /> <input
					type="hidden" id="fileName" name="fileName"
					value="<%=patientHistoryTo.getPatient_id()%>" /> <input
					type="submit" onclick="gotoExcel('tableData', 'tableHTML');"
					value="Export to Excel"  class="button1"/>
			</form>
	</center>
	<div
		style="background-color: navy; text-align: center; font-weight: bold; color: white; height: 5%; position: absolute; bottom: 0px; width: 100%">
		@Copyright 2016-2017</div>

</body>
</html>