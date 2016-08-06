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
import com.hms.model.PhysicianSearchTO;
import com.hms.utils.DbUtil;

public class PhysicianSearchDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement pstatement;
	private ResultSet resultSet;

	public ArrayList<PhysicianSearchTO> getAll(PhysicianSearchTO searchTo)
			throws HmsApplicationException {

		ArrayList<PhysicianSearchTO> physicianSearchToList = new ArrayList<PhysicianSearchTO>();

		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.SEARCH_PHYSICIAN);
			pstatement.setString(1, searchTo.getState());
			pstatement.setString(2, searchTo.getInsurancePlan());
			pstatement.setString(3, searchTo.getDepartmentName());
			pstatement.setString(4, searchTo.getShiftTimings());
			resultSet = pstatement.executeQuery();
			physicianSearchToList = getResult(resultSet);
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

		return physicianSearchToList;
	}

	public ArrayList<PhysicianSearchTO> getSortFirstName(
			PhysicianSearchTO searchTo) throws HmsApplicationException,
			SQLException {

		ArrayList<PhysicianSearchTO> physicianSearchToList = new ArrayList<PhysicianSearchTO>();

		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.SEARCH_PHYSICIAN_SORT_FN);
			pstatement.setString(1, searchTo.getState());
			pstatement.setString(2, searchTo.getInsurancePlan());
			pstatement.setString(3, searchTo.getDepartmentName());
			pstatement.setString(4, searchTo.getShiftTimings());
			resultSet = pstatement.executeQuery();
			physicianSearchToList = getResult(resultSet);
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

		return physicianSearchToList;
	}

	public ArrayList<PhysicianSearchTO> getSortLastName(
			PhysicianSearchTO searchTo) throws HmsApplicationException,
			SQLException {

		ArrayList<PhysicianSearchTO> physicianSearchToList = new ArrayList<PhysicianSearchTO>();

		try {
			connection = DbUtil.getconnection();
			pstatement = connection
					.prepareStatement(QueryConstant.SEARCH_PHYSICIAN_SORT_LN);
			pstatement.setString(1, searchTo.getState());
			pstatement.setString(2, searchTo.getInsurancePlan());
			pstatement.setString(3, searchTo.getDepartmentName());
			pstatement.setString(4, searchTo.getShiftTimings());
			resultSet = pstatement.executeQuery();
			physicianSearchToList = getResult(resultSet);
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

		return physicianSearchToList;
	}

	private ArrayList<PhysicianSearchTO> getResult(ResultSet resultSet)
			throws HmsApplicationException, SQLException {
		ArrayList<PhysicianSearchTO> physicianSearchToList = new ArrayList<PhysicianSearchTO>();

		try {
			while (resultSet.next()) {
				PhysicianSearchTO physicianSearchTo = new PhysicianSearchTO();
				physicianSearchTo.setPhysicianId(resultSet.getString("id"));
				physicianSearchTo.setPhysicianFirstName(resultSet
						.getString("firstname"));
				physicianSearchTo.setPhysicianLastName(resultSet
						.getString("lastname"));
				physicianSearchTo.setDepartmentName(resultSet
						.getString("department"));
				physicianSearchTo.setEducationalQualification(resultSet
						.getString("education"));
				physicianSearchTo.setYearsOfExcperience(resultSet
						.getString("yop"));
				physicianSearchTo.setState(resultSet.getString("state"));
				physicianSearchTo.setInsurancePlan(resultSet.getString("plan"));
				physicianSearchTo.setShiftTimings(resultSet.getString("shift"));
				physicianSearchToList.add(physicianSearchTo);

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

		return physicianSearchToList;
	}

	public List<String> getStates() throws HmsApplicationException {
		List<String> stateList = new ArrayList<String>();
		try {
			connection = DbUtil.getconnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryConstant.GET_STATES);
			stateList = getPopulate(resultSet);

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
			insuranceList = getPopulate(resultSet);

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
			departmentList = getPopulate(resultSet);

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

	public List<String> getPopulate(ResultSet resultSet)
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
