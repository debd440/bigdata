package com.deb.hadoop.partition;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PartitionMapper extends Mapper<Object, Text, Text, IntWritable> {

	@Override
	protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		String[] data = value.toString().split(",");
		for (String item : data) {
			context.write(new Text(item), new IntWritable(1));
		}
	}
}
