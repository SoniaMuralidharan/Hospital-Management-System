package com.hms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.bo.LoginBO;
import com.hms.constants.ErrorConstant;
import com.hms.constants.SuccessConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.UserTO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		String password = request.getParameter("Password");
		UserTO userTo = new UserTO(userName, password);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(ErrorConstant.LOGIN_PAGE);
		LoginBO loginBo = new LoginBO();

		try {
			loginBo.validateUser(userTo);
			dispatcher = request
					.getRequestDispatcher(SuccessConstant.SUCCESS_PAGE);

			HttpSession session = request.getSession();
			session.setAttribute("UserName", userName);
			dispatcher.forward(request, response);

		} catch (HmsBusinessException e) {
			String errMsg = e.getMessage();
			request.setAttribute("errMsg", errMsg);
			dispatcher.forward(request, response);
		} catch (HmsApplicationException e) {
			String errMsg = e.getMessage();
			request.setAttribute("errMsg", errMsg);
			dispatcher.forward(request, response);
		}

	}
}
