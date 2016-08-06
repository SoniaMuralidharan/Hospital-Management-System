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
<title>Add Physician</title>
<link rel="stylesheet" href="Script/scrip.css" type="text/css">
</head>
<body background="image/pattern.jpg">
	<div height="25%">
		<%@include file="Header.html"%>
	</div>
	<%
		if (request.getAttribute("found") == null) {
			response.sendRedirect("AddPhysicianController");
		}

		List<String> errorList = new ArrayList<String>();
		for (int i = 0; i < 7; i++) {
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
	<center>
		<h1 style="color: white; background-color: #610B21;">PHYSICIAN
			ENROLLMENT</h1>
	</center>
	<hr>
	<table>
		<tr>
			<td width="30%"><img src="image/addphysician.png" height="100%"
				width="100%"></td>
			<td width="70%">
				<form method='post' action='AddPhysicianController'>
					<table align='center' cellspacing='10'
						style="background-color: #F8E4CC" width=90%>
						<tr>
							<td class="field">Physician First Name* :</td>
							<td><input type='text' name='physicianFirstName' placeholder='Physician First Name'
								style='height: 25px; width: 200px;' maxlength=75>
							</td>
							<td><span class="err"><%=errorList.get(0)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Physician Last Name* :</td>
							<td><input type='text' name='physicianLastName' placeholder='Physician Last Name'
								style='height: 25px; width: 200px;'   maxlength=75>
							</td>
							<td><span class="err"><%=errorList.get(1)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Department Name* :</td>
							<td><select name='physicianDepartmentName'
								style='height: 25px; width: 200px;'>
									<option value="-"><--SELECT--></option>
									<%
										for (String name : departmentList) {
									%>
									<option value="<%=name%>"><%=name%></option>
									<%
										}
									%>
							</select></td>
							<td><span class="err"><%=errorList.get(2)%></span></td>
						</tr>

						<tr>
							<td class="field">Educational Qualification* :</td>
							<td><input type='text' name='physicianQualification' placeholder='Educational Qualification'
								style='height: 25px; width: 200px;'   maxlength=100>
							</td>
							<td><span class="err"><%=errorList.get(3)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Years of Experience* :</td>
							<td><input type='text' name='physicianExperience' placeholder='Years Of Experience'
								style='height: 25px; width: 200px;'   maxlength=2>
							</td>
							<td><span class="err"><%=errorList.get(4)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">State* :</td>
							<td><select name='physicianState'
								style='height: 25px; width: 200px;'>
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
							<td><span class="err"><%=errorList.get(5)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Insurance Plan :</td>
							<td><select name='physicianInsurancePlan'
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
							<td class="field">Shift Timing* :</td>
							<td><select name='Shift' style='height: 25px; width: 200px;'>
									<option value="-"><--SELECT--></option>
									<option value="Normal">Normal Shift: 9 a.m.-6 p.m.</option>
									<option value="Morning">Morning Shift: 7 a.m.-2 p.m.</option>
									<option value="Evening">Evening Shift: 2 p.m.-10 p.m.</option>
									<option value="Night">Night Shift: 10 p.m.-4 a.m.</option>
							</select>
							</td>
							<td><span class="err"><%=errorList.get(6)%></span>
							</td>
						</tr>
						<tr>
							<td><input type='RESET' name='physicianRegister'
								value='Reset' class="button">&nbsp&nbsp&nbsp&nbsp&nbsp <input type='submit'
								name='patientRegister' value='Register' class="button">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>

	<%
		String errMsg = "";
		if (request.getAttribute("errMsg") != null) {
			errMsg = (String) request.getAttribute("errMsg");
		}
	%>

	<div style='position: fixed; top: 40%; right: 2%;'>
		<table border='5'>
			<tr>
				<td><h4 style='color: maroon;'><%=errMsg%></h4>
				</td>
			</tr>
		</table>
	</div>
	
	<hr>
	<u><center><h3>INSTRUCTIONS</h3></center></u>
	<ul type="disc">
	<li>Profile cannot be created for already registered physician.
	<li><b>First name</b> can contain only alphabets and space. <u>Ex:</u>
					Rakesh Sharma
	<li><b>Last name</b> can contain only alphabets and space. <u>Ex:</u>
					Rama Rao
	<li><b>Educational Qualification</b> can contain only alphabets and
					space. <u>Ex:</u> Bachelor of Surgery
	<li><b>Years Of Experience</b> must not be 0.
	</ul>
	
	<div
		style="background-color: navy; text-align: center; font-weight: bold; color: white; height: 5%; position: relative; bottom: 0px; top: 10px; width: 100%">
		@Copyright 2016-2017</div>

</body>
</html>