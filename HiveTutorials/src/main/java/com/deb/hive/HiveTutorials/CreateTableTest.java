package com.deb.hive.HiveTutorials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CreateTableTest {

	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Register driver and create driver instance

		Class.forName(driverName);
		// get connection

		Connection con = DriverManager.getConnection("jdbc:hive2://");
		System.out.println("Connection: " + con.getCatalog());
		Statement stmt = con.createStatement();

		stmt.executeQuery("CREATE TABLE IF NOT EXISTS " + " employee ( eid int, name String, "
				+ " salary String, destignation String)" + " COMMENT ‘Employee details’" + " ROW FORMAT DELIMITED"
				+ " FIELDS TERMINATED BY ‘\t’" + " LINES TERMINATED BY ‘\n’" + " STORED AS TEXTFILE;");
		System.out.println("Table  created successfully.");

		stmt.executeQuery("LOAD DATA LOCAL INPATH '/home/user/sample.txt'" + "OVERWRITE INTO TABLE employee;");
		System.out.println("Load Data into employee successful");

		// execute statement
		ResultSet res = stmt.executeQuery("SELECT * FROM employee WHERE salary>30000;");

		System.out.println("Result:");
		System.out.println(" ID \t Name \t Salary \t Designation \t Dept ");

		while (res.next()) {
			System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getDouble(3) + " " + res.getString(4)
					+ " " + res.getString(5));
		}
		con.close();
	}
}