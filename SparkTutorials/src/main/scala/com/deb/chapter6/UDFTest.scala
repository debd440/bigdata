package com.deb.chapter6

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object UDFTest {

  def main(args: Array[String]): Unit = {

    val sparkConfig = new SparkConf().setMaster("local").setAppName("UDFTest")
    val sparkContext = new SparkContext(sparkConfig)
    val sqlContext = new SQLContext(sparkContext)
    sparkContext.setLogLevel("info")

    //Register UDF
    sqlContext.udf.register("UPPERCASE", convertToUpperCase(_: String))

    var studentDF = sqlContext.read.json("file:///home/debdutta/HadoopEnviornment/data/spark/input/student.json")
    studentDF.registerTempTable("STUDENT")

    var result = sqlContext.sql("SELECT ID,UPPERCASE(NAME) AS NAME FROM STUDENT")
    result.show
  }

  def convertToUpperCase(value: String) = {
    value.toUpperCase()
  }
}