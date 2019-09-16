package com.deb.hadoop.counter;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CounterMapper extends Mapper<Object, Text, Text, IntWritable> {

	private Text word = new Text();

	@Override
	protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		StringTokenizer tokenizer = new StringTokenizer(value.toString());
		context.getCounter(CounterEnum.NO_OF_MAP_EXECUTION).increment(1);;
		while (tokenizer.hasMoreTokens()) {
			word.set(tokenizer.nextToken());
			context.write(word, new IntWritable(1));
		}
	}
}
