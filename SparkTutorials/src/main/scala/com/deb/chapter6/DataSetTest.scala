package com.deb.chapter6

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object DataSetTest {

  def main(args: Array[String]): Unit = {

    val sparkConfig = new SparkConf().setMaster("local").setAppName("DataSetTest")
    val sparkContext = new SparkContext(sparkConfig)
    val sqlContext = new SQLContext(sparkContext)
    sparkContext.setLogLevel("info")

    import sqlContext.implicits._
    var studentDS = sqlContext.read.json("file:///home/debdutta/HadoopEnviornment/data/spark/input/student.json").as[Stu]
    studentDS.show()
  }
}

case class Stu(id: String, name: String, city: String)