package com.deb.chapter5

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds

class TwitterStreamTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("TwitterStreamTest")
    var streamingContext = new StreamingContext(sparkConfig, Seconds(20))
    //var configurationBuilder= new Configurationb
  }
}