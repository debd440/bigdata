package com.deb.hadoop.inputformat;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StudentMapper extends Mapper<Object, Text, StudentWritable, ResultWritable> {

	@Override
	protected void setup(Mapper<Object, Text, StudentWritable, ResultWritable>.Context context)
			throws IOException, InterruptedException {

		String entityName = context.getConfiguration().get("entity");
		System.out.println("Mapper Execution Starts for Entity: " + entityName);
	}

	@Override
	protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		String data[] = value.toString().split(",");

		StudentWritable studentWritable = new StudentWritable(new IntWritable(Integer.parseInt(data[0])),
				new Text(data[1]));
		ResultWritable resultWritable = new ResultWritable(new IntWritable(Integer.parseInt(data[2])),
				new IntWritable(Integer.parseInt(data[3])), new Text(data[4]));
		System.out.println("Science Score in mapper: " + resultWritable.getScienceMarks().get());
		context.write(studentWritable, resultWritable);
	}
}
