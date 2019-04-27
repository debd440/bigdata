package com.deb.hadoop.db;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.db.DBConfiguration;
import org.apache.hadoop.mapred.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class DatabaseTest {

	public static void main(String[] args) {

		try {
			Configuration configuration = new Configuration();
			DBConfiguration.configureDB(configuration, "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hadoop", "root",
					"Deb123");
			configuration.set("mapreduce.output.basename", "B2C");
			Job job = Job.getInstance(configuration);

			job.setJarByClass(DatabaseTest.class);

			job.setMapperClass(DBMapper.class);
			job.setReducerClass(DBReducer.class);
			//job.setNumReduceTasks(2);

			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);

			job.setInputFormatClass(DBInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);

			DBInputFormat.setInput(job, DBInputWrittable.class, "STUDENT", "ID < 3", "NAME DESC", new String[] { "ID", "NAME" });

			FileOutputFormat.setOutputPath(job, new Path("/user/root/output/dbinput/"));

			System.out.println(job.waitForCompletion(true) ? 0 : 1);
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
