package com.hms.bo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.hms.constants.ErrorConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PatientTO;

/**
 * This class contains one testXXXX method per XXXXX method in source class
 * 
 * @author
 **/
// TODO Add Junit jar in build path.
// TODO Modify input and output data if needed.

public class EnrollPatientBOTest extends TestCase {

	@Test
	// Validate All
	public void testValidateAll() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Vedhikal");
		e0Arg1.setLastName("Mahesh");
		e0Arg1.setPassword("Mvedhu4$");
		e0Arg1.setDateOfBirth("28-jan-1993");
		e0Arg1.setEmailAddress("imvedhu@gmail.com");
		e0Arg1.setContactNumber("9998234561");
		e0Arg1.setFatherName("Samul");
		e0Arg1.setMotherName("Farida");
		e0Arg1.setPatientCurrentWeight("60");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhir");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Sakhir");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("Tamil Nadu");

		try {
			boolean res = e0Obj.validatePatient(e0Arg1);
			assertEquals(true, res);
		} catch (HmsBusinessException e) {
			fail();
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// FirstName Null
	public void testValidateFirstNamenull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName(null);
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_FIRSTNAME, errorlist.get(0));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// LastName Null
	public void testValidateLastNamenull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName(null);
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_LASTNAME, errorlist.get(1));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// Password Null
	public void testValidatePasswordnull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword(null);
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_PASSWORD, errorlist.get(2));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// Email Address Null
	public void testValidEmailAddnull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress(null);
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_EMAIL, errorlist.get(4));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// Date Of Birth Null
	public void testValidDateofbirthnull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth(null);
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_DOB, errorlist.get(3));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Father Name Null
	public void testValidateFathernameNull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName(null);
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_FATHERNAME, errorlist.get(6));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// MotherName Null
	public void testValidateMothernameNull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName(null);
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_MOTHERNAME, errorlist.get(7));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// CurrentWeight Null
	public void testValidateCurrentWeightNull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight(null);
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_WEIGHT, errorlist.get(8));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Spousename Null
	public void testValidateSpousenameNull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName(null);
		e0Arg1.setSpouseAge("35");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Ajay");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_SPOUSENAME, errorlist.get(9));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Spouseage Null
	public void testValidateSpouseageNull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge(null);
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Ajay");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_AGE, errorlist.get(10));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Childname1 Null
	public void testValidateChildname1Null() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1(null);
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_CHILDRENNAME1, errorlist.get(11));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Childname2 Null
	public void testValidateChildname2Null() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("prabha");
		e0Arg1.setChildrenName2(null);
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_CHILDRENNAME2, errorlist.get(12));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// Contact Null
	public void testValidateContactnull() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber(null);
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_CONTACT, errorlist.get(5));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// FirstName Invalid
	public void testValidateFirstNameInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Deivanayaki.");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FIRSTNAME, errorlist.get(0));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateFirstNameInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("$onia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FIRSTNAME, errorlist.get(0));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateFirstNameInvalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName(" ");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FIRSTNAME, errorlist.get(0));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// LastName Invalid
	public void testValidateLastNameInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName(".M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_LASTNAME, errorlist.get(1));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateLastNameInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("$onia M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_LASTNAME, errorlist.get(1));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateLastNameInvalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName(" ");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_LASTNAME, errorlist.get(1));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// Password Invalid
	public void testValidatePasswordInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("deiva");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_PASSWORD, errorlist.get(2));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidatePasswordInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Mson4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_PASSWORD, errorlist.get(2));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidatePasswordInvalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msoni$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_PASSWORD, errorlist.get(2));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// Dateofbirth Invalid
	public void testValidDateofbirthInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("12-02-2021");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_DOB, errorlist.get(3));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidDateofbirthInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("12-sep-93");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_DOB, errorlist.get(3));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// EmailAddress Invalid
	public void testValidEmailAddInvalid() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("deiva@@gma@il");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_EMAIL, errorlist.get(4));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Contact Invalid
	public void testValidateContactInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("82268@@@%");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CONTACT, errorlist.get(5));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateContactInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("+919952051");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CONTACT, errorlist.get(5));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Fathername Invalid
	public void testValidateFathernameInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("$gop65");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FATHERNAME, errorlist.get(6));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateFathernameInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName(" ");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FATHERNAME, errorlist.get(6));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateFathernameInvalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali.B");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_FATHERNAME, errorlist.get(6));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// MothernameInvalid
	public void testValidateMothernameInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("^hi7790");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_MOTHERNAME, errorlist.get(7));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateMothernameInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha.B.G.");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_MOTHERNAME, errorlist.get(7));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateMothernameInvalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName(" ");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_MOTHERNAME, errorlist.get(7));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// CurrentWeight Invalid
	public void testValidateCurrentWeightInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("-123");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_WEIGHT, errorlist.get(8));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateCurrentWeightInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("+93");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_WEIGHT, errorlist.get(8));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateCurrentWeightInvalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("9.6");
		e0Arg1.setMaritalStatus("no");
		e0Arg1.setSpouseName("-");
		e0Arg1.setSpouseAge("0");
		e0Arg1.setNoOfChildren("0");
		e0Arg1.setChildrenName1("-");
		e0Arg1.setChildrenName2("-");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_WEIGHT, errorlist.get(8));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Spousename Invalid
	public void testValidateSpousenameInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("@12345");
		e0Arg1.setSpouseAge("35");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Ajay");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_SPOUSENAME, errorlist.get(9));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateSpousenameInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Sundar.Y");
		e0Arg1.setSpouseAge("35");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Ajay");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_SPOUSENAME, errorlist.get(9));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateSpousenameInvalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName(" ");
		e0Arg1.setSpouseAge("35");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Ajay");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_SPOUSENAME, errorlist.get(9));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Spouseage Invalid
	public void testValidateSpouseageInvalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("-2");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Ajay");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_AGE, errorlist.get(10));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateSpouseageInvalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("55.");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Ajay");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_AGE, errorlist.get(10));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateSpouseageInvalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("+55");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Ajay");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_AGE, errorlist.get(10));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Childname1 Invalid
	public void testValidateChildname1Invalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("%234");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CHILDRENNAME1, errorlist.get(11));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateChildname1Invalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("Madhi.A");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CHILDRENNAME1, errorlist.get(11));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateChildname1Invalid3() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1(" ");
		e0Arg1.setChildrenName2("Adhil");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CHILDRENNAME1, errorlist.get(11));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	// Childname2 Invalid
	public void testValidateChildname2Invalid1() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("prabha");
		e0Arg1.setChildrenName2("#1234");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CHILDRENNAME2, errorlist.get(12));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateChildname2Invalid2() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1(" ");
		e0Arg1.setChildrenName2("#1234");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CHILDRENNAME2, errorlist.get(12));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	public void testValidateChildname2Invalid() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
		PatientTO e0Arg1 = new PatientTO();
		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");
		e0Arg1.setPassword("Msonia4$");
		e0Arg1.setDateOfBirth("28-sep-1993");
		e0Arg1.setEmailAddress("imsonia@gmail.com");
		e0Arg1.setContactNumber("9952051209");
		e0Arg1.setFatherName("Murali");
		e0Arg1.setMotherName("Nisha");
		e0Arg1.setPatientCurrentWeight("70");
		e0Arg1.setMaritalStatus("yes");
		e0Arg1.setSpouseName("Adhithya");
		e0Arg1.setSpouseAge("40");
		e0Arg1.setNoOfChildren("2");
		e0Arg1.setChildrenName1("prabha.A");
		e0Arg1.setChildrenName2("#1234");
		e0Arg1.setState("-");
		try {
			e0Obj.validatePatient(e0Arg1);
			fail();
		} catch (HmsBusinessException e) {
			List<String> errorlist = new ArrayList<String>();
			errorlist = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CHILDRENNAME2, errorlist.get(12));
		} catch (HmsApplicationException e) {
			fail();
		}
	}

	@Test
	// Valid Insurance
	public void testGetInsurance() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
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
	// Valid States
	public void testGetStates() {
		EnrollPatientBO e0Obj = new EnrollPatientBO();
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

}
