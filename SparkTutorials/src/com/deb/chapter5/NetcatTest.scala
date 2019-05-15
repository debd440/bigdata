package com.deb.chapter5

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds

object NetcatTest {

  //To Run Netcat - nc -lk 9998

  def setupLogging() = {

    import org.apache.log4j.{ Level, Logger }
    val rootLogger = Logger.getRootLogger()
    rootLogger.setLevel(Level.ERROR)
  }

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("FileStreamTest")
   // var sparkContext = new SparkContext(sparkConfig)
    //sparkContext.setLogLevel("info")
    //setupLogging()

    var streamingContext = new StreamingContext(sparkConfig, Seconds(5))
    var result = streamingContext.socketTextStream("localhost", 9996).flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)

    result.print
    streamingContext.start
    streamingContext.awaitTermination
  }
}