package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SortByKeyTest {

  //Paird RDDs- Sort based on key
  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("SortByKeyTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List(("Java", 20), ("Spring", 30), ("Scala", 10), ("HBase", 40), ("Go", 15), ("Scala", 25)))
    var resultRDD = dataRDD.sortByKey()
    println("Printing Result")
    resultRDD.foreach(println)
  }
}