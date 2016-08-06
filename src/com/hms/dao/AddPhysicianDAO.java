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
import com.hms.model.PhysicianTO;
import com.hms.utils.DbUtil;

public class AddPhysicianDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public int validatePhysician(PhysicianTO physicianTo)
			throws HmsApplicationException {
		int result = 0;
		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.INSERT_PHYSICIAN);
			pstatement.setString(1, physicianTo.getPhysicianId());
			pstatement.setString(2, physicianTo.getPhysicianFirstName());
			pstatement.setString(3, physicianTo.getPhysicianLastName());
			pstatement.setString(4, physicianTo.getDepartmentName());
			pstatement.setString(5, physicianTo.getEducationalQualification());
			pstatement.setString(6, physicianTo.getYearsOfExcperience());
			pstatement.setString(7, physicianTo.getState());
			pstatement.setString(8, physicianTo.getInsurancePlan());
			pstatement.setString(9, physicianTo.getShift());

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

	public int validateExistingPatient(PhysicianTO physicianTo)
			throws HmsApplicationException {
		int result = 0;
		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.GET_PHYSICIAN);
			pstatement.setString(1, physicianTo.getPhysicianFirstName());
			pstatement.setString(2, physicianTo.getPhysicianLastName());
			pstatement.setString(3, physicianTo.getDepartmentName());
			resultSet = pstatement.executeQuery();
			if (resultSet.next()) {
				String PhysicianFirstName = resultSet.getString("firstname");
				String PhysicianLastName = resultSet.getString("lastname");
				String PhysicianDepartmentName = resultSet
						.getString("department");
				if (PhysicianFirstName.equalsIgnoreCase(physicianTo
						.getPhysicianFirstName())
						&& PhysicianLastName.equalsIgnoreCase(physicianTo
								.getPhysicianLastName())
						&& PhysicianDepartmentName.equalsIgnoreCase(physicianTo
								.getDepartmentName())) {
					result = -1;
				}
			} else {
				result = -2;
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
	public String generatePhysicianId() throws HmsApplicationException {
		String id = null;
		int id_no = 0;
		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.GET_PHYSICIANID);
			resultSet = pstatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getString("pid");

			}

			id_no = Integer.parseInt(id.substring(2, id.length()));
			++id_no;

			if (id_no > 99) {
				id = "PR" + id_no;
			} else if (id_no > 9 && id_no <= 99) {
				id = "PR" + "0" + id_no;
			} else if (id_no < 10) {
				id = "PR" + "00" + id_no;
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

	public List<String> getDepartment() throws HmsApplicationException {
		List<String> departmentList = new ArrayList<String>();
		try {
			connection = DbUtil.getconnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstant.GET_DEPARTMENT);
			departmentList = getResult(resultSet);

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
		return departmentList;

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
