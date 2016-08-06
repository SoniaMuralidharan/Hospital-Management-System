package com.hms.bo;

import com.hms.constants.ErrorConstant;
import com.hms.dao.LoginDAO;
import com.hms.exceptions.HmsApplicationException;
import com.hms.exceptions.HmsBusinessException;
import com.hms.model.UserTO;

public class LoginBO {
	public boolean validateUser(UserTO userTo) throws HmsBusinessException,
			HmsApplicationException {

		String userName = userTo.getUserName();
		String password = userTo.getPassword();
		int userNameCount = 0, numberCount = 0, alphabetCount = 0;

		if (isInputEmpty(userName) && isInputEmpty(password)) {
			throw new HmsBusinessException(ErrorConstant.EMPTY_ID_PASSWORD);
		}

		if (isInputEmpty(userName) && !isInputEmpty(password)) {
			throw new HmsBusinessException(ErrorConstant.EMPTY_USERNAME);
		}

		if (!isInputEmpty(userName) && isInputEmpty(password)) {
			throw new HmsBusinessException(ErrorConstant.EMPTY_PASSWORD);
		}

		if (!isInputEmpty(userName)) {
			for (int i = 0; i < userName.length(); i++) {
				char c = userName.charAt(i);
				if (Character.isAlphabetic(c) || Character.isDigit(c)) {
					if (Character.isDigit(c)) {
						numberCount++;
					}

					if (Character.isAlphabetic(c)) {
						alphabetCount++;
					}
				} else {
					userNameCount++;
				}
			}
			if (userNameCount != 0 || numberCount == 0 || alphabetCount == 0) {
				throw new HmsBusinessException(ErrorConstant.INVALID_USERNAME);
			}
		}

		LoginDAO loginDao = new LoginDAO();
		int result = loginDao.validateUser(userTo);
		if (result == -1) {
			throw new HmsBusinessException(ErrorConstant.NOT_EXIST_USERNAME);
		} else if (result == -2) {
			throw new HmsBusinessException(ErrorConstant.NOT_EXIST_PASSWORD);
		}

		return true;
	}

	public boolean isInputEmpty(String input) {
		boolean empty = false;
		if (input == null || input.isEmpty()) {
			empty = true;
		}

		return empty;
	}

}
