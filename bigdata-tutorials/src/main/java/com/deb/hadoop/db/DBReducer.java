package com.deb.hadoop.db;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DBReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> value, Context context) throws IOException, InterruptedException {

		StringBuilder data = new StringBuilder();
		for (Text item : value) {
			data = data.append(item);
		}

		context.write(key, new Text(data.toString()));
	}
}
