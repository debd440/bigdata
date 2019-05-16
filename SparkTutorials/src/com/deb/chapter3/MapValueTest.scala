package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object MapValueTest {

  //Paird RDDs- Works Similar to Map
  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("MapValueTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List(("Java", 20), ("Spring", 30), ("Scala", 10)))
    dataRDD.collect()
    var resultRDD = dataRDD.mapValues(item => item * 10)
    println("Printing Result")
    resultRDD.foreach(println)
  }
}