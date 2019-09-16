package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object KeyByExample {

  //Convert Into Paired RDD By Executing Function
  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("KeyByExample")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var techRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop", "C", "Go", "Scala", "Spark", "Android", "J2ME"))
    var pairedData = techRDD.keyBy(_.charAt(0))
    println(s"Key By Example: ")
    pairedData.foreach(item => {
      println(s"Key By Data : ${item._1} \t  ${item._2}")
    })
  }
}