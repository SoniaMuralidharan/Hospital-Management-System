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
<title>Patient Diagnosis Details</title>
<link rel="stylesheet" href="Script/scrip.css" type="text/css">
<script type="text/javascript">
	function ShowHideDiv() {
		var chkYes = document.getElementById("yes");
		var bill = document.getElementById("billing");
		var dateOfFollowUp = document.getElementById("dateOfFollowUp");
		var billAmount = document.getElementById("billAmount");
		var cardNumber = document.getElementById("cardNumber");
		var modeOfPayment = document.getElementById("modeOfPayment");
		dateOfFollowUp.style.display = chkYes.checked ? "block" : "none";
		billAmount.style.display = bill.checked ? "block" : "none";
		cardNumber.style.display = bill.checked ? "block" : "none";
		modeOfPayment.style.display = bill.checked ? "block" : "none";
	}
</script>
</head>
<body background="image/pattern.jpg">
	<%
		String errMsg = "";
		if (request.getAttribute("errMsg") != null) {
			errMsg = (String) request.getAttribute("errMsg");
		}
	%>

	<div height="25%">
		<%@include file="Header.html"%>
	</div>

	<%
		List<String> errorList = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			errorList.add("");
		}
		if (request.getAttribute("errorList") != null) {
			errorList = (ArrayList<String>) request
					.getAttribute("errorList");
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
		<h1 style="color: white; background-color: #610B21;">PATIENT
			DIAGNOSIS DETAILS</h1>
	</center>
	<hr>
	<table>
		<tr>
			<td width="30%"><img src="image/diagnosis.png" height="50%"
				width="80%"></td>
			<td width="70%">
				<form method='post' action='PatientDiagnosisDetailsController'>
					<table align='center' cellspacing='10'
						style="background-color: #F8E4CC" width=90%>

						<tr>
							<td class="field">Patient ID* :</td>
							<td><input style='height: 25px; width: 200px;' type='text'
								name='patientId' placeholder='Patient Id' maxlength=10>
							</td>
							<td><span class="err"><%=errorList.get(0)%></span>
							</td>
						</tr>

						<tr>
							<td class="field">Symptoms* :</td>
							<td><textarea name='symptoms' placeholder='Symptoms' cols='30' rows='8' maxlength=400></textarea>
							</td>
							<td><span class="err"><%=errorList.get(1)%></span>
							</td>
						</tr>

						<tr>
							<td class="field">Diagnosis Provided* :</td>
							<td><textarea name='diagnosisProvided' placeholder='Diagnosis Provided' cols='30' rows='8' maxlength=400></textarea>
							</td>
							<td><span class="err"><%=errorList.get(2)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Administered by* :</td>
							<td><input style='height: 25px; width: 200px;' type='text'
								name='administeredBy' placeholder='Administered By' maxlength=75>
							</td>
							<td><span class="err"><%=errorList.get(3)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Date of Diagnosis* :</td>
							<td><input style='height: 25px; width: 200px;' type='text'
								name='dateOfDiagnosis' placeholder='Date Of Diagnosis' maxlength=9>
							</td>
							<td><span class="err"><%=errorList.get(4)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Follow-up Required(yes/no?)* :</td>
							<td><input type="radio" name='followUpRequired' value="yes"
								id="yes" onclick="ShowHideDiv()">Yes<input type="radio"
								name='followUpRequired' value="no" id="no"
								onclick="ShowHideDiv()" checked="checked">No</td>
						</tr>
						<tr>
							<td class="field">Date of Follow-up :</td>
							<td><input type='text' id='dateOfFollowUp'
								name='dateOfFollowUp' placeholder='Date Of Follow-Up'
								style="display: none; height: 25px; width: 200px;"  maxlength=9>
							</td>
							<td><span class="err"><%=errorList.get(5)%></span>
							</td>
						</tr>
						<tr>
							<td class="field">Bill Amount* :</td>
							<td><input type='text' id='billAmount' placeholder='Bill Amount' name='billAmount'
								style="display: none; height: 25px; width: 200px;"  maxlength=7>
							</td>
							<td><span class="err"><%=errorList.get(6)%></span>
							</td>
						</tr>

						<tr>
							<td class="field">Mode of Payment(Cash/Card)* :</td>
							<td><input
								style="display: none; height: 25px; width: 200px;" type='text'
								name='modeOfPayment' placeholder='Mode Of Payment' id='modeOfPayment'  maxlength=4>
							</td>
							<td><span class="err"><%=errorList.get(7)%></span>
							</td>
						</tr>

						<tr>
							<td class="field">Card Number :</td>
							<td><input
								style="display: none; height: 25px; width: 200px;" type='text'
								name='cardNumber' placeholder='Card Number' id='cardNumber'  maxlength=16>
							</td>
							<td><span class="err"><%=errorList.get(8)%></span>
							</td>
						</tr>

						<tr>
							<td class="field"><input type="checkbox" name='billing' id='billing'
								value='Proceed to Billing' onclick="ShowHideDiv()">Proceed
								to Billing</td>
							<td><input type='submit' name='diagnosisRegister'
								value='Register' class="button">
							</td>
						</tr>
					</table>
				</form>
			</td>
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
	<li>Diagnosis details can be entered only for registered patients. 
	<li><b>Patient Id</b> must be greater than or equal to 4 digits. <u>Ex:</u>
					1203
	<li><b>Symptoms</b> can contain alphabets, space and comma. <u>Ex:</u>
					Vomiting , muscle weakness, Diseases and Disorders of the Nervous System
	<li><b>Diagnosis Provided</b> can contain alphabets, space, hyphen, numbers and comma. <u>Ex:</u>
					Trips, Caregiver education, counseling, Comprehensive Diagnostic Services
	<li><b>Administered By</b> can contain only alphabets and space. <u>Ex:</u>
					Dr Jon Christopher
	<li><b>Date Of Diagnosis</b> must be in format DD-Mon-YY and must be
					before the current date. <u>Ex:</u> 28-march-2016 should be given as 28-mar-16
	<li><b>Date Of Follow-up</b> must be in format DD-Mon-YY and must be
					after the current date. <u>Ex:</u> 08-april-2016 should be given as 08-apr-16
	<li><b>Bill Amount</b> can consist of 3 or more digits.
	<li><b>Mode Of Payment</b> should be either cash or card.
	<li><b>Card Number</b> must be of 16 digits. Card number is mandatory if the payment mode is Card.<br>Otherwise it can be empty.
	<li><b>Proceed to Billing</b> should be selected before proceeding to register.
	</ul>

	<div
		style="background-color: navy; text-align: center; font-weight: bold; color: white; height: 5%; position: relative; bottom: 0px; top: 10px; width: 100%">
		@Copyright 2016-2017</div>

</body>
</html>