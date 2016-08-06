package com.hms.model;

public class PatientDiagnosisDetailsTO {
	private String patientId;
	private int diagnosisId;
	private String symptoms;
	private String diagnosisProvided;
	private String administeredBy;
	private String dateOfDiagnosis;
	private String followUpRequired;
	private String dateOfFollowUp;
	private String billAmount;
	private String cardNumber;
	private String modeOfPayment;

	public PatientDiagnosisDetailsTO() {

	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosisProvided() {
		return diagnosisProvided;
	}

	public void setDiagnosisProvided(String diagnosisProvided) {
		this.diagnosisProvided = diagnosisProvided;
	}

	public String getAdministeredBy() {
		return administeredBy;
	}

	public void setAdministeredBy(String administeredBy) {
		this.administeredBy = administeredBy;
	}

	public String getDateOfDiagnosis() {
		return dateOfDiagnosis;
	}

	public void setDateOfDiagnosis(String dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}

	public String getFollowUpRequired() {
		return followUpRequired;
	}

	public void setFollowUpRequired(String followUpRequired) {
		this.followUpRequired = followUpRequired;
	}

	public String getDateOfFollowUp() {
		return dateOfFollowUp;
	}

	public void setDateOfFollowUp(String dateOfFollowUp) {
		this.dateOfFollowUp = dateOfFollowUp;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public PatientDiagnosisDetailsTO(String patientId, int diagnosisId,
			String symptoms, String diagnosisProvided, String administeredBy,
			String dateOfDiagnosis, String followUpRequired,
			String dateOfFollowUp, String billAmount, String cardNumber,
			String modeOfPayment) {
		super();
		this.patientId = patientId;
		this.diagnosisId = diagnosisId;
		this.symptoms = symptoms;
		this.diagnosisProvided = diagnosisProvided;
		this.administeredBy = administeredBy;
		this.dateOfDiagnosis = dateOfDiagnosis;
		this.followUpRequired = followUpRequired;
		this.dateOfFollowUp = dateOfFollowUp;
		this.billAmount = billAmount;
		this.cardNumber = cardNumber;
		this.modeOfPayment = modeOfPayment;
	}

	public PatientDiagnosisDetailsTO(String patientId, String symptoms,
			String diagnosisProvided, String administeredBy,
			String dateOfDiagnosis, String followUpRequired,
			String dateOfFollowUp, String billAmount, String cardNumber,
			String modeOfPayment) {
		super();
		this.patientId = patientId;
		this.symptoms = symptoms;
		this.diagnosisProvided = diagnosisProvided;
		this.administeredBy = administeredBy;
		this.dateOfDiagnosis = dateOfDiagnosis;
		this.followUpRequired = followUpRequired;
		this.dateOfFollowUp = dateOfFollowUp;
		this.billAmount = billAmount;
		this.cardNumber = cardNumber;
		this.modeOfPayment = modeOfPayment;
	}

}
