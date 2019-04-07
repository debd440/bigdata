package com.deb.hadoop.toolrunner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ToolRunnerTest extends Configured implements Tool {

	public static void main(String[] args) {

		try {
			int exitCode = ToolRunner.run(new Configuration(),new ToolRunnerTest(), args);
			System.exit(exitCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int run(String[] args) throws Exception {

		Configuration configuration = getConf();
		Job job = Job.getInstance(configuration);

		job.setJarByClass(ToolRunnerTest.class);
		job.setJobName("Tool Runner Test");

		job.setMapperClass(ToolRunnerMapper.class);
		job.setReducerClass(ToolRunnerReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path("/user/root/input/demo.txt"));
		FileOutputFormat.setOutputPath(job, new Path("/user/root/output/toolRunner/"));
		int returnValue = job.waitForCompletion(true) ? 0 : 1;
		return returnValue;
	}

	// Command To Run Job
	// hadoop jar wc.jar com.deb.hadoop.toolrunner.ToolRunnerTest -D
	// mapred.reduce.tasks=2
}
