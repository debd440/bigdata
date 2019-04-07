package com.deb.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseDMLExample {

	private static TableName employeeTable = TableName.valueOf("employee");
	private String personalCF = "personal";
	private String professionalCF = "professional";

	private String nameColumn = "name";
	private String cityColumn = "city";
	private String gradeColum = "grade";
	private String designationColumn = "designation";

	private final byte[] rowIdemtifier1 = Bytes.toBytes(1);
	private final byte[] rowIdemtifier2 = Bytes.toBytes(2);
	private final byte[] rowIdemtifier3 = Bytes.toBytes(3);

	public static void main1(String[] args) {

		HBaseDMLExample example = new HBaseDMLExample();
		try {
			Connection connection = example.createConfiguration();
			Admin admin = connection.getAdmin();
			Table table = connection.getTable(employeeTable);

			// Create Table
			example.createHBaseTable(admin);
			// View Table
			example.listTable(admin);
			// Add Data
			example.addEmployeeRecords(table);
			// Retrieve Data
			example.getEmployeeRecords(table);
			// Scan Data
			example.scanEmployeeRecords(table);
			// Update Data
			example.updateEmployeeRecords(table);
			// Verify Data
			System.out.println("Verify Update Employee Data");
			example.getEmployeeRecords(table);
			// Delete Data
			example.deleteEmployeeRecords(table);
			System.out.println("Verify Deleted Employee Data");
			example.getEmployeeRecords(table);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createHBaseTable(Admin admin) throws IOException {

		System.out.println("Starting Create Table Operation  ****************************************");
		// Create Table Builder
		TableDescriptorBuilder builder = TableDescriptorBuilder.newBuilder(employeeTable);
		// Add Column Family
		Collection<ColumnFamilyDescriptor> columnFamilyList = new ArrayList<>();
		columnFamilyList.add(ColumnFamilyDescriptorBuilder.of(personalCF));
		columnFamilyList.add(ColumnFamilyDescriptorBuilder.of(professionalCF));
		builder.setColumnFamilies(columnFamilyList);
		// Create Table using Admin
		admin.createTable(builder.build());
		System.out.println("Completed Create Table Operation");
	}

	public void listTable(Admin admin) throws IOException {

		System.out.println("Searching Table Detail ****************************************");
		List<TableDescriptor> tableDescriptorList = admin.listTableDescriptors();
		tableDescriptorList.forEach(tableDescriptor -> {
			System.out.println("Table Name: " + tableDescriptor.getTableName().getNameAsString());
			ColumnFamilyDescriptor[] columnFamilyList = tableDescriptor.getColumnFamilies();
			for (int i = 0; i < columnFamilyList.length; i++) {
				System.out.println("Column Name:" + columnFamilyList[i].getNameAsString());
			}
		});
		System.out.println("Completed Table List Detail");
	}

	public void scanEmployeeRecords(Table table) throws IOException {

		System.out.println("Scan Employee:*******************");
		Scan scan = new Scan();
		scan.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(nameColumn));
		scan.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(cityColumn));
		// Getting the scan result
		ResultScanner scanner = table.getScanner(scan);

		// Reading values from scan result
		System.out.println("Scan Result ****************");
		for (Result result = scanner.next(); result != null; result = scanner.next()) {

			// Reading values from Result class object
			byte[] value = result.getValue(Bytes.toBytes(personalCF), Bytes.toBytes(nameColumn));
			byte[] value1 = result.getValue(Bytes.toBytes(personalCF), Bytes.toBytes(cityColumn));
			byte[] value2 = result.getValue(Bytes.toBytes(professionalCF), Bytes.toBytes(gradeColum));
			byte[] value3 = result.getValue(Bytes.toBytes(professionalCF), Bytes.toBytes(designationColumn));

			// Printing the values
			String name = Bytes.toString(value);
			String city = Bytes.toString(value1);
			String grade = Bytes.toString(value2);
			String designation = Bytes.toString(value3);

			System.out.println("name: " + name + " city: " + city + " Grade:" + grade + " Designation: " + designation);
		}
	}

	public void getEmployeeRecords(Table table) throws IOException {

		System.out.println("Searching Employee By Identifier:*******************");
		// Get Data By IdentiFier
		Get get = new Get(rowIdemtifier1);
		// Get Result
		Result result = table.get(get);
		// Reading values from Result class object
		byte[] value = result.getValue(Bytes.toBytes(personalCF), Bytes.toBytes(nameColumn));
		byte[] value1 = result.getValue(Bytes.toBytes(personalCF), Bytes.toBytes(cityColumn));
		byte[] value2 = result.getValue(Bytes.toBytes(professionalCF), Bytes.toBytes(gradeColum));
		byte[] value3 = result.getValue(Bytes.toBytes(professionalCF), Bytes.toBytes(designationColumn));

		// Printing the values
		String name = Bytes.toString(value);
		String city = Bytes.toString(value1);
		String grade = Bytes.toString(value2);
		String designation = Bytes.toString(value3);

		System.out.println("name: " + name + " city: " + city + " Grade:" + grade + " Designation: " + designation);
	}

	public void updateEmployeeRecords(Table table) throws IOException {

		System.out.println("Update Employee Detail ****************************************");
		Put put = new Put(rowIdemtifier1);
		put.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(nameColumn), Bytes.toBytes("Priya"));
		put.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(cityColumn), Bytes.toBytes("Kolkata"));
		put.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(gradeColum), Bytes.toBytes("8"));
		put.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(designationColumn),
				Bytes.toBytes("Software Engineer"));
		table.put(put);

	}

	public void deleteEmployeeRecords(Table table) throws IOException {

		System.out.println("Delete Employee Detail ****************************************");
		Delete delete = new Delete(rowIdemtifier1);
		delete.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(nameColumn));
		delete.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(designationColumn));
		table.delete(delete);
	}

	public void addEmployeeRecords(Table table) throws IOException {

		System.out.println("Add Employee Detail ****************************************");
		Put put = new Put(rowIdemtifier1);
		put.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(nameColumn), Bytes.toBytes("Deb"));
		put.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(cityColumn), Bytes.toBytes("Bangalore"));
		put.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(gradeColum), Bytes.toBytes("8"));
		put.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(designationColumn),
				Bytes.toBytes("Software Engineer"));
		table.put(put);

		put = new Put(rowIdemtifier2);
		put.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(nameColumn), Bytes.toBytes("Rahul"));
		put.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(cityColumn), Bytes.toBytes("Mumbai"));
		put.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(gradeColum), Bytes.toBytes("9"));
		put.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(designationColumn),
				Bytes.toBytes("Software Developer"));
		table.put(put);

		put = new Put(rowIdemtifier3);
		put.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(nameColumn), Bytes.toBytes("Sunil"));
		put.addColumn(Bytes.toBytes(personalCF), Bytes.toBytes(cityColumn), Bytes.toBytes("Chennai"));
		put.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(gradeColum), Bytes.toBytes("8"));
		put.addColumn(Bytes.toBytes(professionalCF), Bytes.toBytes(designationColumn),
				Bytes.toBytes("Application Developer"));
		table.put(put);
	}

	public Connection createConfiguration() throws IOException {

		Configuration configuration = HBaseConfiguration.create();
		String path = this.getClass().getClassLoader().getResource("hbase.xml").getPath();
		configuration.addResource(new Path(path));
		return ConnectionFactory.createConnection(configuration);
	}
}
