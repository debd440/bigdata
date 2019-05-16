package com.deb.chapter6

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.types.StructType

object ReadCSVFiles {

  def main(args: Array[String]): Unit = {

    val sparkConfig = new SparkConf().setMaster("local").setAppName("ReadCSVFiles")
    val sparkContext = new SparkContext(sparkConfig)
    val sqlContext = new SQLContext(sparkContext)
    sparkContext.setLogLevel("info")

    var studentDF = sqlContext.read.csv("file:///home/debdutta/HadoopEnviornment/data/spark/input/student.csv")
    println("Showing Student Data")
    studentDF.show()

    println("Showing Student Count")
    println(s"Total Count ${studentDF.count()}")

    println("Create Table Using Code")
    var studentSchema = new StructType().add("id", "int").add("name", "String")
    var studentDF1 = sqlContext.read.format("com.databricks.spark.csv").schema(studentSchema).load("file:///home/debdutta/HadoopEnviornment/data/spark/input/student.csv")
    studentDF1.show
  }
}