package com.deb.hadoop.Combiner;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

public class FacultyMapper extends Mapper<Object, Text, Text, Text> {

	private static final Logger LOGGER = Logger.getLogger(FacultyMapper.class);

	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {

		LOGGER.info("Mapper Data :::::::::::::::: " + value.toString());
		String[] data = value.toString().split("->");
		LOGGER.info("Mapper Processing Data: Key: " + data[0] + " Value: " + data[1]);
		context.write(new Text(data[1]), new Text(data[0]));
	}

}
