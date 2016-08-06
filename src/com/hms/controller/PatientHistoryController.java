package com.hms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.bo.PatientHistoryBO;
import com.hms.constants.ErrorConstant;
import com.hms.constants.SuccessConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.HistoryTO;
import com.hms.model.PatientTO;

/**
 * Servlet implementation class LoginController
 */
public class PatientHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientHistoryController() {
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

		ArrayList<HistoryTO> plist = new ArrayList<HistoryTO>();

		PatientHistoryBO patientHistoryBO = new PatientHistoryBO();
		HistoryTO patientHistoryTo = new HistoryTO();
		PatientTO patientTo = new PatientTO();

		String userName = request.getParameter("UserName");
		String checkPatientId = request.getParameter("chkPatientId");

		String patientId = request.getParameter("PatientId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		patientHistoryTo.setPatient_id(patientId);
		patientTo.setFirstName(firstName);
		patientTo.setLastName(lastName);

		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher(ErrorConstant.HISTORY_PAGE);

		try {
			if (checkPatientId.equalsIgnoreCase("chkPatientId")) {

				plist = patientHistoryBO.getAll(patientHistoryTo);

				dispatcher = request
						.getRequestDispatcher(SuccessConstant.SUCCESS_HISTORY_RESULT);
				request.setAttribute("plist", plist);
				dispatcher.forward(request, response);

			} else if (checkPatientId.equalsIgnoreCase("chkPatientFNLN")) {

				plist = patientHistoryBO.getFNLN(patientTo, patientHistoryTo);

				dispatcher = request
						.getRequestDispatcher(SuccessConstant.SUCCESS_HISTORY_RESULT);
				request.setAttribute("plist", plist);
				dispatcher.forward(request, response);
			}
		} catch (HmsBusinessException e) {
			String errMsg = e.getMessage();

			request.setAttribute("errMsg", errMsg);
			request.setAttribute("errorList", e.getErrorList());
			request.setAttribute("found", "true");
			dispatcher.forward(request, response);
			dispatcher = request
					.getRequestDispatcher(ErrorConstant.HISTORY_PAGE);
		} catch (HmsApplicationException e) {
			String errMsg = e.getMessage();
			request.setAttribute("errMsg", errMsg);
			dispatcher.forward(request, response);
		}
	}
}
