package com.deb.hadoop.inputformat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class ResultWritable implements Writable {

	private IntWritable mathMarks;
	private IntWritable scienceMarks;
	private Text grade;

	@Override
	public void write(DataOutput out) throws IOException {
		mathMarks.write(out);
		scienceMarks.write(out);
		grade.write(out);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		mathMarks.readFields(in);
		scienceMarks.readFields(in);
		grade.readFields(in);
	}

	public ResultWritable() {
		mathMarks = new IntWritable();
		scienceMarks = new IntWritable();
		grade = new Text();
	}

	public ResultWritable(IntWritable mathMarks, IntWritable scienceMarks, Text grade) {
		this.mathMarks = mathMarks;
		this.scienceMarks = scienceMarks;
		this.grade = grade;
	}

	public IntWritable getMathMarks() {
		return mathMarks;
	}

	public void setMathMarks(IntWritable mathMarks) {
		this.mathMarks = mathMarks;
	}

	public IntWritable getScienceMarks() {
		return scienceMarks;
	}

	public void setScienceMarks(IntWritable scienceMarks) {
		this.scienceMarks = scienceMarks;
	}

	public Text getGrade() {
		return grade;
	}

	public void setGrade(Text grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return mathMarks + "\t" + scienceMarks + "\t" + grade;
	}
}
