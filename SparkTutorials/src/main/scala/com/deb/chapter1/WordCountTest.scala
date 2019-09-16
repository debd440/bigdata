package com.deb.chapter1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCountTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("WordCountTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var textRDD = sparkContext.textFile("file:///home/debdutta/HadoopEnviornment/data/input/demo.txt")
    var lineRDD = textRDD.flatMap(line => line.split(" "))

    var wordRDD = lineRDD.map(word => (word, 1))
    var wordCountRDD = wordRDD.reduceByKey((sum, b) => sum + b)
    wordCountRDD.collect().foreach(key => {
      println(s"Collected Words Are: $key")
    })

    println("Coding in Shorts")
    var shortWordCountRDD = sparkContext.textFile("file:///home/debdutta/HadoopEnviornment/data/input/demo.txt")
      .flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect().foreach(println)
  }
}