package com.hms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.bo.PhysicianSearchBO;
import com.hms.constants.ErrorConstant;
import com.hms.constants.SuccessConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PhysicianSearchTO;

/**
 * Servlet implementation class LoginController
 */
public class PhysicianSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhysicianSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		PhysicianSearchBO physicianSearchBO = new PhysicianSearchBO();
		RequestDispatcher dispatcher = null;

		try {
			List<String> stateList = physicianSearchBO.getStates();
			session.setAttribute("stateList", stateList);

			List<String> insuranceList = physicianSearchBO.getInsurance();
			session.setAttribute("insuranceList", insuranceList);

			List<String> departmentList = physicianSearchBO.getDepartment();
			session.setAttribute("departmentList", departmentList);

			dispatcher = request
					.getRequestDispatcher(SuccessConstant.SUCCESS_SEARCH);
			request.setAttribute("found", "true");
			dispatcher.forward(request, response);

		} catch (HmsApplicationException e) {

			String errMsg = e.getMessage();

			request.setAttribute("errMsg", errMsg);
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String sort = request.getParameter("Sort");
		String state = request.getParameter("State");
		String plan = request.getParameter("InsurancePlan");
		String departmentName = request.getParameter("departmentName");
		String shiftTimings = request.getParameter("ShiftTimings");

		PhysicianSearchTO physicianSearchTo = new PhysicianSearchTO(null, null,
				null, departmentName, null, null, state, plan, shiftTimings);

		PhysicianSearchBO physicianSearchBO = new PhysicianSearchBO();

		ArrayList<PhysicianSearchTO> plist = new ArrayList<PhysicianSearchTO>();

		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(ErrorConstant.SEARCH_PAGE);
		try {

			if (sort.equalsIgnoreCase("First Name")) {
				plist = physicianSearchBO.getSortFirstName(physicianSearchTo);

				dispatcher = request
						.getRequestDispatcher(SuccessConstant.SUCCESS_SEARCH_RESULT);
				request.setAttribute("plist", plist);
				dispatcher.forward(request, response);

			} else if (sort.equalsIgnoreCase("Last Name")) {
				plist = physicianSearchBO.getSortLastName(physicianSearchTo);

				dispatcher = request
						.getRequestDispatcher(SuccessConstant.SUCCESS_SEARCH_RESULT);
				request.setAttribute("plist", plist);
				dispatcher.forward(request, response);
			} else {
				plist = physicianSearchBO.getAll(physicianSearchTo);

				dispatcher = request
						.getRequestDispatcher(SuccessConstant.SUCCESS_SEARCH_RESULT);
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
					.getRequestDispatcher(ErrorConstant.SEARCH_PAGE);
		} catch (HmsApplicationException e) {
			String errMsg = e.getMessage();
			request.setAttribute("errMsg", errMsg);
			dispatcher.forward(request, response);
		}

	}
}
