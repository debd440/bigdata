package com.deb.chapter6

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object DBTest {

  def main(args: Array[String]): Unit = {

    val sparkConfig = new SparkConf().setMaster("local").setAppName("DBTest")
    val sparkContext = new SparkContext(sparkConfig)
    val sqlContext = new SQLContext(sparkContext)
    sparkContext.setLogLevel("info")

    val url = "jdbc:mysql://localhost:3306/play"
    val prop = new java.util.Properties
    prop.setProperty("user", "root")
    prop.setProperty("password", "Deb123")

    var studentDF = sqlContext.read.jdbc(url, "STUDENT", prop)
    studentDF.show()
  }
}