package com.hms.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hms.constants.ErrorConstant;
import com.hms.dao.PhysicianSearchDAO;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PhysicianSearchTO;

public class PhysicianSearchBO {

	List<String> errorList = new ArrayList<String>();
	boolean errorFlag = false;

	public PhysicianSearchBO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<PhysicianSearchTO> getAll(
			PhysicianSearchTO physicianSearchTo)
			throws HmsApplicationException, HmsBusinessException {

		errorFlag = false;

		for (int i = 0; i < 1; i++) {
			errorList.add("");
		}

		errorFlag = validateFields(physicianSearchTo);

		if (errorFlag) {
			HmsBusinessException hms = new HmsBusinessException();
			hms.setErrorList(errorList);
			throw hms;
		}

		PhysicianSearchDAO physicianSearchDao = new PhysicianSearchDAO();

		return physicianSearchDao.getAll(physicianSearchTo);
	}

	public ArrayList<PhysicianSearchTO> getSortFirstName(
			PhysicianSearchTO physicianSearchTo)
			throws HmsApplicationException, HmsBusinessException {

		errorFlag = false;

		for (int i = 0; i < 1; i++) {
			errorList.add("");
		}

		errorFlag = validateFields(physicianSearchTo);

		if (errorFlag) {
			HmsBusinessException hms = new HmsBusinessException();
			hms.setErrorList(errorList);
			throw hms;
		}

		PhysicianSearchDAO physicianSearchDao = new PhysicianSearchDAO();

		try {
			return physicianSearchDao.getSortFirstName(physicianSearchTo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new HmsApplicationException(e);
		}
	}

	public ArrayList<PhysicianSearchTO> getSortLastName(
			PhysicianSearchTO physicianSearchTo)
			throws HmsApplicationException, HmsBusinessException {

		errorFlag = false;

		for (int i = 0; i < 1; i++) {
			errorList.add("");
		}

		errorFlag = validateFields(physicianSearchTo);

		if (errorFlag) {
			HmsBusinessException hms = new HmsBusinessException();
			hms.setErrorList(errorList);
			throw hms;
		}

		PhysicianSearchDAO physicianSearchDao = new PhysicianSearchDAO();

		try {
			return physicianSearchDao.getSortLastName(physicianSearchTo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new HmsApplicationException(e);
		}
	}

	public boolean validateFields(PhysicianSearchTO physicianSearchTo) {

		String state = physicianSearchTo.getState();
		String plan = physicianSearchTo.getInsurancePlan();
		String department = physicianSearchTo.getDepartmentName();
		String shift = physicianSearchTo.getShiftTimings();

		if (state.equals("-") && plan.equals("-") && department.equals("-")
				&& shift.equals("-")) {
			errorFlag = true;
			errorList.set(0, ErrorConstant.EMPTY_SEARCH_CRITERIA);
		}

		if (state.equals("-")) {
			physicianSearchTo.setState("none");
		}

		if (plan.equals("-")) {
			physicianSearchTo.setInsurancePlan("none");
		}

		if (department.equals("-")) {
			physicianSearchTo.setDepartmentName("none");
		}

		if (shift.equals("-")) {
			physicianSearchTo.setShiftTimings("none");
		}

		return errorFlag;
	}

	public List<String> getStates() throws HmsApplicationException {

		PhysicianSearchDAO physicianSearchDao = new PhysicianSearchDAO();
		return physicianSearchDao.getStates();
	}

	public List<String> getInsurance() throws HmsApplicationException {

		PhysicianSearchDAO physicianSearchDao = new PhysicianSearchDAO();
		return physicianSearchDao.getInsurance();
	}

	public List<String> getDepartment() throws HmsApplicationException {

		PhysicianSearchDAO physicianSearchDao = new PhysicianSearchDAO();
		return physicianSearchDao.getDepartment();
	}

}
