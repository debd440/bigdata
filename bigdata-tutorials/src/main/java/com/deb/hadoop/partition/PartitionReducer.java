package com.deb.hadoop.partition;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PartitionReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		int counter = 0;
		for (IntWritable value : values) {
			counter = counter + value.get();
		}
		context.write(key, new IntWritable(counter));
	}
}
