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
<title>Enroll Patient</title>
<link rel="stylesheet" href="Script/scrip.css" type="text/css">
<script type="text/javascript">
	function ShowHideDiv() {
		var chkYes = document.getElementById("yes");
		var spouseName = document.getElementById("SpouseName");
		var spouseAge = document.getElementById("SpouseAge");
		var NoOfChildren = document.getElementById("NoOfChildren");
		var ChildrenName1 = document.getElementById("ChildrenName1");
		var ChildrenName2 = document.getElementById("ChildrenName2");
		spouseName.style.display = chkYes.checked ? "block" : "none";
		spouseAge.style.display = chkYes.checked ? "block" : "none";
		NoOfChildren.style.display = chkYes.checked ? "block" : "none";
		ChildrenName1.style.display = chkYes.checked ? "block" : "none";
		ChildrenName2.style.display = chkYes.checked ? "block" : "none";
	}
</script>
</head>
<body background="image/pattern.jpg">
	<div height="25%">
		<%@include file="Header.html"%>
	</div>
	<%
		if (request.getAttribute("found") == null) {
			response.sendRedirect("EnrollPatientController");
		}

		List<String> errorList = new ArrayList<String>();
		for (int i = 0; i < 15; i++) {
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
		<h1 style="color: white; background-color: #610B21;">PATIENT
			ENROLLMENT</h1>
	</center>
	<hr>
	<table>
		<tr>
			<td width="35%"><img src="image/cartoon-doctor.png"
				height="80%" width="80%">
			</td>
			<td width="70%">
				<form method='post' action='EnrollPatientController'>
					<table align='center' cellspacing='20'
						style="background-color: #F8E4CC" width=80%>
						<tr>
							<td class="field">First Name* :</td>
							<td><input type='text' name='FirstName' placeholder='First Name'
								style='height: 25px; width: 200px;' maxlength=75></td>
							<td><span class="err"><%=errorList.get(0)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Last Name* :</td>
							<td><input type='text' name='LastName' placeholder='Last Name'
								style='height: 25px; width: 200px;'  maxlength=75></td>
							<td><span class="err"><%=errorList.get(1)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Password* :</td>
							<td><input type='password' name='Password' placeholder='Password'
								style='height: 25px; width: 200px;'  maxlength=20></td>
							<td><span class="err"><%=errorList.get(2)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Date Of Birth* :</td>
							<td><input type='text' name='DateOfBirth' placeholder='Date Of Birth'
								style='height: 25px; width: 200px;'  maxlength=11></td>
							<td><span class="err"><%=errorList.get(3)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Email Address* :</td>
							<td><input type='text' name='EmailAddress' placeholder='Email Address'
								style='height: 25px; width: 200px;'  maxlength=30></td>
							<td><span class="err"><%=errorList.get(4)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Contact Number* :</td>
							<td><input type='text' name='ContactNumber' placeholder='Contact Number'
								style='height: 25px; width: 200px;'  maxlength=10></td>
							<td><span class="err"><%=errorList.get(5)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Father Name* :</td>
							<td><input type='text' name='FatherName' placeholder='Father Name'
								style='height: 25px; width: 200px;' maxlength=75></td>
							<td><span class="err"><%=errorList.get(6)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Mother Name* :</td>
							<td><input type='text' name='MotherName' placeholder='Mother Name'
								style='height: 25px; width: 200px;' maxlength=75></td>
							<td><span class="err"><%=errorList.get(7)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Patient's Current Weight* :</td>
							<td><input type='text' name='PatientCurrentWeight' placeholder='Patient Current Weight'
								style='height: 25px; width: 200px;' maxlength=3></td>
							<td><span class="err"><%=errorList.get(8)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Marital Status* :</td>
							<td><input type="radio" value="yes" name='Married' id="yes"
								onclick="ShowHideDiv()" checked="checked">Married<input
								type="radio" value="no" name='Married' id="no"
								onclick="ShowHideDiv()">UnMarried</td>
						</tr>
						<tr>
							<td class="field">Wife/Husband Name :</td>
							<td><input type='text' name='SpouseName' placeholder='Wife/Husband Name' id='SpouseName'
								style='height: 25px; width: 200px;' maxlength=75></td>
							<td><span class="err"><%=errorList.get(9)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Age of Wife/Husband :</td>
							<td><input type='text' name='SpouseAge' placeholder='Wife/Husband Age' id='SpouseAge'
								style='height: 25px; width: 200px;' maxlength=3></td>
							<td><span class="err"><%=errorList.get(10)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">No. of Children :</td>
							<td><input type='text' name='NoOfChildren' placeholder='No. Of Children' id='NoOfChildren'
								style='height: 25px; width: 200px;' maxlength=1></td>
							<td><span class="err"><%=errorList.get(13)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Children Name(1) :</td>
							<td><input type='text' name='ChildrenName1' placeholder='Children Name1'
								id='ChildrenName1' style='height: 25px; width: 200px;' maxlength=75>
							</td>
							<td><span class="err"><%=errorList.get(11)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Children Name(2) :</td>
							<td><input type='text' name='ChildrenName2' placeholder='Children Name2'
								id='ChildrenName2' style='height: 25px; width: 200px;' maxlength=75>
							</td>
							<td><span class="err"><%=errorList.get(12)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">State* :</td>
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
							<td><span class="err"><%=errorList.get(14)%></span>
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
							<td colspan='2'><input type='submit' name='patientRegister'
								value='Register' class="button"></td>
						</tr>
					</table>
				</form></td>
		</tr>
	</table>
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
	<li>Profile cannot be created for already registered patients.
	<li><b>First name</b> can contain only alphabets and space. <u>Ex:</u>
					Rakesh Sharma
	<li><b>Last name</b> can contain only alphabets and space. <u>Ex:</u>
					Rama Rao
	<li><b>Password</b> should contain a Capital letter followed by 4 or more number of small letters, a digit and atleast one of $ & *.<br> <u>Ex:</u>
					Aabcd4$ , Zabeklomp5*, Amahalakshmi5$&* , Akumar9$&
	<li><b>Date of birth</b> must be in format DD-Mon-YYYY and must be
					before the current date. <u>Ex:</u> 28-sep-1993
	<li><b>Email id</b> cannot contain more than one '@' .
	<li><b>Contact Number</b> can consist of only 10 digits.
	<li><b>Father name</b> can contain only alphabets and space. <u>Ex:</u>
					Jon Christopher
	<li><b>Mother name</b> can contain only alphabets and space. <u>Ex:</u>
					Lydia Glady
	<li><b>Wife/Husband Name</b> can contain only alphabets and space. <u>Ex:</u>
					Nisha Murali, Rahul Verma
	<li><b>Children name 1</b> can contain only alphabets and space. <u>Ex:</u>
					Vekata Rathnam
	<li><b>Children name 2</b> can contain only alphabets and space. <u>Ex:</u>
					Guru Moorthy
	</ul>
	<div
		style="background-color: navy; text-align: center; font-weight: bold; color: white; height: 5%; position: relative; bottom: 0px; top: 10px; width: 100%">
		@Copyright 2016-2017</div>

</body>
</html>