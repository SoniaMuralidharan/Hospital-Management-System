package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hms.constants.QueryConstant;
import com.hms.exceptions.HmsApplicationException;
import com.hms.model.PatientDiagnosisDetailsTO;
import com.hms.utils.DbUtil;

public class PatientDiagnosisDetailsDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public int validatePatientDiagnosis(
			PatientDiagnosisDetailsTO patientDiagnosisTo)
			throws HmsApplicationException {
		int result = 0;
		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.INSERT_DIAGNOSIS_DETAILS);
			pstatement.setLong(1, patientDiagnosisTo.getDiagnosisId());
			pstatement.setString(2, patientDiagnosisTo.getPatientId());
			pstatement.setString(3, patientDiagnosisTo.getSymptoms());
			pstatement.setString(4, patientDiagnosisTo.getDiagnosisProvided());
			pstatement.setString(5, patientDiagnosisTo.getAdministeredBy());
			pstatement.setString(6, patientDiagnosisTo.getDateOfDiagnosis());
			pstatement.setString(7, patientDiagnosisTo.getFollowUpRequired());
			pstatement.setString(8, patientDiagnosisTo.getDateOfFollowUp());
			pstatement.setString(9, patientDiagnosisTo.getBillAmount());
			pstatement.setString(10, patientDiagnosisTo.getCardNumber());
			pstatement.setString(11, patientDiagnosisTo.getModeOfPayment());

			pstatement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new HmsApplicationException(e);

		} catch (SQLException e) {
			throw new HmsApplicationException(e);

		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new HmsApplicationException(e);
			}
		}
		return result;
	}

	public int validateExistingPatientDiagnosis(
			PatientDiagnosisDetailsTO patientDiagnosisTo)
			throws HmsApplicationException {
		int result = 0;

		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.GET_PATIENT_DIAGNOSIS);
			pstatement.setString(1, patientDiagnosisTo.getPatientId());
			resultSet = pstatement.executeQuery();
			if (resultSet.next()) {
				String patientId = resultSet.getString("pid");
				if (patientId.equals(patientDiagnosisTo.getPatientId())) {
					result = -1;
				}
			} else {
				result = -2;
			}
		} catch (ClassNotFoundException e) {
			throw new HmsApplicationException();
		} catch (SQLException e) {
			throw new HmsApplicationException();

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
	public int generateDiagnosisId() throws HmsApplicationException {
		int id = 0;
		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.GET_DIAGNOSIS_ID);
			resultSet = pstatement.executeQuery();
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
