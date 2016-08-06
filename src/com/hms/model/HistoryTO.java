package com.hms.model;

public class HistoryTO {

	@Override
	public String toString() {
		return "HistoryTO [id=" + id + ", patient_id=" + patient_id
				+ ", symptoms=" + symptoms + ", diagnosis=" + diagnosis
				+ ", administered_by=" + administered_by
				+ ", date_of_diagnosis=" + date_of_diagnosis
				+ ", follow_up_req=" + follow_up_req + ", date_of_follow_up="
				+ date_of_follow_up + ", bill_amount=" + bill_amount
				+ ", card_number=" + card_number + ", payment_mode="
				+ payment_mode + "]";
	}

	private int id;
	private String patient_id;
	private String symptoms;
	private String diagnosis;
	private String administered_by;
	private String date_of_diagnosis;
	private String follow_up_req;
	private String date_of_follow_up;
	private String bill_amount;
	private String card_number;
	private String payment_mode;

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patientId) {
		this.patient_id = patientId;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdministered_by() {
		return administered_by;
	}

	public void setAdministered_by(String administered_by) {
		this.administered_by = administered_by;
	}

	public String getDate_of_diagnosis() {
		return date_of_diagnosis;
	}

	public void setDate_of_diagnosis(String date_of_diagnosis) {
		this.date_of_diagnosis = date_of_diagnosis;
	}

	public String getFollow_up_req() {
		return follow_up_req;
	}

	public void setFollow_up_req(String follow_up_req) {
		this.follow_up_req = follow_up_req;
	}

	public String getDate_of_follow_up() {
		return date_of_follow_up;
	}

	public void setDate_of_follow_up(String date_of_follow_up) {
		this.date_of_follow_up = date_of_follow_up;
	}

	public String getBill_amount() {
		return bill_amount;
	}

	public void setBill_amount(String bill_amount) {
		this.bill_amount = bill_amount;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public HistoryTO(int id, String patient_id, String symptoms,
			String diagnosis, String administered_by, String date_of_diagnosis,
			String follow_up_req, String date_of_follow_up, String bill_amount,
			String card_number, String payment_mode) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.administered_by = administered_by;
		this.date_of_diagnosis = date_of_diagnosis;
		this.follow_up_req = follow_up_req;
		this.date_of_follow_up = date_of_follow_up;
		this.bill_amount = bill_amount;
		this.card_number = card_number;
		this.payment_mode = payment_mode;
	}

	public HistoryTO() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((administered_by == null) ? 0 : administered_by.hashCode());
		result = prime * result
				+ ((bill_amount == null) ? 0 : bill_amount.hashCode());
		result = prime * result
				+ ((card_number == null) ? 0 : card_number.hashCode());
		result = prime
				* result
				+ ((date_of_diagnosis == null) ? 0 : date_of_diagnosis
						.hashCode());
		result = prime
				* result
				+ ((date_of_follow_up == null) ? 0 : date_of_follow_up
						.hashCode());
		result = prime * result
				+ ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result
				+ ((follow_up_req == null) ? 0 : follow_up_req.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((patient_id == null) ? 0 : patient_id.hashCode());
		result = prime * result
				+ ((payment_mode == null) ? 0 : payment_mode.hashCode());
		result = prime * result
				+ ((symptoms == null) ? 0 : symptoms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryTO other = (HistoryTO) obj;
		if (administered_by == null) {
			if (other.administered_by != null)
				return false;
		} else if (!administered_by.equals(other.administered_by))
			return false;
		if (bill_amount == null) {
			if (other.bill_amount != null)
				return false;
		} else if (!bill_amount.equals(other.bill_amount))
			return false;
		if (card_number == null) {
			if (other.card_number != null)
				return false;
		} else if (!card_number.equals(other.card_number))
			return false;
		if (date_of_diagnosis == null) {
			if (other.date_of_diagnosis != null)
				return false;
		} else if (!date_of_diagnosis.equals(other.date_of_diagnosis))
			return false;
		if (date_of_follow_up == null) {
			if (other.date_of_follow_up != null)
				return false;
		} else if (!date_of_follow_up.equals(other.date_of_follow_up))
			return false;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (follow_up_req == null) {
			if (other.follow_up_req != null)
				return false;
		} else if (!follow_up_req.equals(other.follow_up_req))
			return false;
		if (id != other.id)
			return false;
		if (patient_id == null) {
			if (other.patient_id != null)
				return false;
		} else if (!patient_id.equals(other.patient_id))
			return false;
		if (payment_mode == null) {
			if (other.payment_mode != null)
				return false;
		} else if (!payment_mode.equals(other.payment_mode))
			return false;
		if (symptoms == null) {
			if (other.symptoms != null)
				return false;
		} else if (!symptoms.equals(other.symptoms))
			return false;
		return true;
	}

}
