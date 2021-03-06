package com.deb.hadoop.inputformat;

import java.io.FileReader;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class StudentTest extends Configured implements Tool {

	public static void main(String[] args) {

		try {
			int result = ToolRunner.run(new StudentTest(), args);
			System.out.println("Result: " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int run(String[] args) throws Exception {

		FileReader reader = new FileReader(
				"/home/debdutta/HadoopEnviornment/codebase/bigdata-tutorials/src/main/resources/hadoop.properties");
		Properties p = new Properties();
		p.load(reader);
		String input = p.getProperty("input_path");
		String output = p.getProperty("output_path");

		Configuration configuration = new Configuration();
		configuration.setStrings("entity", "B2C Technology");
		Job job = Job.getInstance(configuration, "Student Test");

		job.setJarByClass(StudentTest.class);
		job.setMapperClass(StudentMapper.class);
		job.setReducerClass(StudentReducer.class);
		//job.setCombinerClass(StudentCombiner.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		job.setMapOutputKeyClass(StudentWritable.class);
		job.setMapOutputValueClass(ResultWritable.class);

		job.setOutputKeyClass(StudentWritable.class);
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, new Path(input));
		FileOutputFormat.setOutputPath(job, new Path(output));

		int result = job.waitForCompletion(true) ? 0 : 1;
		long noOfStudent = job.getCounters().findCounter(StudentEnum.NO_OF_STUDENT).getValue();
		System.out.println("No Of Students: " + noOfStudent);
		return result;
	}

}
