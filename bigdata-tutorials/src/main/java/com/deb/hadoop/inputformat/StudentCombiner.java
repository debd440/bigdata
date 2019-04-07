package com.deb.hadoop.inputformat;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class StudentCombiner extends Reducer<StudentWritable, ResultWritable, StudentWritable, IntWritable> {

	@Override
	protected void reduce(StudentWritable key, Iterable<ResultWritable> value, Context context)
			throws IOException, InterruptedException {

		int sum = 0;
		for (ResultWritable resultWritable : value) {
			System.out.println("Science Score: "+resultWritable.getScienceMarks().get());
			System.out.println("Math Score: "+resultWritable.getMathMarks().get());
			sum = resultWritable.getScienceMarks().get() + resultWritable.getMathMarks().get();
		}
		context.getCounter(StudentEnum.NO_OF_STUDENT).increment(1);
		context.write(key, new IntWritable(sum));
	}

	@Override
	protected void cleanup(Reducer<StudentWritable, ResultWritable, StudentWritable, IntWritable>.Context context)
			throws IOException, InterruptedException {

		String entityName = context.getConfiguration().get("entity");
		System.out.println("Reducer Execution Completed for Entity: " + entityName);
	}
}
