package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hms.constants.QueryConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.model.PatientTO;
import com.hms.utils.DbUtil;

public class EnrollPatientDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public int validatePatient(PatientTO patientTo)
			throws HmsApplicationException {
		int result = 0;
		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.INSERT_PATIENT);
			pstatement.setLong(1, patientTo.getPatientId());
			pstatement.setString(2, patientTo.getFirstName());
			pstatement.setString(3, patientTo.getLastName());
			pstatement.setString(4, patientTo.getPassword());
			pstatement.setString(5, patientTo.getDateOfBirth());
			pstatement.setString(6, patientTo.getEmailAddress());
			pstatement.setString(7, patientTo.getContactNumber());
			pstatement.setString(8, patientTo.getState());
			pstatement.setString(9, patientTo.getInsurancePlan());
			pstatement.setString(10, patientTo.getFatherName());
			pstatement.setString(11, patientTo.getMotherName());
			pstatement.setString(12, patientTo.getPatientCurrentWeight());
			pstatement.setString(13, patientTo.getMaritalStatus());
			pstatement.setString(14, patientTo.getSpouseName());
			pstatement.setString(15, patientTo.getSpouseAge());
			pstatement.setString(16, patientTo.getNoOfChildren());
			pstatement.setString(17, patientTo.getChildrenName1());
			pstatement.setString(18, patientTo.getChildrenName2());

			pstatement.executeUpdate();

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

	public int validateExistingPatient(PatientTO patientTo)
			throws HmsApplicationException {
		int result = 0;
		try {
			connection = DbUtil.getconnection();
			pstatement = connection.prepareStatement(QueryConstant.GET_PATIENT);
			pstatement.setString(1, patientTo.getFirstName());
			pstatement.setString(2, patientTo.getLastName());
			pstatement.setString(3, patientTo.getFatherName());
			pstatement.setString(4, patientTo.getMotherName());
			resultSet = pstatement.executeQuery();

			if (resultSet.next()) {
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String fatherName = resultSet.getString("fathername");
				String motherName = resultSet.getString("mothername");

				if (firstName.equalsIgnoreCase(patientTo.getFirstName())
						&& fatherName.equalsIgnoreCase(patientTo
								.getFatherName())
						&& lastName.equalsIgnoreCase(patientTo.getLastName())
						&& motherName.equalsIgnoreCase(patientTo
								.getMotherName())) {
					result = -1;
				} else {
					result = -2;
				}
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

	/* Generate Id */
	public int generatePatientId() throws HmsApplicationException {
		int id = 0;
		try {
			connection = DbUtil.getconnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstant.GET_PATIENTID);
			if (resultSet.next()) {
				id = resultSet.getInt("pid");
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

		return id;
	}

	public List<String> getStates() throws HmsApplicationException {
		List<String> stateList = new ArrayList<String>();
		try {
			connection = DbUtil.getconnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstant.GET_STATES);
			stateList = getResult(resultSet);

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
		return stateList;

	}

	public List<String> getInsurance() throws HmsApplicationException {
		List<String> insuranceList = new ArrayList<String>();
		try {
			connection = DbUtil.getconnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstant.GET_INSURANCE);
			insuranceList = getResult(resultSet);

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
		return insuranceList;

	}

	public List<String> getResult(ResultSet resultSet)
			throws HmsApplicationException {
		ArrayList<String> resultList = new ArrayList<String>();

		try {
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				resultList.add(name);
			}
		} catch (SQLException e) {
			throw new HmsApplicationException(e);
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				throw new HmsApplicationException(e);
			}
		}

		return resultList;

	}

	private void closeConnection() throws SQLException {

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
