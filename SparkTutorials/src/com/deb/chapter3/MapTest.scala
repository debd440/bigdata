package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object MapTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop"))
    dataRDD.collect()
    var resultRDD = dataRDD.map(_.toUpperCase())
    println("Printing Result")
    resultRDD.foreach(println)
  }
}