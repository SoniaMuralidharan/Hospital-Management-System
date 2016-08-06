package com.hms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.bo.EnrollPatientBO;
import com.hms.constants.ErrorConstant;
import com.hms.constants.SuccessConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PatientTO;

/**
 * Servlet implementation class LoginController
 */
public class EnrollPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollPatientController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EnrollPatientBO enrollPatientBO = new EnrollPatientBO();
		RequestDispatcher dispatcher;

		try {
			List<String> stateList = enrollPatientBO.getStates();
			HttpSession session = request.getSession();
			session.setAttribute("stateList", stateList);

			List<String> insuranceList = enrollPatientBO.getInsurance();
			session.setAttribute("insuranceList", insuranceList);

			dispatcher = request
					.getRequestDispatcher(SuccessConstant.PATIENT_PAGE);
			request.setAttribute("found", "true");
			dispatcher.forward(request, response);

		} catch (HmsApplicationException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = request.getParameter("UserName");
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String password = request.getParameter("Password");
		String dateOfBirth = request.getParameter("DateOfBirth");
		String emailAddress = request.getParameter("EmailAddress");
		String contactNumber = request.getParameter("ContactNumber");
		String fatherName = request.getParameter("FatherName");
		String motherName = request.getParameter("MotherName");
		String patientCurrentWeight = request
				.getParameter("PatientCurrentWeight");
		String maritalStatus = request.getParameter("Married");
		String spouseName = request.getParameter("SpouseName");
		String spouseAge = request.getParameter("SpouseAge");
		String noOfChildren = request.getParameter("NoOfChildren");
		String childrenName1 = request.getParameter("ChildrenName1");
		String childrenName2 = request.getParameter("ChildrenName2");
		String state = request.getParameter("State");
		String insurancePlan = request.getParameter("InsurancePlan");

		PatientTO patientTo = new PatientTO(firstName, lastName, password,
				dateOfBirth, emailAddress, contactNumber, fatherName,
				motherName, patientCurrentWeight, maritalStatus, spouseName,
				spouseAge, noOfChildren, childrenName1, childrenName2, state,
				insurancePlan);

		EnrollPatientBO enrollPatientBo = new EnrollPatientBO();
		HttpSession session = request.getSession();

		RequestDispatcher dispatcher = request
				.getRequestDispatcher(ErrorConstant.PATIENT_PAGE);

		try {

			enrollPatientBo.validatePatient(patientTo);

			int patientId = patientTo.getPatientId();

			session.setAttribute("patientId", patientId);

			dispatcher = request
					.getRequestDispatcher(SuccessConstant.SUCCESS_PATIENT);
			session.setAttribute("userName", userName);
			dispatcher.forward(request, response);

		} catch (HmsBusinessException e) {
			dispatcher = request
					.getRequestDispatcher(ErrorConstant.PATIENT_PAGE);
			String errMsg = e.getMessage();

			request.setAttribute("errMsg", errMsg);
			request.setAttribute("errorList", e.getErrorList());
			request.setAttribute("found", "true");
			dispatcher.forward(request, response);
		} catch (HmsApplicationException e) {
			String errMsg = e.getMessage();

			request.setAttribute("errMsg", errMsg);
			dispatcher.forward(request, response);
		}
	}
}
