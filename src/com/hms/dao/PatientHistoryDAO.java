package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hms.constants.QueryConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.model.HistoryTO;
import com.hms.model.PatientTO;
import com.hms.utils.DbUtil;

public class PatientHistoryDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<HistoryTO> getAll(HistoryTO historyTo)
			throws HmsApplicationException {

		ArrayList<HistoryTO> patientHistoryToList = new ArrayList<HistoryTO>();

		try {
			connection = DbUtil.getconnection();
			pstatement = connection.prepareStatement(
					QueryConstant.SEARCH_PATIENT,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			pstatement.setString(1, historyTo.getPatient_id());
			resultSet = pstatement.executeQuery();

			patientHistoryToList = getResult(resultSet);

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

		return patientHistoryToList;
	}

	public ArrayList<HistoryTO> getFNLN(PatientTO patientTo, HistoryTO historyTo)
			throws HmsApplicationException {

		ArrayList<HistoryTO> patientHistoryToList = new ArrayList<HistoryTO>();

		try {
			connection = DbUtil.getconnection();
			pstatement = connection.prepareStatement(
					QueryConstant.SEARCH_PATIENT_FNLN,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			pstatement.setString(1, patientTo.getFirstName());
			pstatement.setString(2, patientTo.getLastName());
			resultSet = pstatement.executeQuery();

			String id = null;

			while (resultSet.next()) {
				PatientTO patientTO = new PatientTO();
				id = Integer.toString(resultSet.getInt("pid"));
				patientTO.setPatientId(resultSet.getInt("pid"));
			}

			pstatement = connection.prepareStatement(
					QueryConstant.SEARCH_PATIENT,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			pstatement.setString(1, id);
			resultSet = pstatement.executeQuery();
			patientHistoryToList = getResult(resultSet);

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

		return patientHistoryToList;
	}

	private ArrayList<HistoryTO> getResult(ResultSet resultSet)
			throws HmsApplicationException {

		ArrayList<HistoryTO> patientHistoryToList = new ArrayList<HistoryTO>();

		try {
			while (resultSet.next()) {
				HistoryTO patientHistoryTo = new HistoryTO();
				patientHistoryTo.setId(resultSet.getInt("id"));
				patientHistoryTo.setPatient_id(resultSet
						.getString("patient_id"));
				patientHistoryTo.setSymptoms(resultSet.getString("symptoms"));
				patientHistoryTo.setDiagnosis(resultSet.getString("diagnosis"));
				patientHistoryTo.setAdministered_by(resultSet
						.getString("administered_by"));
				patientHistoryTo.setDate_of_diagnosis(resultSet
						.getString("date_of_diagnosis"));
				patientHistoryTo.setFollow_up_req(resultSet
						.getString("follow_up_req"));
				patientHistoryTo.setDate_of_follow_up(resultSet
						.getString("date_of_follow_up"));
				patientHistoryTo.setBill_amount(resultSet
						.getString("bill_amount"));
				patientHistoryTo.setCard_number(resultSet
						.getString("card_number"));
				patientHistoryTo.setPayment_mode(resultSet
						.getString("payment_mode"));
				patientHistoryToList.add(patientHistoryTo);

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

		return patientHistoryToList;
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
