package com.deb.hadoop.toolrunner;

import java.io.IOException;

import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PassingParamReducer extends Reducer<Text, BooleanWritable, Text, IntWritable> {

	private int trueCount;
	private int falseCount;

	@Override
	protected void reduce(Text text, Iterable<BooleanWritable> values, Context context)
			throws IOException, InterruptedException {

		for (BooleanWritable item : values) {
			if (item.get()) {
				trueCount++;
			} else {
				falseCount++;
			}
		}
	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {

		context.write(new Text("Matching Skill Found"), new IntWritable(trueCount));
		context.write(new Text("Non-Matching Skill Found"), new IntWritable(falseCount));
	}
}
