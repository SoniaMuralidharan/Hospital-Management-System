package com.hms.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hms.constants.ErrorConstant;
import com.hms.dao.EnrollPatientDAO;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PatientTO;

public class EnrollPatientBO {

	List<String> errorList = new ArrayList<String>();

	boolean errorFlag = false;

	int firstNameCount = 0, lastNameCount = 0, fatherNameCount = 0,
			motherNameCount = 0, spouseNameCount = 0, childrenName1Count = 0,
			childrenName2Count = 0, alphaCount = 0;

	public boolean validatePatient(PatientTO patientTo)
			throws HmsBusinessException, HmsApplicationException {

		for (int i = 0; i < 15; i++) {
			errorList.add("");
		}

		String firstName = patientTo.getFirstName();
		String lastName = patientTo.getLastName();
		String password = patientTo.getPassword();
		String dateOfBirth = patientTo.getDateOfBirth();
		String emailAddress = patientTo.getEmailAddress();
		String contactNumber = patientTo.getContactNumber();
		String fatherName = patientTo.getFatherName();
		String motherName = patientTo.getMotherName();
		String patientCurrentWeight = patientTo.getPatientCurrentWeight();
		String maritalStatus = patientTo.getMaritalStatus();
		String spouseName = patientTo.getSpouseName();
		String spouseAge = patientTo.getSpouseAge();
		String noOfChildren = patientTo.getNoOfChildren();
		String childrenName1 = patientTo.getChildrenName1();
		String childrenName2 = patientTo.getChildrenName2();
		String state = patientTo.getState();

		/* All null Validation */
		if (isInputEmpty(firstName) && isInputEmpty(lastName)
				&& isInputEmpty(dateOfBirth) && isInputEmpty(childrenName2)
				&& isInputEmpty(childrenName1) && isInputEmpty(noOfChildren)
				&& isInputEmpty(spouseAge) && isInputEmpty(spouseName)
				&& isInputEmpty(patientCurrentWeight)
				&& isInputEmpty(motherName) && isInputEmpty(motherName)
				&& isInputEmpty(emailAddress) && isInputEmpty(password)) {
			errorFlag = true;
			errorList.set(0, ErrorConstant.EMPTY_FIELDS);
		} else {
			/* FIRSTNAME Validation */
			if (isInputEmpty(firstName)) {
				errorFlag = true;
				errorList.set(0, ErrorConstant.EMPTY_FIRSTNAME);
			} else {
				validateFirstName(firstName);
			}

			/* LASTNAME Validation */
			if (isInputEmpty(lastName)) {
				errorFlag = true;
				errorList.set(1, ErrorConstant.EMPTY_LASTNAME);
			} else {
				validateLastName(lastName);
			}

			/* PASSWORD Validation */
			if (isInputEmpty(password)) {
				errorFlag = true;
				errorList.set(2, ErrorConstant.EMPTY_PASSWORD);
			} else {
				validatePasword(password);
			}

			/* DATE-OF-BIRTH Validation */
			if (isInputEmpty(dateOfBirth)) {
				errorFlag = true;
				errorList.set(3, ErrorConstant.EMPTY_DOB);
			} else {
				validateDateOfBirth(dateOfBirth, patientTo);
			}

			/* EMAIL Validation */
			if (isInputEmpty(emailAddress)) {
				errorFlag = true;
				errorList.set(4, ErrorConstant.EMPTY_EMAIL);
			} else {
				validateEmail(emailAddress);
			}

			/* CONTACT NUMBER Validation */
			if (isInputEmpty(contactNumber)) {
				errorFlag = true;
				errorList.set(5, ErrorConstant.EMPTY_CONTACT);
			} else {
				validateContact(contactNumber);
			}

			/* FATHERNAME Validation */
			if (isInputEmpty(fatherName)) {
				errorFlag = true;
				errorList.set(6, ErrorConstant.EMPTY_FATHERNAME);
			} else {
				validateFatherName(fatherName);
			}

			/* MOTHERNAME Validation */
			if (isInputEmpty(motherName)) {
				errorFlag = true;
				errorList.set(7, ErrorConstant.EMPTY_MOTHERNAME);
			} else {
				validateMotherName(motherName);
			}

			/* PATIENT CURRENT WEIGHT Validation */
			try {

				if (isInputEmpty(patientCurrentWeight)) {
					errorFlag = true;
					errorList.set(8, ErrorConstant.EMPTY_WEIGHT);
				} else if (Integer.parseInt(patientCurrentWeight) > 0
						&& patientCurrentWeight.matches("[0-9]{1,}")) {

				} else {
					errorFlag = true;
					errorList.set(8, ErrorConstant.INVALID_WEIGHT);
				}

			} catch (NumberFormatException e) {
				// TODO: handle exception
				errorFlag = true;
				errorList.set(8, ErrorConstant.INVALID_WEIGHT);
			}

			/* MARITAL STATUS Validation */
			if (maritalStatus.equalsIgnoreCase("yes")) {

				validateSpouse(spouseName, spouseAge);
				validateChildren(noOfChildren, childrenName1, childrenName2,
						patientTo);

			} else {
				patientTo.setSpouseName("-");
				patientTo.setSpouseAge("0");
				patientTo.setNoOfChildren("0");
				patientTo.setChildrenName1("-");
				patientTo.setChildrenName2("-");
				// SpouseAge = "0";
			}

			/* STATE Validation */
			if (state.equals("-")) {
				errorFlag = true;
				errorList.set(14, ErrorConstant.EMPTY_STATE);
			}
		}

		if (errorFlag) {
			HmsBusinessException hms = new HmsBusinessException();
			hms.setErrorList(errorList);
			throw hms;
		}

		EnrollPatientBO enrollPatientBo = new EnrollPatientBO();
		enrollPatientBo.validateExistingPatient(patientTo);

		EnrollPatientDAO patientDao = new EnrollPatientDAO();
		int patientId = patientDao.generatePatientId();

		patientTo.setPatientId(patientId);
		patientDao.validatePatient(patientTo);

		return true;
	}

