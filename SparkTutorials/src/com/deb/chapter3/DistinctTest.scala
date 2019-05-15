package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object DistinctTest {
  
  //Remove Duplicate Data
  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop", "Java", "Go", "Hadoop", "Spark", "Android", "J2ME"))
    var resultRDD = dataRDD.distinct()
    println("Printing Result")
    resultRDD.foreach(println)
  }
}