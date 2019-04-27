package com.deb.chapter5

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds

object FileStreamTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("FileStreamTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var streamingContext = new StreamingContext(sparkContext, Seconds(20))
    var result = streamingContext.textFileStream("file:///home/debdutta/HadoopEnviornment/data/spark/input/b2c.txt").flatMap(_.split(" ")).map(w => (w, 1)).reduceByKey(_ + _)
    result.print()
    streamingContext.start
    streamingContext.awaitTermination
  }
}