	public void validateExistingPatient(PatientTO patientTo)
			throws HmsBusinessException, HmsApplicationException {

		EnrollPatientDAO enrollPatientDao = new EnrollPatientDAO();
		int result = enrollPatientDao.validateExistingPatient(patientTo);

		if (result == -1) {
			throw new HmsBusinessException(ErrorConstant.EXISTING_PATIENT);
		}
	}

	public List<String> getStates() throws HmsApplicationException {

		EnrollPatientDAO enrollPatientDao = new EnrollPatientDAO();
		return enrollPatientDao.getStates();
	}

	public List<String> getInsurance() throws HmsApplicationException {

		EnrollPatientDAO enrollPatientDao = new EnrollPatientDAO();
		return enrollPatientDao.getInsurance();
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
			errorList.set(0, ErrorConstant.INVALID_FIRSTNAME);
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
			errorList.set(1, ErrorConstant.INVALID_LASTNAME);
		}
	}

	/* PASSWORD Validation */
	public void validatePasword(String password) {
		if (!(password.matches("[A-Z]{1}[a-z]{4,}[0-9]{1}[$&*]+"))
				|| !(password.length() >= 4)) {
			errorFlag = true;
			errorList.set(2, ErrorConstant.INVALID_PASSWORD);
		}
	}

	/* DATE-OF-BIRTH Validation */
	public void validateDateOfBirth(String dateOfBirth, PatientTO patientTo) {
		if (dateOfBirth.matches("[0-9]{2}[-]{1}[a-zA-Z]{3}[-]{1}[0-9]{4}")
				&& dateOfBirth.length() == 11) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dob = sdf.parse(dateOfBirth);
				Calendar cal = Calendar.getInstance();
				Date now = cal.getTime();
				if (!dob.before(now)) {
					errorFlag = true;
					errorList.set(3, ErrorConstant.INVALID_DOB);
				} else {
					patientTo.setDateOfBirth(sdf1.format(dob));
				}

			} catch (ParseException e) {
				errorFlag = true;
				errorList.set(3, ErrorConstant.INVALID_DOB);
			}
		} else {
			errorFlag = true;
			errorList.set(3, ErrorConstant.INVALID_DOB);
		}
	}

	/* EMAIL Validation */
	public void validateEmail(String emailAddress) {
		if (!(emailAddress.indexOf("@") == emailAddress.lastIndexOf("@"))) {
			errorFlag = true;
			errorList.set(4, ErrorConstant.INVALID_EMAIL);
		}
	}

	/* CONTACT NUMBER Validation */
	public void validateContact(String contactNumber) {
		if (!contactNumber.matches("[0-9]{10}")) {
			errorFlag = true;
			errorList.set(5, ErrorConstant.INVALID_CONTACT);
		}
	}

	/* FATHERNAME Validation */
	public void validateFatherName(String fatherName) {
		alphaCount = 0;
		for (int i = 0; i < fatherName.length(); i++) {
			char c = fatherName.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				fatherNameCount++;
			}
		}
		if (fatherNameCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(6, ErrorConstant.INVALID_FATHERNAME);
		}
	}

	/* MOTHERNAME Validation */
	public void validateMotherName(String motherName) {
		alphaCount = 0;
		for (int i = 0; i < motherName.length(); i++) {
			char c = motherName.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				motherNameCount++;
			}
		}
		if (motherNameCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(7, ErrorConstant.INVALID_MOTHERNAME);
		}
	}

	/* SPOUSENAME Validation */
	public void validateSpouseName(String spouseName) {
		alphaCount = 0;
		for (int i = 0; i < spouseName.length(); i++) {
			char c = spouseName.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				spouseNameCount++;
			}
		}
		if (spouseNameCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(9, ErrorConstant.INVALID_SPOUSENAME);
		}
	}

	/* CHILDREN NAME 1 Validation */
	public void validateChildren1(String childrenName1) {
		alphaCount = 0;
		for (int i = 0; i < childrenName1.length(); i++) {
			char c = childrenName1.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				childrenName1Count++;
			}
		}
		if (childrenName1Count != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(11, ErrorConstant.INVALID_CHILDRENNAME1);
		}
	}

	/* CHILDREN NAME 2 Validation */
	public void validateChildren2(String childrenName2) {
		alphaCount = 0;
		for (int i = 0; i < childrenName2.length(); i++) {
			char c = childrenName2.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				childrenName2Count++;
			}
		}
		if (childrenName2Count != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(12, ErrorConstant.INVALID_CHILDRENNAME2);
		}
	}

	/* SPOUSE NAME, SPOUSE AGE Validation */
	public void validateSpouse(String spouseName, String spouseAge) {
		/* SPOUSE NAME Validation */
		if (isInputEmpty(spouseName)) {
			errorFlag = true;
			errorList.set(9, ErrorConstant.EMPTY_SPOUSENAME);
		} else {
			validateSpouseName(spouseName);
		}

		try {
			/* SPOUSE AGE Validation */
			if (isInputEmpty(spouseAge)) {
				errorFlag = true;
				errorList.set(10, ErrorConstant.EMPTY_AGE);
			} else if (Integer.parseInt(spouseAge) > 0
					&& Integer.parseInt(spouseAge) <= 200
					&& spouseAge.matches("[0-9]{1,}")) {

			} else {
				errorFlag = true;
				errorList.set(10, ErrorConstant.INVALID_AGE);
			}
		} catch (NumberFormatException e) {
			errorFlag = true;
			errorList.set(10, ErrorConstant.INVALID_AGE);
		}
	}

	/* CHILDREN NO. , CHILDREN NAME1 , CHILDREN NAME2 Validation */
	public void validateChildren(String noOfChildren, String childrenName1,
			String childrenName2, PatientTO patientTo) {
		/* NUMBER OF CHILDREN Validation */
		if (isInputEmpty(noOfChildren)) {
			patientTo.setNoOfChildren("0");
			patientTo.setChildrenName1("-");
			patientTo.setChildrenName2("-");
			noOfChildren = "0";
		} else {
			try {
				if (Integer.parseInt(noOfChildren) >= 1) {
					/* CHILDREN NAME 1 Validation */
					if (isInputEmpty(childrenName1)) {
						errorFlag = true;
						errorList.set(11, ErrorConstant.EMPTY_CHILDRENNAME1);
					} else {
						validateChildren1(childrenName1);
					}
				}

				/* CHILDREN NAME 2 Validation */
				if (Integer.parseInt(noOfChildren) >= 2) {
					if (isInputEmpty(childrenName2)) {
						errorFlag = true;
						errorList.set(12, ErrorConstant.EMPTY_CHILDRENNAME2);
					} else {
						validateChildren2(childrenName2);
					}
				} else {
					patientTo.setChildrenName2("-");
				}
			} catch (NumberFormatException e) {
				errorFlag = true;
				errorList.set(13, ErrorConstant.INVALID_CHILDREN_NUMBER);
			}
		}

	}

	public int alphabetCount(Character c) {
		if (Character.isAlphabetic(c)) {
			alphaCount++;
		}
		return alphaCount;
	}
}
