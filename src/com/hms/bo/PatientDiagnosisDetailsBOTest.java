package com.hms.bo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.hms.constants.ErrorConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.PatientDiagnosisDetailsTO;

/**
 * This class contains one testXXXX method per XXXXX method in source class
 * 
 * @author
 **/
// TODO Add Junit jar in build path.
// TODO Modify input and output data if needed.

public class PatientDiagnosisDetailsBOTest extends TestCase {

	@Test
	// Validate All
	public void testValidateAll() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("cash");
		e0Arg0.setPatientId("1002");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			boolean res = e0Obj.validatePatientDiagnosis(e0Arg0);
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
	// PatientId Null
	public void testValidatePatientIdNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId(null);
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_PATIENTID, errorList.get(0));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Symptoms Null
	public void testValidateSymptomsNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms(null);
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_SYMPTOMS, errorList.get(1));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Diagnosis Null
	public void testValidateDiagnosisNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided(null);
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_DIAGNOSISPROVIDED,
					errorList.get(2));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Administered Null
	public void testValidateAdministeredNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy(null);
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_ADMISTERED_BY, errorList.get(3));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Date of Diagnosis Null
	public void testValidateDoDNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh Khanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis(null);
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_DATE_OF_DIAGNOSIS,
					errorList.get(4));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// FollowUp Null
	public void testValidateFollowupYesNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp(null);
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_DATE_OF_FOLLOWUP, errorList.get(5));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Billing Null
	public void testValidateBillNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount(null);
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_BILL_AMOUNT, errorList.get(6));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Mode of Payment Null
	public void testValidateModeNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment(null);
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_MODE_OF_PAYMENT, errorList.get(7));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Card Null
	public void testValidateCardNull() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber(null);
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Card");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.EMPTY_CARD_NUMBER, errorList.get(8));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Symptoms Invalid
	public void testValidateSymptomsInvalid1() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness-of-skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_SYMPTOMS, errorList.get(1));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateSymptomsInvalid2() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms(" ");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_SYMPTOMS, errorList.get(1));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateSymptomsInvalid3() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness-of-$kin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_SYMPTOMS, errorList.get(1));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Diagnosis Invalid
	public void testValidateDiagnosisInvalid1() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment..");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_DIAGNOSISPROVIDED,
					errorList.get(2));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateDiagnosisInvalid2() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moi$turizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_DIAGNOSISPROVIDED,
					errorList.get(2));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateDiagnosisInvalid3() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided(" ");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_DIAGNOSISPROVIDED,
					errorList.get(2));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Administered Invalid
	public void testValidateAdministeredInvalid1() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("K.S.Ravi kumar");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_ADMINISTERDBY, errorList.get(3));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateAdministeredInvalid2() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy(" ");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_ADMINISTERDBY, errorList.get(3));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateAdministeredInvalid() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("K $ Ravi kumar");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_ADMINISTERDBY, errorList.get(3));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Date of Diagnosis Invalid
	public void testValidateDoDInvalid() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh Khanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("9-jun-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_DATE_OF_DIAGNOSIS,
					errorList.get(4));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// FollowUp Invalid
	public void testValidateFollowupYesInvalid() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("9-jun-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_DATE_OF_FOLLOWUP,
					errorList.get(5));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Billing Invalid
	public void testValidateBillInvalid1() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("Rs.50000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_BILL_AMOUNT, errorList.get(6));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateBillInvalid2() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("50");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_BILL_AMOUNT, errorList.get(6));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateBillInvalid3() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("+50000");
		e0Arg0.setModeOfPayment("Cash");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_BILL_AMOUNT, errorList.get(6));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Mode of Payment Invalid
	public void testValidateModeInvalid1() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Cash on hand");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_MODE_OF_PAYMENT,
					errorList.get(7));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateModeInvalid2() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("-");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Ca$h");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_MODE_OF_PAYMENT,
					errorList.get(7));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Card Invalid
	public void testValidateCardInvalid1() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("1234-1298-9087-1");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Card");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CARD_NUMBER, errorList.get(8));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateCardInvalid2() {
		PatientDiagnosisDetailsBO e0Obj = new PatientDiagnosisDetailsBO();
		PatientDiagnosisDetailsTO e0Arg0 = new PatientDiagnosisDetailsTO();

		e0Arg0.setAdministeredBy("Rakesh kanna");
		e0Arg0.setDateOfFollowUp("30-jul-16");
		e0Arg0.setDateOfDiagnosis("21-may-16");
		e0Arg0.setCardNumber("jksdhkhsdkjghj34");
		e0Arg0.setSymptoms("redness of skin");
		e0Arg0.setBillAmount("52000");
		e0Arg0.setModeOfPayment("Card");
		e0Arg0.setPatientId("1001");
		e0Arg0.setDiagnosisProvided("moisturizer,ointment");
		e0Arg0.setFollowUpRequired("yes");

		try {
			e0Obj.validatePatientDiagnosis(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			List<String> errorList = new ArrayList<String>();
			errorList = e.getErrorList();
			assertEquals(ErrorConstant.INVALID_CARD_NUMBER, errorList.get(8));
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

}
