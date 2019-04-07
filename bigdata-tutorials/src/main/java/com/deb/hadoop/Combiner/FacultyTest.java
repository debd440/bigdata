package com.deb.hadoop.Combiner;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class FacultyTest {

	public static void main(String[] args) {

		try {
			Configuration configuration = new Configuration();
			Job job = Job.getInstance(configuration);

			job.setJarByClass(FacultyTest.class);

			job.setMapperClass(FacultyMapper.class);
			job.setReducerClass(FacultyReducer.class);
			job.setCombinerClass(FacultyCombiner.class);
		
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);

			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);

			FileInputFormat.addInputPath(job, new Path("/user/root/input/course.txt"));
			FileOutputFormat.setOutputPath(job, new Path("/user/root/output/combiner/"));

			System.out.println(job.waitForCompletion(true) ? 0 : 1);
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
