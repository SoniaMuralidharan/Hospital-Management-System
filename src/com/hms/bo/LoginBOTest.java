package com.hms.bo;

import junit.framework.TestCase;

import org.junit.Test;

import com.hms.constants.ErrorConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.UserTO;

/**
 * This class contains one testXXXX method per XXXXX method in source class
 * 
 * @author
 **/
// TODO Add Junit jar in build path.
// TODO Modify input and output data if needed.

public class LoginBOTest extends TestCase {

	@Test
	// Both Valid1
	public void testValidateBothValid1() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();

		e0Arg0.setPassword("admin");
		e0Arg0.setUserName("root123");

		try {
			boolean res = e0Obj.validateUser(e0Arg0);
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
	// Both Valid2
	public void testValidateBothValid2() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();

		e0Arg0.setPassword("admin");
		e0Arg0.setUserName("sonia123");

		try {
			boolean res = e0Obj.validateUser(e0Arg0);
			assertEquals(true, res);

		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	// Both Valid3
	public void testValidateBothValid3() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();

		e0Arg0.setPassword("admin");
		e0Arg0.setUserName("rizwana123");

		try {
			boolean res = e0Obj.validateUser(e0Arg0);
			assertEquals(true, res);

		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	// Both Valid4
	public void testValidateBothValid4() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();

		e0Arg0.setPassword("admin");
		e0Arg0.setUserName("priya123");

		try {
			boolean res = e0Obj.validateUser(e0Arg0);
			assertEquals(true, res);

		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	// Both Valid5
	public void testValidateBothValid5() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();

		e0Arg0.setPassword("admin");
		e0Arg0.setUserName("mohit123");

		try {
			boolean res = e0Obj.validateUser(e0Arg0);
			assertEquals(true, res);

		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	// Both Valid6
	public void testValidateBothValid6() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();

		e0Arg0.setPassword("admin");
		e0Arg0.setUserName("dilip123");

		try {
			boolean res = e0Obj.validateUser(e0Arg0);
			assertEquals(true, res);

		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			fail();
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	// User Null
	public void testValidateUserNull() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();
		e0Arg0.setPassword("admin");
		e0Arg0.setUserName(null);

		try {
			e0Obj.validateUser(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			assertEquals(ErrorConstant.EMPTY_USERNAME, e.getMessage());
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Password Null
	public void testValidatePasswordNull() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();
		e0Arg0.setPassword(null);
		e0Arg0.setUserName("root123");

		try {
			e0Obj.validateUser(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			// TODO Auto-generated catch block
			assertEquals(ErrorConstant.EMPTY_PASSWORD, e.getMessage());
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// User Invalid
	public void testValidateInvalidUser() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();
		e0Arg0.setPassword(null);
		e0Arg0.setUserName(null);

		try {
			e0Obj.validateUser(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			assertEquals(ErrorConstant.EMPTY_ID_PASSWORD, e.getMessage());
		} catch (HmsApplicationException e) {
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Password Invalid
	public void testValidateInvalidPassword1() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();
		e0Arg0.setPassword("root");
		e0Arg0.setUserName("root123");

		try {
			e0Obj.validateUser(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			assertEquals(ErrorConstant.NOT_EXIST_PASSWORD, e.getMessage());
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	public void testValidateInvalidPassword2() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();
		e0Arg0.setPassword("root$");
		e0Arg0.setUserName("root123");

		try {
			e0Obj.validateUser(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			assertEquals(ErrorConstant.NOT_EXIST_PASSWORD, e.getMessage());
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

	@Test
	// Both Invalid
	public void testValidateBothInvalid() {
		LoginBO e0Obj = new LoginBO();
		UserTO e0Arg0 = new UserTO();
		e0Arg0.setPassword("root");
		e0Arg0.setUserName("root");

		try {
			e0Obj.validateUser(e0Arg0);
			fail();
		} catch (HmsBusinessException e) {
			assertEquals(ErrorConstant.INVALID_USERNAME, e.getMessage());
		} catch (HmsApplicationException e) {
			// TODO Auto-generated catch block
			fail();
		}
		// TODO Based on your need, provide necessary assertion condition
	}

}
