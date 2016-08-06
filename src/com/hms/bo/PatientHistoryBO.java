package com.hms.bo;

import java.util.ArrayList;
import java.util.List;

import com.hms.constants.ErrorConstant;
import com.hms.dao.PatientHistoryDAO;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.HistoryTO;
import com.hms.model.PatientTO;

public class PatientHistoryBO {

	List<String> errorList = new ArrayList<String>();
	boolean errorFlag = false;
	int firstNameCount = 0, lastNameCount = 0, alphaCount = 0;

	public PatientHistoryBO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<HistoryTO> getAll(HistoryTO patientHistoryTo)
			throws HmsBusinessException, HmsApplicationException {

		errorFlag = false;

		for (int i = 0; i < 3; i++) {
			errorList.add("");
		}

		PatientHistoryDAO patientDao = new PatientHistoryDAO();

		String patient_Id = patientHistoryTo.getPatient_id();

		/* PATIENTID Validation */
		if (isInputEmpty(patient_Id)) {
			errorFlag = true;
			errorList.set(0, ErrorConstant.EMPTY_PATIENTID);
		} else {
			try {
				if (!(Integer.parseInt(patient_Id) > 1000)
						|| !(patient_Id.matches("[0-9]{4,}"))) {
					errorFlag = true;
					errorList.set(0, ErrorConstant.INVALID_PATIENTID);
				}
			} catch (NumberFormatException e) {
				errorFlag = true;
				errorList.set(0, ErrorConstant.INVALID_PATIENTID);
			}
		}

		if (errorFlag) {
			HmsBusinessException hms = new HmsBusinessException();
			hms.setErrorList(errorList);
			throw hms;
		}

		return patientDao.getAll(patientHistoryTo);
	}

	public ArrayList<HistoryTO> getFNLN(PatientTO patientTo,
			HistoryTO patientHistoryTo) throws HmsApplicationException,
			HmsBusinessException {

		errorFlag = false;

		for (int i = 0; i < 3; i++) {
			errorList.add("");
		}

		PatientHistoryDAO patientDao = new PatientHistoryDAO();

		String firstName = patientTo.getFirstName();
		String lastName = patientTo.getLastName();

		if (isInputEmpty(firstName) && isInputEmpty(lastName)) {
			errorFlag = true;
			errorList.set(1, ErrorConstant.EMPTY_FNLN);
		} else {
			/* FIRSTNAME Validation */
			if (isInputEmpty(firstName)) {
				errorFlag = true;
				errorList.set(1, ErrorConstant.EMPTY_FIRSTNAME);
			} else {
				validateFirstName(firstName);
			}

			/* LASTNAME Validation */
			if (isInputEmpty(lastName)) {
				errorFlag = true;
				errorList.set(2, ErrorConstant.EMPTY_LASTNAME);
			} else {
				validateLastName(lastName);
			}
		}
		if (errorFlag) {
			HmsBusinessException hms = new HmsBusinessException();
			hms.setErrorList(errorList);
			throw hms;
		}

		return patientDao.getFNLN(patientTo, patientHistoryTo);
	}

	public boolean isInputEmpty(String input) {
		boolean empty = false;
		if (input == null || input.isEmpty()) {
			empty = true;
		}

		return empty;
	}

	/* FIRSTNAME Validation */
	public void validateFirstName(String firstName) {
		alphaCount = 0;
		for (int i = 0; i < firstName.length(); i++) {
			char c = firstName.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				firstNameCount++;
			}
		}
		if (firstNameCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(1, ErrorConstant.INVALID_FIRSTNAME);
		}
	}

	/* LASTNAME Validation */
	public void validateLastName(String lastName) {
		alphaCount = 0;
		for (int i = 0; i < lastName.length(); i++) {
			char c = lastName.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				lastNameCount++;
			}
		}
		if (lastNameCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(2, ErrorConstant.INVALID_LASTNAME);
		}
	}

	public int alphabetCount(Character c) {
		if (Character.isAlphabetic(c)) {
			alphaCount++;
		}
		return alphaCount;
	}

}
