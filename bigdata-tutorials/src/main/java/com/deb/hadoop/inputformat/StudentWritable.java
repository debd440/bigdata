package com.deb.hadoop.inputformat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class StudentWritable implements WritableComparable<StudentWritable> {

	private IntWritable id;
	private Text name;


	@Override
	public int compareTo(StudentWritable data) {
		int x = this.id.get() - data.getId().get();
		if (x == 0) {
			return this.name.toString().compareTo(data.getName().toString());
		}
		return x;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		id.write(out);
		name.write(out);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		id.readFields(in);
		name.readFields(in);
	}
	
	public StudentWritable() {
		id = new IntWritable();
		name = new Text();
	}

	public StudentWritable(IntWritable id, Text name) {
		this.id = id;
		this.name = name;
	}

	public IntWritable getId() {
		return id;
	}

	public void setId(IntWritable id) {
		this.id = id;
	}

	public Text getName() {
		return name;
	}

	public void setName(Text name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return id + "\t " + name;
	}

}
