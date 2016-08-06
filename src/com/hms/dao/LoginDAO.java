package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hms.constants.QueryConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.model.UserTO;
import com.hms.utils.DbUtil;

public class LoginDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public int validateUser(UserTO userTo) throws HmsApplicationException {
		int result = 0;
		try {
			connection = DbUtil.getconnection();
			pstatement = connection.prepareStatement(QueryConstant.GET_USER);
			pstatement.setString(1, userTo.getUserName());
			resultSet = pstatement.executeQuery();
			if (resultSet.next()) {
				String pass = resultSet.getString("adminpassword");
				if (!pass.equals(userTo.getPassword())) {
					result = -2;
				}
			} else {
				result = -1;
			}

		} catch (ClassNotFoundException e) {
			throw new HmsApplicationException(e);
		} catch (SQLException e) {
			throw new HmsApplicationException(e);
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				throw new HmsApplicationException(e);
			}
		}

		return result;
	}

	private void closeConnection() throws SQLException {
		if (resultSet != null) {

			resultSet.close();
		}
		if (pstatement != null) {
			pstatement.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
