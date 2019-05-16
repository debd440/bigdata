package com.deb.chapter6

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object ReadJsonTest {

  def main(args: Array[String]): Unit = {

    val sparkConfig = new SparkConf().setMaster("local").setAppName("ReadJsonTest")
    val sparkContext = new SparkContext(sparkConfig)
    val sqlContext = new SQLContext(sparkContext)
    sparkContext.setLogLevel("info")

    var studentDF = sqlContext.read.json("file:///home/debdutta/HadoopEnviornment/data/spark/input/student.json")
    studentDF.registerTempTable("STUDENT")
    var studentDF1 = sqlContext.read.json("file:///home/debdutta/HadoopEnviornment/data/spark/input/student.json")
    studentDF1.registerTempTable("STUDENT1")

    println("Example 1- Run Raw Query")
    var result = sqlContext.sql("SELECT * FROM STUDENT")
    result.show

    println("Example 2")
    result = sqlContext.sql("SELECT ID,NAME FROM STUDENT")
    result.show

    println("Example 3- Print Schema")
    studentDF.printSchema()

    println("Example 4- Select Statement")
    studentDF.select(studentDF("NAME"), studentDF("CITY")).show

    println("Example 5- Sort By Statement")
    studentDF.sort(studentDF("CITY")).show

    println("Example 6- Filter Statement")
    studentDF1.filter(studentDF1("ID") >2).show
  }
}