package com.deb.hadoop.Combiner;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FacultyCombiner extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

		StringBuilder result = new StringBuilder();

		int counter = 0;
		for (Text value : values) {
			if (counter != 0)
				result.append(",");
			result.append(value);
			counter++;
		}
		context.write(key, new Text(result.toString()));
	}
}
