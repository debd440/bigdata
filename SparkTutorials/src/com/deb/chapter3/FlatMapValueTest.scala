package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object FlatMapValueTest {

  //Paird RDDs- Works Similar to Flatmap

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List(("Java", 20), ("Spring", 30), ("Scala", 10)))
    var resultRDD = dataRDD.flatMapValues(item => Array(item * 10)).collect()
    println("Printing Result")
    resultRDD.foreach(println)
  }
}