package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object ReduceByKeyTest {

  //Paird RDDs- Combine values based on key
  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("ReduceByKeyTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List(("Java", 20), ("Spring", 30), ("Scala", 10), ("Java", 40), ("Spring", 15), ("Scala", 25)))
    var resultRDD = dataRDD.reduceByKey(_+_)
    println("Printing Result")
    resultRDD.foreach(println)
  }
}