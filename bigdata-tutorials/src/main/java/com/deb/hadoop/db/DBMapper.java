package com.deb.hadoop.db;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DBMapper extends Mapper<Object, DBInputWrittable, Text, Text> {

	@Override
	protected void map(Object key, DBInputWrittable value, Context context) throws IOException, InterruptedException {

		context.write(new Text(String.valueOf(value.getId())), new Text(value.getName()));

	}
}
