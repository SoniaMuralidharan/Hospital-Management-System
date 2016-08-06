package com.hms.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hms.constants.ErrorConstant;
import com.hms.dao.PatientDiagnosisDetailsDAO;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PatientDiagnosisDetailsTO;

public class PatientDiagnosisDetailsBO {

	List<String> errorList = new ArrayList<String>();

	int symptomsCount = 0, diagnosisProvidedCount = 0, administeredByCount = 0,
			alphaCount = 0;
	boolean errorFlag = false;

	public boolean validatePatientDiagnosis(
			PatientDiagnosisDetailsTO patientDiagnosisDetailsTo)
			throws HmsBusinessException, HmsApplicationException {

		for (int i = 0; i < 9; i++) {
			errorList.add("");
		}

		String patientId = patientDiagnosisDetailsTo.getPatientId();
		String symptoms = patientDiagnosisDetailsTo.getSymptoms();
		String diagnosisProvided = patientDiagnosisDetailsTo
				.getDiagnosisProvided();
		String administeredBy = patientDiagnosisDetailsTo.getAdministeredBy();
		String dateOfDiagnosis = patientDiagnosisDetailsTo.getDateOfDiagnosis();
		String followUpRequired = patientDiagnosisDetailsTo
				.getFollowUpRequired();
		String dateOfFollowUp = patientDiagnosisDetailsTo.getDateOfFollowUp();
		String billAmount = patientDiagnosisDetailsTo.getBillAmount();
		String cardNumber = patientDiagnosisDetailsTo.getCardNumber();
		String modeOfPayment = patientDiagnosisDetailsTo.getModeOfPayment();

		/* PATIENTID Validation */
		if (isInputEmpty(patientId)) {
			errorFlag = true;
			errorList.set(0, ErrorConstant.EMPTY_PATIENTID);
		} else {
			try {
				if (!(Integer.parseInt(patientId) > 1000)) {
					errorFlag = true;
					errorList.set(0, ErrorConstant.INVALID_PATIENTID);
				}
			} catch (NumberFormatException e) {
				errorFlag = true;
				errorList.set(0, ErrorConstant.INVALID_PATIENTID);
			}
		}

		/* SYMPTOMS Validation */
		if (isInputEmpty(symptoms)) {
			errorFlag = true;
			errorList.set(1, ErrorConstant.EMPTY_SYMPTOMS);
		} else {
			validateSymptoms(symptoms);
		}

		/* DIAGNOSIS PROVIDED Validation */
		if (isInputEmpty(diagnosisProvided)) {
			errorFlag = true;
			errorList.set(2, ErrorConstant.EMPTY_DIAGNOSISPROVIDED);
		} else {
			validateDiagnosis(diagnosisProvided);
		}

		/* ADMINISTERED BY Validation */
		if (isInputEmpty(administeredBy)) {
			errorFlag = true;
			errorList.set(3, ErrorConstant.EMPTY_ADMISTERED_BY);
		} else {
			validateAdministeredBy(administeredBy);
		}

		/* DATE OF DIAGNOSIS Validation */
		if (isInputEmpty(dateOfDiagnosis)) {
			errorFlag = true;
			errorList.set(4, ErrorConstant.EMPTY_DATE_OF_DIAGNOSIS);
		} else {
			validateDoD(dateOfDiagnosis, patientDiagnosisDetailsTo);
		}

		/* DATE OF FOLLOWUP is Required */
		if (followUpRequired.equalsIgnoreCase("yes")) {
			/* DATE OF FOLLOWUP Validation */

			if (isInputEmpty(dateOfFollowUp)) {
				errorFlag = true;
				errorList.set(5, ErrorConstant.EMPTY_DATE_OF_FOLLOWUP);
			} else {
				validateDoF(dateOfFollowUp, patientDiagnosisDetailsTo);
			}
		} else {
			patientDiagnosisDetailsTo
					.setDateOfFollowUp(patientDiagnosisDetailsTo
							.getDateOfDiagnosis());
		}

		/* Billing Amount validation */
		if (isInputEmpty(billAmount)) {
			errorFlag = true;
			errorList.set(6, ErrorConstant.EMPTY_BILL_AMOUNT);

		} else {
			if (!billAmount.matches("[0-9]{3,}")) {
				errorFlag = true;
				errorList.set(6, ErrorConstant.INVALID_BILL_AMOUNT);
			}
		}

		/* MODE OF PAYMENT is Required */
		if (isInputEmpty(modeOfPayment)) {
			errorFlag = true;
			errorList.set(7, ErrorConstant.EMPTY_MODE_OF_PAYMENT);
		} else if (modeOfPayment.equalsIgnoreCase("Card")) {
			/* card number validation */
			validateCard(cardNumber, patientDiagnosisDetailsTo);
		} else if (modeOfPayment.equalsIgnoreCase("Cash")) {
			patientDiagnosisDetailsTo.setModeOfPayment("Cash");
			patientDiagnosisDetailsTo.setCardNumber("-");
		} else {
			errorFlag = true;
			errorList.set(7, ErrorConstant.INVALID_MODE_OF_PAYMENT);
		}

		if (errorFlag) {
			HmsBusinessException hms = new HmsBusinessException();
			hms.setErrorList(errorList);
			throw hms;
		}

		PatientDiagnosisDetailsBO patientDiagnosisDetailsBo = new PatientDiagnosisDetailsBO();
		patientDiagnosisDetailsBo
				.validateExistingPatientDiagnosis(patientDiagnosisDetailsTo);

		PatientDiagnosisDetailsDAO patientDiagnosisDetailsDetailsDao = new PatientDiagnosisDetailsDAO();
		int diagnosisId = patientDiagnosisDetailsDetailsDao
				.generateDiagnosisId();

		patientDiagnosisDetailsTo.setDiagnosisId(diagnosisId);

		patientDiagnosisDetailsDetailsDao
				.validatePatientDiagnosis(patientDiagnosisDetailsTo);

		return true;
	}

