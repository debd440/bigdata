package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object FilterTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("FilterTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop", "C", "Go"))
    var resultRDD = dataRDD.filter(item => item.length() > 3)
    println("Printing Result")
    resultRDD.foreach(println)
  }
}