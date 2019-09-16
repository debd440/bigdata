package com.deb.chapter6

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import org.apache.spark.sql.{ Encoder, Encoders }

object CaseTest {

  def main(args: Array[String]): Unit = {

    val sparkConfig = new SparkConf().setMaster("local").setAppName("CaseTest")
    val sparkContext = new SparkContext(sparkConfig)
    val sqlContext = new SQLContext(sparkContext)
    sparkContext.setLogLevel("info")

    import sqlContext.implicits._
    var file = sparkContext.textFile("file:///home/debdutta/HadoopEnviornment/data/spark/input/stu.csv")
    var rows = file.map(_.split(","))
    var studentRDD = rows.map(s => Student(s(0).toInt, s(1), s(2)))
    var studentDF = studentRDD.toDF()
    var studentDS = studentDF.as[Student] //This is Data Source
    studentDS.show
  }
}

case class Student(id: Int, name: String, city: String)