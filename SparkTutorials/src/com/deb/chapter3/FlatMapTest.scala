package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object FlatMapTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop")).flatMap(_.toUpperCase())
    println("Printing Result")
    dataRDD.foreach(println)

    var dataRDD1 = sparkContext.parallelize(List("Hello World", "This is my First code")).flatMap(_.split(" ")).collect()
    println("Printing Result")
    dataRDD1.foreach(println)
  }
}