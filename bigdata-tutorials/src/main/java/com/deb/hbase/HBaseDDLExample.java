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
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;

public class HBaseDDLExample {

	private TableName employeeTable = TableName.valueOf("employee");
	private String personalCF = "personal";
	private String professionalCF = "professional";

	public static void main(String[] args) {

		HBaseDDLExample example = new HBaseDDLExample();
		try {
			Connection connection = example.createConfiguration();
			Admin admin = connection.getAdmin();
			// Create Table
			example.createHBaseTable(admin);
			// View Table
			example.listTable(admin);
			// Disable Table:
			example.disableTable(admin);
			// Enable Table
			example.enableTable(admin);
			// If Table is Available
			example.isTableExist(admin);
			// Drop Table
			example.dropTable(admin);
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

	public void dropTable(Admin admin) throws IOException {
		System.out.println("Delete Table****************************************");
		admin.disableTable(employeeTable);
		admin.deleteTable(employeeTable);
	}

	public void isTableExist(Admin admin) throws IOException {
		System.out.println("Is Table Available: " + admin.isTableAvailable(employeeTable));
	}

	public void enableTable(Admin admin) throws IOException {

		System.out.println("Enable Table****************************************");
		admin.enableTable(employeeTable);
		System.out.println("Is Table Enable: " + admin.isTableEnabled(employeeTable));
	}

	public void disableTable(Admin admin) throws IOException {

		System.out.println("Disable Table****************************************");
		admin.disableTable(employeeTable);
		System.out.println("Is Table Disable:" + admin.isTableDisabled(employeeTable));
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

	public Connection createConfiguration() throws IOException {

		Configuration configuration = HBaseConfiguration.create();
		String path = this.getClass().getClassLoader().getResource("hbase.xml").getPath();
		configuration.addResource(new Path(path));
		return ConnectionFactory.createConnection(configuration);
	}
}
