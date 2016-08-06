package com.hms.model;

public class PhysicianSearchTO {

	private String PhysicianId;
	private String PhysicianFirstName;
	private String PhysicianLastName;
	private String DepartmentName;
	private String EducationalQualification;
	private String YearsOfExcperience;
	private String State;
	private String InsurancePlan;
	private String ShiftTimings;

	public String getPhysicianId() {
		return PhysicianId;
	}

	public void setPhysicianId(String physicianId) {
		PhysicianId = physicianId;
	}

	public String getPhysicianFirstName() {
		return PhysicianFirstName;
	}

	public void setPhysicianFirstName(String physicianFirstName) {
		PhysicianFirstName = physicianFirstName;
	}

	public String getPhysicianLastName() {
		return PhysicianLastName;
	}

	public void setPhysicianLastName(String physicianLastName) {
		PhysicianLastName = physicianLastName;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public String getEducationalQualification() {
		return EducationalQualification;
	}

	public void setEducationalQualification(String educationalQualification) {
		EducationalQualification = educationalQualification;
	}

	public String getYearsOfExcperience() {
		return YearsOfExcperience;
	}

	public void setYearsOfExcperience(String yearsOfExcperience) {
		YearsOfExcperience = yearsOfExcperience;
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

	public String getShiftTimings() {
		return ShiftTimings;
	}

	public void setShiftTimings(String shiftTimings) {
		ShiftTimings = shiftTimings;
	}

	public PhysicianSearchTO(String physicianId, String physicianFirstName,
			String physicianLastName, String departmentName,
			String educationalQualification, String yearsOfExcperience,
			String state, String insurancePlan, String shiftTimings) {
		super();
		PhysicianId = physicianId;
		PhysicianFirstName = physicianFirstName;
		PhysicianLastName = physicianLastName;
		DepartmentName = departmentName;
		EducationalQualification = educationalQualification;
		YearsOfExcperience = yearsOfExcperience;
		State = state;
		InsurancePlan = insurancePlan;
		ShiftTimings = shiftTimings;
	}

	public PhysicianSearchTO() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((DepartmentName == null) ? 0 : DepartmentName.hashCode());
		result = prime
				* result
				+ ((EducationalQualification == null) ? 0
						: EducationalQualification.hashCode());
		result = prime * result
				+ ((InsurancePlan == null) ? 0 : InsurancePlan.hashCode());
		result = prime
				* result
				+ ((PhysicianFirstName == null) ? 0 : PhysicianFirstName
						.hashCode());
		result = prime * result
				+ ((PhysicianId == null) ? 0 : PhysicianId.hashCode());
		result = prime
				* result
				+ ((PhysicianLastName == null) ? 0 : PhysicianLastName
						.hashCode());
		result = prime * result
				+ ((ShiftTimings == null) ? 0 : ShiftTimings.hashCode());
		result = prime * result + ((State == null) ? 0 : State.hashCode());
		result = prime
				* result
				+ ((YearsOfExcperience == null) ? 0 : YearsOfExcperience
						.hashCode());
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
		PhysicianSearchTO other = (PhysicianSearchTO) obj;
		if (DepartmentName == null) {
			if (other.DepartmentName != null)
				return false;
		} else if (!DepartmentName.equals(other.DepartmentName))
			return false;
		if (EducationalQualification == null) {
			if (other.EducationalQualification != null)
				return false;
		} else if (!EducationalQualification
				.equals(other.EducationalQualification))
			return false;
		if (InsurancePlan == null) {
			if (other.InsurancePlan != null)
				return false;
		} else if (!InsurancePlan.equals(other.InsurancePlan))
			return false;
		if (PhysicianFirstName == null) {
			if (other.PhysicianFirstName != null)
				return false;
		} else if (!PhysicianFirstName.equals(other.PhysicianFirstName))
			return false;
		if (PhysicianId == null) {
			if (other.PhysicianId != null)
				return false;
		} else if (!PhysicianId.equals(other.PhysicianId))
			return false;
		if (PhysicianLastName == null) {
			if (other.PhysicianLastName != null)
				return false;
		} else if (!PhysicianLastName.equals(other.PhysicianLastName))
			return false;
		if (ShiftTimings == null) {
			if (other.ShiftTimings != null)
				return false;
		} else if (!ShiftTimings.equals(other.ShiftTimings))
			return false;
		if (State == null) {
			if (other.State != null)
				return false;
		} else if (!State.equals(other.State))
			return false;
		if (YearsOfExcperience == null) {
			if (other.YearsOfExcperience != null)
				return false;
		} else if (!YearsOfExcperience.equals(other.YearsOfExcperience))
			return false;
		return true;
	}

}
