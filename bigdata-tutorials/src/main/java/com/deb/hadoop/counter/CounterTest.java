package com.deb.hadoop.counter;

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

public class CounterTest {

	public static void main(String[] args) {

		try {
			Configuration configuration = new Configuration();
			Job job = Job.getInstance(configuration);

			job.setJarByClass(CounterTest.class);

			job.setMapperClass(CounterMapper.class);
			job.setReducerClass(CounterReducer.class);

			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);

			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);

			FileInputFormat.addInputPath(job, new Path("/user/root/input/demo.txt"));
			FileOutputFormat.setOutputPath(job, new Path("/user/root/output/counter/"));

			boolean result =job.waitForCompletion(true);
			System.out.println("Counter Data Received:  "
					+ job.getCounters().findCounter(CounterEnum.NO_OF_WORD).getValue());
			System.out.println("Batch Job Result: "+result);
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
