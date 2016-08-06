package com.hms.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.hms.constants.ErrorConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PhysicianSearchTO;

/**
 * This class contains one testXXXX method per XXXXX method in source class
 * 
 * @author
 **/
// TODO Add Junit jar in build path.
// TODO Modify input and output data if needed.

public class PhysicianSearchBOTest extends TestCase {

	@Test
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testGetAll() throws HmsApplicationException, SQLException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();
		PhysicianSearchTO e0Arg0 = new PhysicianSearchTO();
		e0Arg0.setState("-");
		e0Arg0.setDepartmentName("-");
		e0Arg0.setPhysicianFirstName(null);
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setYearsOfExcperience(null);
		e0Arg0.setEducationalQualification(null);
		e0Arg0.setShiftTimings("-");
		e0Arg0.setInsurancePlan("-");
		e0Arg0.setPhysicianId(null);

		try {
			e0Obj.getAll(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.EMPTY_SEARCH_CRITERIA);
			assertEquals(elist, e.getErrorList());

		}
	}

	@Test
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testGetAllNotNullState() throws HmsApplicationException,
			SQLException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();
		PhysicianSearchTO e0Arg0 = new PhysicianSearchTO();
		e0Arg0.setState("Kerala");
		e0Arg0.setDepartmentName("-");
		e0Arg0.setPhysicianFirstName(null);
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setYearsOfExcperience(null);
		e0Arg0.setEducationalQualification(null);
		e0Arg0.setShiftTimings("-");
		e0Arg0.setInsurancePlan("-");
		e0Arg0.setPhysicianId(null);

		ArrayList<PhysicianSearchTO> pList = new ArrayList<PhysicianSearchTO>();
		pList.add(new PhysicianSearchTO("PR009", "Mohitha", "Nair",
				"Critical care", "MBChB", "6", "Kerala",
				"Apollo Munich Health Insurance", "Normal"));

		pList.add(new PhysicianSearchTO("PR033", "Sureka", "v", "Nephrology",
				"Mbbs", "2", "Kerala", "Reliance Health Insurance", "Night"));

		try {
			ArrayList<PhysicianSearchTO> e0 = e0Obj.getAll(e0Arg0);
			assertEquals(pList, e0);

		} catch (HmsBusinessException e) {
			fail();
		}
	}

	@Test
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testGetAllNotNullInsurance() throws HmsApplicationException,
			SQLException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();
		PhysicianSearchTO e0Arg0 = new PhysicianSearchTO();
		e0Arg0.setState("-");
		e0Arg0.setDepartmentName("-");
		e0Arg0.setPhysicianFirstName(null);
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setYearsOfExcperience(null);
		e0Arg0.setEducationalQualification(null);
		e0Arg0.setShiftTimings("-");
		e0Arg0.setInsurancePlan("TATA AIG Health Insurance");
		e0Arg0.setPhysicianId(null);

		ArrayList<PhysicianSearchTO> physicianList = new ArrayList<PhysicianSearchTO>();
		physicianList.add(new PhysicianSearchTO("PR004", "Ferly", "Alwin",
				"Ophthalmology", "Bachelor of Surgery", "4", "Pondicherry",
				"TATA AIG Health Insurance", "Morning"));
		try {
			ArrayList<PhysicianSearchTO> e0 = e0Obj.getAll(e0Arg0);
			assertEquals(physicianList, e0);

		} catch (HmsBusinessException e) {
			fail();
		}
	}

	@Test
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testGetAllNotNullDepartment() throws HmsApplicationException,
			SQLException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();
		PhysicianSearchTO e0Arg0 = new PhysicianSearchTO();
		e0Arg0.setState("-");
		e0Arg0.setDepartmentName("Critical care");
		e0Arg0.setPhysicianFirstName(null);
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setYearsOfExcperience(null);
		e0Arg0.setEducationalQualification(null);
		e0Arg0.setShiftTimings("-");
		e0Arg0.setInsurancePlan("-");
		e0Arg0.setPhysicianId(null);

		ArrayList<PhysicianSearchTO> physicianList = new ArrayList<PhysicianSearchTO>();

		physicianList.add(new PhysicianSearchTO("PR003", "Natraj",
				"Srinivasan", "Critical care", "Bachelor of Medicine", "1",
				"Nagaland", "Universal Sompo Health Insurance", "Normal"));
		physicianList.add(new PhysicianSearchTO("PR009", "Mohitha", "Nair",
				"Critical care", "MBChB", "6", "Kerala",
				"Apollo Munich Health Insurance", "Normal"));
		physicianList.add(new PhysicianSearchTO("PR027", "Abinaya", "Kalyan",
				"Critical care", "Doctor of Surgery", "3", "Delhi",
				"L&T Health Insurance", "Morning"));

		try {
			ArrayList<PhysicianSearchTO> e0 = e0Obj.getAll(e0Arg0);
			assertEquals(physicianList, e0);

		} catch (HmsBusinessException e) {
			fail();
		}
	}

	@Test
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testGetAllNotNullShift() throws HmsApplicationException,
			SQLException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();
		PhysicianSearchTO e0Arg0 = new PhysicianSearchTO();
		e0Arg0.setState("-");
		e0Arg0.setDepartmentName("-");
		e0Arg0.setPhysicianFirstName(null);
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setYearsOfExcperience(null);
		e0Arg0.setEducationalQualification(null);
		e0Arg0.setShiftTimings("Night");
		e0Arg0.setInsurancePlan("-");
		e0Arg0.setPhysicianId(null);

		ArrayList<PhysicianSearchTO> physicianList = new ArrayList<PhysicianSearchTO>();

		physicianList.add(new PhysicianSearchTO("PR010", "Guru ", "Rathnam",
				"General surgery", "Bachelor of Surgery", "4",
				"Andaman and Nicobar Islands",
				"ICICI Lombard Health Insurance", "Night"));
		physicianList.add(new PhysicianSearchTO("PR033", "Sureka", "v",
				"Nephrology", "Mbbs", "2", "Kerala",
				"Reliance Health Insurance", "Night"));

		try {
			ArrayList<PhysicianSearchTO> e0 = e0Obj.getAll(e0Arg0);
			System.out.println(physicianList.get(0));
			System.out.println(physicianList.get(1));
			assertEquals(physicianList, e0);

		} catch (HmsBusinessException e) {
			fail();
		}
	}

	@Test
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testgetSortFirstName() throws HmsApplicationException,
			SQLException, HmsBusinessException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();
		PhysicianSearchTO e0Arg0 = new PhysicianSearchTO();
		e0Arg0.setState("Kerala");
		e0Arg0.setDepartmentName("-");
		e0Arg0.setPhysicianFirstName(null);
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setYearsOfExcperience(null);
		e0Arg0.setEducationalQualification(null);
		e0Arg0.setShiftTimings("-");
		e0Arg0.setInsurancePlan("-");
		e0Arg0.setPhysicianId(null);

		ArrayList<PhysicianSearchTO> physicianList = new ArrayList<PhysicianSearchTO>();
		physicianList.add(new PhysicianSearchTO("PR009", "Mohitha", "Nair",
				"Critical care", "MBChB", "6", "Kerala",
				"Apollo Munich Health Insurance", "Normal"));

		physicianList.add(new PhysicianSearchTO("PR033", "Sureka", "v",
				"Nephrology", "Mbbs", "2", "Kerala",
				"Reliance Health Insurance", "Night"));

		try {
			ArrayList<PhysicianSearchTO> e0 = e0Obj.getSortFirstName(e0Arg0);

			assertEquals(physicianList, e0);
		} catch (HmsApplicationException e) {
			fail();

		}
	}

	@Test
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testgetSortLastName() throws HmsApplicationException,
			SQLException, HmsBusinessException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();
		PhysicianSearchTO e0Arg0 = new PhysicianSearchTO();
		e0Arg0.setState("Kerala");
		e0Arg0.setDepartmentName("-");
		e0Arg0.setPhysicianFirstName(null);
		e0Arg0.setPhysicianLastName(null);
		e0Arg0.setYearsOfExcperience(null);
		e0Arg0.setEducationalQualification(null);
		e0Arg0.setShiftTimings("-");
		e0Arg0.setInsurancePlan("-");
		e0Arg0.setPhysicianId(null);

		ArrayList<PhysicianSearchTO> physicianList = new ArrayList<PhysicianSearchTO>();

		physicianList.add(new PhysicianSearchTO("PR009", "Mohitha", "Nair",
				"Critical care", "MBChB", "6", "Kerala",
				"Apollo Munich Health Insurance", "Normal"));
		physicianList.add(new PhysicianSearchTO("PR033", "Sureka", "v",
				"Nephrology", "Mbbs", "2", "Kerala",
				"Reliance Health Insurance", "Night"));

		try {
			ArrayList<PhysicianSearchTO> e0 = e0Obj.getSortLastName(e0Arg0);

			assertEquals(physicianList, e0);
		} catch (HmsApplicationException e) {
			fail();

		}
	}

	@Test
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testGetStates() throws HmsApplicationException, SQLException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();

		try {
			List<String> e0 = e0Obj.getStates();
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
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testGetInsurance() throws HmsApplicationException, SQLException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();

		try {
			List<String> e0 = e0Obj.getInsurance();
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
	// public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO)
	public void testGetDepartment() throws HmsApplicationException,
			SQLException {
		PhysicianSearchBO e0Obj = new PhysicianSearchBO();

		try {
			List<String> e0 = e0Obj.getDepartment();
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
