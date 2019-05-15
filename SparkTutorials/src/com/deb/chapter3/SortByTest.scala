package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SortByTest {
  
   def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop", "C", "Go", "Scala", "Spark", "Android", "J2ME"))
    var resultRDD = dataRDD.sortBy(_.charAt(0))
    println("Printing Result")
    resultRDD.foreach(println)
  }
}