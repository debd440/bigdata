package com.deb.hadoop.partition;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class PartitionTest {

	public static void main(String[] args) {

		try {
			Configuration configuration = new Configuration();
			Job job = Job.getInstance(configuration);

			job.setJarByClass(PartitionTest.class);

			job.setPartitionerClass(PartitionPartitioner.class);
			job.setMapperClass(PartitionMapper.class);
			job.setReducerClass(PartitionReducer.class);
			job.setNumReduceTasks(2);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);

			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);

			FileInputFormat.addInputPath(job, new Path("/user/root/input/tech.txt"));
			FileOutputFormat.setOutputPath(job, new Path("/user/root/output/partition/"));

			System.out.println(job.waitForCompletion(true) ? 0 : 1);
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
