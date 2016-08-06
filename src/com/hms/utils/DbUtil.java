package com.hms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hms.constants.QueryConstant;

public class DbUtil {

	public static Connection getconnection() throws ClassNotFoundException,
			SQLException

	{

		Class.forName(QueryConstant.DRIVER);
		return DriverManager.getConnection(QueryConstant.URL,
				QueryConstant.USERNAME, QueryConstant.PASSWORD);
	}
}
