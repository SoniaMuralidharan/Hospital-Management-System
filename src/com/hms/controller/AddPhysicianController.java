package com.hms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.bo.AddPhysicianBO;
import com.hms.constants.ErrorConstant;
import com.hms.constants.SuccessConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PhysicianTO;

/**
 * Servlet implementation class AddPhysicianController
 */
public class AddPhysicianController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPhysicianController() {
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

		AddPhysicianBO addPhysicianBO = new AddPhysicianBO();
		RequestDispatcher dispatcher;

		try {
			List<String> stateList = addPhysicianBO.getStates();
			HttpSession session = request.getSession();
			session.setAttribute("stateList", stateList);

			List<String> insuranceList = addPhysicianBO.getInsurance();
			session.setAttribute("insuranceList", insuranceList);

			List<String> departmentList = addPhysicianBO.getDepartment();
			session.setAttribute("departmentList", departmentList);

			dispatcher = request
					.getRequestDispatcher(SuccessConstant.PHYSICIAN_PAGE);
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
		String firstName = request.getParameter("physicianFirstName");
		String lastName = request.getParameter("physicianLastName");
		String department = request.getParameter("physicianDepartmentName");
		String educationQualification = request
				.getParameter("physicianQualification");
		String yearsOfExperience = request.getParameter("physicianExperience");
		String state = request.getParameter("physicianState");
		String insurancePlan = request.getParameter("physicianInsurancePlan");
		String shift = request.getParameter("Shift");

		PhysicianTO physicianTo = new PhysicianTO(firstName, lastName,
				department, educationQualification, yearsOfExperience, state,
				insurancePlan, shift);

		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(ErrorConstant.PHYSICIAN_PAGE);
		AddPhysicianBO addPhysicianBo = new AddPhysicianBO();

		try {

			addPhysicianBo.validatePhysician(physicianTo);

			String physicianId = physicianTo.getPhysicianId();

			session.setAttribute("physicianId", physicianId);

			dispatcher = request
					.getRequestDispatcher(SuccessConstant.SUCCESS_PHYSICIAN);

			session.setAttribute("userName", userName);
			dispatcher.forward(request, response);

		} catch (HmsBusinessException e) {
			dispatcher = request
					.getRequestDispatcher(ErrorConstant.PHYSICIAN_PAGE);
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
