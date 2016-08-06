package com.hms.bo;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import com.hms.constants.ErrorConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.HistoryTO;
import com.hms.model.PatientTO;

/**
 * This class contains one testXXXX method per XXXXX method in source class
 * 
 * @author
 **/
// TODO Add Junit jar in build path.
// TODO Modify input and output data if needed.

public class PatientHistoryBOTest extends TestCase {

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testFNLNValid() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setId(0);
		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M");

		ArrayList<HistoryTO> historyList = new ArrayList<HistoryTO>();
		historyList.add(new HistoryTO(1, "1001", "redness of skin",
				"moisturizer,ointment", "Rakesh kanna",
				"2016-05-21 00:00:00.0", "yes", "2016-07-30 00:00:00.0",
				"52000", "-", "Cash"));

		historyList.add(new HistoryTO(31, "1001", "redness of skin",
				"moisturizer,ointment", "Kumar", "2016-05-21 00:00:00.0",
				"yes", "2016-07-30 00:00:00.0", "52000", "-", "Cash"));

		historyList.add(new HistoryTO(32, "1001", "redness of skin, burn",
				"moisturizer,ointment", "Krishnan", "2016-05-21 00:00:00.0",
				"yes", "2016-07-30 00:00:00.0", "52000", "-", "Cash"));

		try {
			ArrayList<HistoryTO> e0 = e0Obj.getFNLN(e0Arg1, e0Arg0);
			for (HistoryTO historyTo : e0) {
				System.out.println(historyTo);

			}
			assertEquals(historyList, e0);

		} catch (HmsBusinessException e) {
			fail();
		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testPatientIdValid() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();

		e0Arg0.setId(0);
		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id("1001");
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		ArrayList<HistoryTO> historyList = new ArrayList<HistoryTO>();
		historyList.add(new HistoryTO(1, "1001", "redness of skin",
				"moisturizer,ointment", "Rakesh kanna",
				"2016-05-21 00:00:00.0", "yes", "2016-07-30 00:00:00.0",
				"52000", "-", "Cash"));

		historyList.add(new HistoryTO(31, "1001", "redness of skin",
				"moisturizer,ointment", "Kumar", "2016-05-21 00:00:00.0",
				"yes", "2016-07-30 00:00:00.0", "52000", "-", "Cash"));

		historyList.add(new HistoryTO(32, "1001", "redness of skin, burn",
				"moisturizer,ointment", "Krishnan", "2016-05-21 00:00:00.0",
				"yes", "2016-07-30 00:00:00.0", "52000", "-", "Cash"));

		try {
			ArrayList<HistoryTO> e0 = e0Obj.getAll(e0Arg0);
			assertEquals(historyList, e0);

		} catch (HmsBusinessException e) {
			fail();
		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testPatientIdInvalid1() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();

		e0Arg0.setId(0);
		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id("001");
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		try {
			e0Obj.getAll(e0Arg0);
			fail();

		} catch (HmsBusinessException e) {
			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_PATIENTID);
			assertEquals(elist.get(0), e.getErrorList().get(0));
		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testPatientIdInvalid2() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();

		e0Arg0.setId(0);
		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id("Sonia");
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		try {
			e0Obj.getAll(e0Arg0);
			fail();

		} catch (HmsBusinessException e) {
			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_PATIENTID);
			assertEquals(elist.get(0), e.getErrorList().get(0));
		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testPatientIdInvalid3() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();

		e0Arg0.setId(0);
		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id("$onia");
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		try {
			e0Obj.getAll(e0Arg0);
			fail();

		} catch (HmsBusinessException e) {
			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_PATIENTID);
			assertEquals(elist.get(0), e.getErrorList().get(0));
		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testPatientIdNull() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		try {
			e0Obj.getAll(e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.EMPTY_PATIENTID);
			assertEquals(elist.get(0), e.getErrorList().get(0));

		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testFirstNameNull() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName(null);
		e0Arg1.setLastName("M");

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.EMPTY_FIRSTNAME);
			assertEquals(elist.get(0), e.getErrorList().get(1));

		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testLastNameNull() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName(null);

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.EMPTY_LASTNAME);
			assertEquals(elist.get(0), e.getErrorList().get(2));

		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testFNLNNull() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName(null);
		e0Arg1.setLastName(null);

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.EMPTY_FNLN);
			assertEquals(elist.get(0), e.getErrorList().get(1));

		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testFirstNameInvalid1() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName("Sonia.M");
		e0Arg1.setLastName("M");

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_FIRSTNAME);
			assertEquals(elist.get(0), e.getErrorList().get(1));

		}
	}

	public void testFirstNameInvalid2() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName(" ");
		e0Arg1.setLastName("M");

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_FIRSTNAME);
			assertEquals(elist.get(0), e.getErrorList().get(1));

		}
	}

	public void testFirstNameInvalid3() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName("$onia.M");
		e0Arg1.setLastName("M");

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_FIRSTNAME);
			assertEquals(elist.get(0), e.getErrorList().get(1));

		}
	}

	@Test
	// public ArrayList<HistoryTO> getAll(HistoryTO)
	public void testLastNameInvalid1() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("Murali.B");

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_LASTNAME);
			assertEquals(elist.get(0), e.getErrorList().get(2));

		}
	}

	public void testLastNameInvalid2() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName(" ");

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_LASTNAME);
			assertEquals(elist.get(0), e.getErrorList().get(2));

		}
	}

	public void testLastNameInvalid3() throws HmsApplicationException {
		PatientHistoryBO e0Obj = new PatientHistoryBO();
		HistoryTO e0Arg0 = new HistoryTO();
		PatientTO e0Arg1 = new PatientTO();

		e0Arg0.setDiagnosis(null);
		e0Arg0.setSymptoms(null);
		e0Arg0.setFollow_up_req(null);
		e0Arg0.setPatient_id(null);
		e0Arg0.setCard_number(null);
		e0Arg0.setBill_amount(null);
		e0Arg0.setPayment_mode(null);
		e0Arg0.setAdministered_by(null);
		e0Arg0.setDate_of_diagnosis(null);
		e0Arg0.setDate_of_follow_up(null);

		e0Arg1.setFirstName("Sonia");
		e0Arg1.setLastName("M$");

		try {
			e0Obj.getFNLN(e0Arg1, e0Arg0);
			// TODO Based on your need, provide necessary assertion condition
			fail();

		} catch (HmsBusinessException e) {

			ArrayList<String> elist = new ArrayList<String>();
			elist.add(ErrorConstant.INVALID_LASTNAME);
			assertEquals(elist.get(0), e.getErrorList().get(2));

		}
	}
}
