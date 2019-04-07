package com.deb.hadoop.course;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CourseMapper extends Mapper<Object, Text, Text, Text> {

	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {

		System.out.println("Mapper Data :::::::::::::::: " + value.toString());
		String[] data = value.toString().split("->");
		System.out.println("Mapper Processing Data: Key: " + data[0] + " Value: " + data[1]);
		context.write(new Text(data[0]), new Text(data[1]));
	}

}
