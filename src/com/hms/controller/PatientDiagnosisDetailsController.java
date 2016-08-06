package com.hms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.bo.PatientDiagnosisDetailsBO;
import com.hms.constants.ErrorConstant;
import com.hms.constants.SuccessConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PatientDiagnosisDetailsTO;

/**
 * Servlet implementation class PatientDiagnosisController
 */
public class PatientDiagnosisDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientDiagnosisDetailsController() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("UserName");
		String patientId = request.getParameter("patientId");
		String symptoms = request.getParameter("symptoms");
		String diagnosisProvided = request.getParameter("diagnosisProvided");
		String administeredBy = request.getParameter("administeredBy");
		String dateOfDiagnosis = request.getParameter("dateOfDiagnosis");
		String followUpRequired = request.getParameter("followUpRequired");
		String dateOfFollowUp = request.getParameter("dateOfFollowUp");
		String billAmount = request.getParameter("billAmount");
		String cardNumber = request.getParameter("cardNumber");
		String modeOfPayment = request.getParameter("modeOfPayment");

		PatientDiagnosisDetailsTO patientDiagnosisDetailsTo = new PatientDiagnosisDetailsTO(
				patientId, symptoms, diagnosisProvided, administeredBy,
				dateOfDiagnosis, followUpRequired, dateOfFollowUp, billAmount,
				cardNumber, modeOfPayment);

		HttpSession session = request.getSession();

		RequestDispatcher dispatcher = request
				.getRequestDispatcher(ErrorConstant.PATIENT_DIAGNOSIS_PAGE);
		PatientDiagnosisDetailsBO patientDiagnosisDetailsBo = new PatientDiagnosisDetailsBO();

		try {

			patientDiagnosisDetailsBo
					.validatePatientDiagnosis(patientDiagnosisDetailsTo);

			int diagnosisId = patientDiagnosisDetailsTo.getDiagnosisId();

			session.setAttribute("patientId", patientId);
			session.setAttribute("diagnosisId", diagnosisId);

			dispatcher = request
					.getRequestDispatcher(SuccessConstant.SUCCESS_DIAGNOSIS);

			session.setAttribute("userName", userName);
			dispatcher.forward(request, response);

		} catch (HmsBusinessException e) {
			String errMsg = e.getMessage();

			request.setAttribute("errMsg", errMsg);
			request.setAttribute("errorList", e.getErrorList());
			request.setAttribute("found", "true");
			dispatcher = request
					.getRequestDispatcher(ErrorConstant.PATIENT_DIAGNOSIS_PAGE);
			dispatcher.forward(request, response);
		} catch (HmsApplicationException e) {
			String errMsg = e.getMessage();
			request.setAttribute("errMsg", errMsg);
			dispatcher.forward(request, response);
		}
	}

}
