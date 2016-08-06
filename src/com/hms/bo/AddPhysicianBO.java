package com.hms.bo;

import java.util.ArrayList;
import java.util.List;

import com.hms.constants.ErrorConstant;
import com.hms.dao.AddPhysicianDAO;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PhysicianTO;

public class AddPhysicianBO {

	List<String> errorList = new ArrayList<String>();

	boolean errorFlag = false;

	int physicianFirstNameCount = 0, physicianLastNameCount = 0,
			physicianQualificationCount = 0, alphaCount = 0;

	public boolean validatePhysician(PhysicianTO physicianTo)
			throws HmsBusinessException, HmsApplicationException {

		for (int i = 0; i < 7; i++) {
			errorList.add("");
		}

		String physicianFirstName = physicianTo.getPhysicianFirstName();
		String physicianLastName = physicianTo.getPhysicianLastName();
		String physicianDepartmentName = physicianTo.getDepartmentName();
		String physicianQualification = physicianTo
				.getEducationalQualification();
		String physicianExperience = physicianTo.getYearsOfExcperience();
		String physicianState = physicianTo.getState();
		String physicianShift = physicianTo.getShift();

		/* FIRSTNAME Validation */
		if (isInputEmpty(physicianFirstName)) {
			errorFlag = true;
			errorList.set(0, ErrorConstant.EMPTY_FIRSTNAME);
		} else {
			validatePhysicianFirstName(physicianFirstName);
		}

		/* LASTNAME Validation */
		if (isInputEmpty(physicianLastName)) {
			errorFlag = true;
			errorList.set(1, ErrorConstant.EMPTY_LASTNAME);
		} else {
			validatePhysicianLastName(physicianLastName);
		}

		/* DEPARTMENT Validation */
		if (physicianDepartmentName.equals("-")) {
			errorFlag = true;
			errorList.set(2, ErrorConstant.EMPTY_DEPARTMENT);
		}

		/* Educational Qualifications validation */
		if (isInputEmpty(physicianQualification)) {
			errorFlag = true;
			errorList.set(3, ErrorConstant.EMPTY_QUALIFICATION);
		} else {
			validatePhysicianQualification(physicianQualification);
		}

		/* Years of Experience validation */
		try {
			if (isInputEmpty(physicianExperience)) {
				errorFlag = true;
				errorList.set(4, ErrorConstant.EMPTY_EXPERIENCE);
			} else if (Integer.parseInt(physicianExperience) > 0
					&& physicianExperience.matches("[0-9]{1,}")) {

			} else {
				errorFlag = true;
				errorList.set(4, ErrorConstant.INVALID_EXPERIENCE);
			}
		} catch (NumberFormatException e) {
			errorFlag = true;
			errorList.set(4, ErrorConstant.INVALID_EXPERIENCE);
		}

		/* STATE Validation */
		if (physicianState.equals("-")) {
			errorFlag = true;
			errorList.set(5, ErrorConstant.EMPTY_STATE);
		}

		/* SHIFT Validation */
		if (physicianShift.equals("-")) {
			errorFlag = true;
			errorList.set(6, ErrorConstant.EMPTY_SHIFT);
		}

		if (errorFlag) {
			HmsBusinessException hms = new HmsBusinessException();
			hms.setErrorList(errorList);
			throw hms;
		}

		AddPhysicianBO addPhysicianBo = new AddPhysicianBO();
		addPhysicianBo.validateExistingPhysician(physicianTo);

		AddPhysicianDAO physicianDao = new AddPhysicianDAO();
		String PhysicianId = physicianDao.generatePhysicianId();

		physicianTo.setPhysicianId(PhysicianId);
		physicianDao.validatePhysician(physicianTo);

		return true;
	}

	public void validateExistingPhysician(PhysicianTO physicianTo)
			throws HmsBusinessException, HmsApplicationException {

		AddPhysicianDAO addPhysicianDao = new AddPhysicianDAO();
		int result = addPhysicianDao.validateExistingPatient(physicianTo);

		if (result == -1) {
			throw new HmsBusinessException(ErrorConstant.EXISTING_PHYSICIAN);
		}

	}

	public List<String> getStates() throws HmsApplicationException {

		AddPhysicianDAO addPhysicianDao = new AddPhysicianDAO();
		return addPhysicianDao.getStates();
	}

	public List<String> getInsurance() throws HmsApplicationException {

		AddPhysicianDAO addPhysicianDao = new AddPhysicianDAO();
		return addPhysicianDao.getInsurance();
	}

	public List<String> getDepartment() throws HmsApplicationException {

		AddPhysicianDAO addPhysicianDao = new AddPhysicianDAO();
		return addPhysicianDao.getDepartment();
	}

	public boolean isInputEmpty(String input) {
		boolean empty = false;
		if (input == null || input.isEmpty()) {
			empty = true;
		}

		return empty;
	}

	/* FIRSTNAME Validation */
	/**
	 * Validate physician first name.
	 * 
	 * @param physicianFirstName
	 *            the physician first name
	 */
	public void validatePhysicianFirstName(String physicianFirstName) {
		alphaCount = 0;
		for (int i = 0; i < physicianFirstName.length(); i++) {
			char c = physicianFirstName.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				physicianFirstNameCount++;
			}
		}
		if (physicianFirstNameCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(0, ErrorConstant.INVALID_FIRSTNAME);
		}
	}

	/* LASTNAME Validation */
	public void validatePhysicianLastName(String physicianLastName) {
		alphaCount = 0;
		for (int i = 0; i < physicianLastName.length(); i++) {
			char c = physicianLastName.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				physicianLastNameCount++;
			}
		}
		if (physicianLastNameCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(1, ErrorConstant.INVALID_LASTNAME);
		}
	}

	/* Educational Qualifications validation */
	public void validatePhysicianQualification(String physicianQualification) {
		alphaCount = 0;
		for (int i = 0; i < physicianQualification.length(); i++) {
			char c = physicianQualification.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				physicianQualificationCount++;
			}
		}
		if (physicianQualificationCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(3, ErrorConstant.INVALID_QUALIFICATION);
		}
	}

	public int alphabetCount(Character c) {
		if (Character.isAlphabetic(c)) {
			alphaCount++;
		}
		return alphaCount;
	}

}
