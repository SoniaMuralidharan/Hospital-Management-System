package com.hms.bo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.hms.constants.ErrorConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PhysicianTO;

/**
 * This class contains one testXXXX method per XXXXX method in source class
 * 
 * @author
 **/
// TODO Add Junit jar in build path.
// TODO Modify input and output data if needed.

public class AddPhysicianBOTest extends TestCase {

	@Test
	// Validate All
	public void testValidateAll() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();

		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Malathi");
		e0Arg0.setPhysicianLastName("Shakthi");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");
		e0Arg0.setInsurancePlan("-");

		try {
			boolean res = e0Obj.validatePhysician(e0Arg0);
			assertEquals(true, res);

		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Firstname Null
	public void testValidateFirstnameNull() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName(null);
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_FIRSTNAME, errorList.get(0));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Lastname Null
	public void testValidateLastnameNull() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_LASTNAME, errorList.get(1));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Department Null
	public void testValidateDepartmentNull() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Normal Shift");
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName("-");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_DEPARTMENT, errorList.get(2));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Qualification Null
	public void testValidateQualificationNull() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification(null);

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_QUALIFICATION, errorList.get(3));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Experience Null
	public void testValidateExperienceNull() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience(null);
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_EXPERIENCE, errorList.get(4));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// State Null
	public void testValidateStateNull() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("-");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("kumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_STATE, errorList.get(5));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Shift Null
	public void testValidateShiftNull() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("-");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_SHIFT, errorList.get(6));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Firstname Invalid
	public void testValidateFirstnameInvalid1() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Radhika.S");
		e0Arg0.setPhysicianLastName("SarathKumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FIRSTNAME, errorList.get(0));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateFirstnameInvalid2() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Radhika.$");
		e0Arg0.setPhysicianLastName("SarathKumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FIRSTNAME, errorList.get(0));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateFirstnameInvalid3() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName(" ");
		e0Arg0.setPhysicianLastName("SarathKumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FIRSTNAME, errorList.get(0));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Lastname Invalid
	public void testValidateLastnameInvalid1() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar.L.S.");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_LASTNAME, errorList.get(1));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateLastnameInvalid2() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar.L.$.");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_LASTNAME, errorList.get(1));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateLastnameInvalid3() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName(" ");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_LASTNAME, errorList.get(1));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Qualification Invalid
	public void testValidateQualificationInvalid1() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("B.E. - Engineering");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_QUALIFICATION, errorList.get(3));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateQualificationInvalid2() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName("Orthopaedic$");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("B.E. - Engineering");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_QUALIFICATION, errorList.get(3));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateQualificationInvalid3() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName(" ");
		e0Arg0.setYearsOfExcperience("2");
		e0Arg0.setEducationalQualification("B.E. - Engineering");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_QUALIFICATION, errorList.get(3));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Experience Invalid
	public void testValidateExperienceInvalid1() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("-2");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_EXPERIENCE, errorList.get(4));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateExperienceInvalid2() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		PhysicianTO e0Arg0 = new PhysicianTO();
		e0Arg0.setState("Tamil Nadu");
		e0Arg0.setShift("Normal");
		e0Arg0.setPhysicianFirstName("Senthil");
		e0Arg0.setPhysicianLastName("Kumar");
		e0Arg0.setDepartmentName("Orthopaedics");
		e0Arg0.setYearsOfExcperience("2.");
		e0Arg0.setEducationalQualification("BMBS");

		try {
			e0Obj.validatePhysician(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_EXPERIENCE, errorList.get(4));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Valid States
	public void testGetStates() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		List<String> e0 = null;

		try {
			e0 = e0Obj.getStates();
			ArrayList<String> elist = new ArrayList<String>();
			elist.add("Andaman and Nicobar Islands");
			elist.add("Andhra Pradesh");
			elist.add("Arunachal Pradesh");
			elist.add("Assam");
			elist.add("Bihar");
			elist.add("Chandigarh");
			elist.add("Chhattisgarh");
			elist.add("Dadra and Nagar Haveli");
			elist.add("Daman and Diu");
			elist.add("Delhi");
			elist.add("Goa");
			elist.add("Gujarat");
			elist.add("Haryana");
			elist.add("Himachal Pradesh");
			elist.add("Jammu and Kashmir");
			elist.add("Jharkhand");
			elist.add("Karnataka");
			elist.add("Kenmore");
			elist.add("Kerala");
			elist.add("Lakshadweep");
			elist.add("Madhya Pradesh");
			elist.add("Maharashtra");
			elist.add("Manipur");
			elist.add("Meghalaya");
			elist.add("Mizoram");
			elist.add("Nagaland");
			elist.add("Narora");
			elist.add("Natwar");
			elist.add("Odisha");
			elist.add("Paschim Medinipur");
			elist.add("Pondicherry");
			elist.add("Punjab");
			elist.add("Rajasthan");
			elist.add("Sikkim");
			elist.add("Tamil Nadu");
			elist.add("Telangana");
			elist.add("Tripura");
			elist.add("Uttar Pradesh");
			elist.add("Uttarakhand");
			elist.add("Vaishali");
			elist.add("West Bengal");

			assertEquals(elist, e0);

		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// Valid Insurance
	public void testGetInsurance() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		List<String> e0 = null;

		try {
			e0 = e0Obj.getInsurance();
			ArrayList<String> elist = new ArrayList<String>();
			elist.add("Religare Health Insurance");
			elist.add("BAJAJ ALLIANZ Health Insurance");
			elist.add("Star Health Insurance");
			elist.add("BHARTI AXA Health Insurance");
			elist.add("Apollo Munich Health Insurance");
			elist.add("CignaTTK Health Insurance");
			elist.add("HDFC ERGO Health Insurance");
			elist.add("IFFCO Tokio Health Insurance");
			elist.add("L&T Health Insurance");
			elist.add("Max Bupa Health Insurance");
			elist.add("New India Health Insurance");
			elist.add("Universal Sompo Health Insurance");
			elist.add("ICICI Lombard Health Insurance");
			elist.add("National Health Insurance");
			elist.add("Oriental Health Insurance");
			elist.add("Reliance Health Insurance");
			elist.add("Royal Sundaram Health Insurance");
			elist.add("SBI Health Insurance");
			elist.add("TATA AIG Health Insurance");
			elist.add("Future Generali Health Insurance");
			elist.add("United India Health Insurance");
			elist.add("Chola MS Health Insurance");

			assertEquals(elist, e0);

		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// valid Department
	public void testGetDepartment() {
		AddPhysicianBO e0Obj = new AddPhysicianBO();
		List<String> e0 = null;

		try {
			e0 = e0Obj.getDepartment();
			ArrayList<String> elist = new ArrayList<String>();

			elist.add("Accident and emergency");
			elist.add("Anaesthetics");
			elist.add("Breast screening");
			elist.add("Cardiology");
			elist.add("Chaplaincy");
			elist.add("Critical care");
			elist.add("Diagnostic imaging");
			elist.add("Discharge lounge");
			elist.add("Ear nose and throat ENT");
			elist.add("Elderly services department");
			elist.add("Gastroenterology");
			elist.add("Endoscopy");
			elist.add("General surgery");
			elist.add("Gynaecology");
			elist.add("Haematology");
			elist.add("Maternity departments");
			elist.add("Microbiology");
			elist.add("Neonatal unit");
			elist.add("Nephrology");
			elist.add("Neurology");
			elist.add("Nutrition and dietetics");
			elist.add("Obstetrics and gynaecology units");
			elist.add("Occupational therapy");
			elist.add("Oncology");
			elist.add("Ophthalmology");
			elist.add("Orthopaedics");
			elist.add("Pain management clinics");
			elist.add("Pharmacy");
			elist.add("Physiotherapy");
			elist.add("Radiotherapy");
			elist.add("Renal unit");
			elist.add("Rheumatology");
			elist.add("Sexual health genitourinary medicine");
			elist.add("Urology");

			assertEquals(elist, e0);

		} catch (HmsApplicationException e) {
			fail();
		}
	}
}
