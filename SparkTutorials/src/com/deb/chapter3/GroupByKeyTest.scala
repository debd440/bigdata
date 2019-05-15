package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object GroupByKeyTest {

  //Paird RDDs- Group based on key
  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List(("Java", 20), ("Spring", 30), ("Scala", 10), ("Java", 40), ("Spring", 15), ("Scala", 25)))
    var resultRDD = dataRDD.groupByKey()
    println("Printing Result")
    resultRDD.foreach(println)
  }
}