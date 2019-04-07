package com.deb.hadoop.toolrunner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class PassingParamTest extends Configured implements Tool {

	public static void main(String[] args) {

		try {
			int result = ToolRunner.run(new PassingParamTest(), args);
			System.out.println("Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int run(String[] args) throws Exception {

		Configuration configuration = new Configuration();
		String data[] = { "Java", "Hadoop" };
		configuration.setStrings("tech", data);
		Job job = Job.getInstance(configuration, "PassingParamTest");

		job.setJarByClass(PassingParamTest.class);

		job.setMapperClass(PassingParamMapper.class);
		job.setReducerClass(PassingParamReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(BooleanWritable.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path("/user/root/input/tech.txt"));
		FileOutputFormat.setOutputPath(job, new Path("/user/root/output/passingParam/"));

		int result = job.waitForCompletion(true) ? 0 : 1;
		return result;
	}

}