	public void validateExistingPatientDiagnosis(
			PatientDiagnosisDetailsTO patientDiagnosisDetailsTo)
			throws HmsBusinessException, HmsApplicationException {

		PatientDiagnosisDetailsDAO patientDiagnosisDetailsDao = new PatientDiagnosisDetailsDAO();
		int result = patientDiagnosisDetailsDao
				.validateExistingPatientDiagnosis(patientDiagnosisDetailsTo);
		if (result != -1) {
			throw new HmsBusinessException(ErrorConstant.NOT_EXISTING_PATIENT);

		}

	}

	public boolean isInputEmpty(String input) {
		boolean empty = false;
		if (input == null || input.isEmpty()) {
			empty = true;
		}

		return empty;
	}

	/* SYMPTOMS Validation */
	public void validateSymptoms(String symptoms) {
		alphaCount = 0;
		for (int i = 0; i < symptoms.length(); i++) {
			char c = symptoms.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)
					|| Character.isDigit(c) || c == ',') {
				alphaCount = alphabetCount(c);
			} else {
				symptomsCount++;
			}
		}
		if (symptomsCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(1, ErrorConstant.INVALID_SYMPTOMS);
		}
	}

	/* DIAGNOSIS PROVIDED Validation */
	public void validateDiagnosis(String diagnosisProvided) {
		alphaCount = 0;
		for (int i = 0; i < diagnosisProvided.length(); i++) {
			char c = diagnosisProvided.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)
					|| Character.isDigit(c) || c == ',' || c == '-') {
				alphaCount = alphabetCount(c);
			} else {
				diagnosisProvidedCount++;
			}
		}
		if (diagnosisProvidedCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(2, ErrorConstant.INVALID_DIAGNOSISPROVIDED);
		}
	}

	/* ADMINISTERED BY Validation */
	public void validateAdministeredBy(String administeredBy) {
		alphaCount = 0;
		for (int i = 0; i < administeredBy.length(); i++) {
			char c = administeredBy.charAt(i);
			if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
				alphaCount = alphabetCount(c);
			} else {
				administeredByCount++;
			}
		}
		if (administeredByCount != 0 || alphaCount == 0) {
			errorFlag = true;
			errorList.set(3, ErrorConstant.INVALID_ADMINISTERDBY);
		}
	}

	/* DATE OF DIAGNOSIS Validation */
	public void validateDoD(String dateOfDiagnosis,
			PatientDiagnosisDetailsTO patientDiagnosisDetailsTo) {
		if (dateOfDiagnosis.matches("[0-9]{2}[-]{1}[a-zA-Z]{3}[-]{1}[0-9]{2}")
				&& dateOfDiagnosis.length() == 9) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dod = sdf.parse(dateOfDiagnosis);
				Calendar cal = Calendar.getInstance();
				Date now = cal.getTime();
				if (!dod.before(now)) {
					errorFlag = true;
					errorList.set(4, ErrorConstant.INVALID_DATE_OF_DIAGNOSIS);
				} else {
					patientDiagnosisDetailsTo.setDateOfDiagnosis(sdf1
							.format(dod));
				}

			} catch (ParseException e) {
				errorFlag = true;
				errorList.set(4, ErrorConstant.INVALID_DATE_OF_DIAGNOSIS);
			}
		} else {
			errorFlag = true;
			errorList.set(4, ErrorConstant.INVALID_DATE_OF_DIAGNOSIS);
		}
	}

	/* DATE OF FOLLOW-UP Validation */
	public void validateDoF(String dateOfFollowUp,
			PatientDiagnosisDetailsTO patientDiagnosisDetailsTo) {
		if (dateOfFollowUp.matches("[0-9]{2}[-]{1}[a-zA-Z]{3}[-]{1}[0-9]{2}")
				&& dateOfFollowUp.length() == 9) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dof = sdf.parse(dateOfFollowUp);
				Calendar cal = Calendar.getInstance();
				Date now = cal.getTime();
				if (!dof.after(now)) {
					errorFlag = true;
					errorList.set(5, ErrorConstant.INVALID_DATE_OF_FOLLOWUP);
				} else {
					patientDiagnosisDetailsTo.setDateOfFollowUp(sdf1
							.format(dof));
				}

			} catch (ParseException e) {
				errorFlag = true;
				errorList.set(5, ErrorConstant.INVALID_DATE_OF_FOLLOWUP);
			}
		} else {
			errorFlag = true;
			errorList.set(5, ErrorConstant.INVALID_DATE_OF_FOLLOWUP);
		}
	}

	/* CARD NUMBER Validation */
	public void validateCard(String cardNumber,
			PatientDiagnosisDetailsTO patientDiagnosisDetailsTo) {
		if (isInputEmpty(cardNumber)) {
			errorFlag = true;
			errorList.set(8, ErrorConstant.EMPTY_CARD_NUMBER);
		} else {
			if (!cardNumber.matches("[0-9]{16}")) {
				errorFlag = true;
				errorList.set(8, ErrorConstant.INVALID_CARD_NUMBER);
			} else {
				patientDiagnosisDetailsTo.setModeOfPayment("Card");
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
