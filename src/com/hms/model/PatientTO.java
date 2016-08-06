package com.hms.model;

public class PatientTO {

	private int PatientId;
	private String FirstName;
	private String LastName;
	private String Password;
	private String DateOfBirth;
	private String EmailAddress;
	private String ContactNumber;
	private String FatherName;
	private String MotherName;
	private String PatientCurrentWeight;
	private String MaritalStatus;
	private String SpouseName;
	private String SpouseAge;
	private String NoOfChildren;
	private String ChildrenName1;
	private String ChildrenName2;
	private String State;
	private String InsurancePlan;

	public int getPatientId() {
		return PatientId;
	}

	public void setPatientId(int patientId) {
		PatientId = patientId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getMotherName() {
		return MotherName;
	}

	public void setMotherName(String motherName) {
		MotherName = motherName;
	}

	public String getPatientCurrentWeight() {
		return PatientCurrentWeight;
	}

	public void setPatientCurrentWeight(String patientCurrentWeight) {
		PatientCurrentWeight = patientCurrentWeight;
	}

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String getSpouseName() {
		return SpouseName;
	}

	public void setSpouseName(String spouseName) {
		SpouseName = spouseName;
	}

	public String getSpouseAge() {
		return SpouseAge;
	}

	public void setSpouseAge(String spouseAge) {
		SpouseAge = spouseAge;
	}

	public String getNoOfChildren() {
		return NoOfChildren;
	}

	public void setNoOfChildren(String noOfChildren) {
		NoOfChildren = noOfChildren;
	}

	public String getChildrenName1() {
		return ChildrenName1;
	}

	public void setChildrenName1(String childrenName1) {
		ChildrenName1 = childrenName1;
	}

	public String getChildrenName2() {
		return ChildrenName2;
	}

	public void setChildrenName2(String childrenName2) {
		ChildrenName2 = childrenName2;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getInsurancePlan() {
		return InsurancePlan;
	}

	public void setInsurancePlan(String insurancePlan) {
		InsurancePlan = insurancePlan;
	}

	public PatientTO(int patientId, String firstName, String lastName,
			String password, String dateOfBirth, String emailAddress,
			String contactNumber, String fatherName, String motherName,
			String patientCurrentWeight, String maritalStatus,
			String spouseName, String spouseAge, String noOfChildren,
			String childrenName1, String childrenName2, String state,
			String insurancePlan) {
		super();
		PatientId = patientId;
		FirstName = firstName;
		LastName = lastName;
		Password = password;
		DateOfBirth = dateOfBirth;
		EmailAddress = emailAddress;
		ContactNumber = contactNumber;
		FatherName = fatherName;
		MotherName = motherName;
		PatientCurrentWeight = patientCurrentWeight;
		MaritalStatus = maritalStatus;
		SpouseName = spouseName;
		SpouseAge = spouseAge;
		NoOfChildren = noOfChildren;
		ChildrenName1 = childrenName1;
		ChildrenName2 = childrenName2;
		State = state;
		InsurancePlan = insurancePlan;
	}

	public PatientTO(String firstName, String lastName, String password,
			String dateOfBirth, String emailAddress, String contactNumber,
			String fatherName, String motherName, String patientCurrentWeight,
			String maritalStatus, String spouseName, String spouseAge,
			String noOfChildren, String childrenName1, String childrenName2,
			String state, String insurancePlan) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Password = password;
		DateOfBirth = dateOfBirth;
		EmailAddress = emailAddress;
		ContactNumber = contactNumber;
		FatherName = fatherName;
		MotherName = motherName;
		PatientCurrentWeight = patientCurrentWeight;
		MaritalStatus = maritalStatus;
		SpouseName = spouseName;
		SpouseAge = spouseAge;
		NoOfChildren = noOfChildren;
		ChildrenName1 = childrenName1;
		ChildrenName2 = childrenName2;
		State = state;
		InsurancePlan = insurancePlan;
	}

	public PatientTO() {

	}

}
