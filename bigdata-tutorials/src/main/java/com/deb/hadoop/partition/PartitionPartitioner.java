package com.deb.hadoop.partition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class PartitionPartitioner extends Partitioner<Text, IntWritable> {

	@Override
	public int getPartition(Text key, IntWritable value, int numPartitions) {

		char ch = key.toString().charAt(0);
		if (ch >= 'A' && ch <= 'R')
			return 0;
		return 1;
	}
}
