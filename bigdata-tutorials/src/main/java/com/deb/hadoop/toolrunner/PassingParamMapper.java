package com.deb.hadoop.toolrunner;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PassingParamMapper extends Mapper<Object, Text, Text, BooleanWritable> {

	private Set<String> dataElement = new HashSet<>();

	@Override
	protected void setup(Context context) throws IOException, InterruptedException {

		String data[] = context.getConfiguration().getStrings("tech");
		for (String item : data) {
			dataElement.add(item);
		}
	}

	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, BooleanWritable>.Context context)
			throws IOException, InterruptedException {

		String element[] = value.toString().split(",");
		for (String item : element) {
			if (dataElement.contains(item)) {
				context.write(new Text(item), new BooleanWritable(true));
			} else {
				context.write(new Text(item), new BooleanWritable(false));
			}
		}
	}
}
