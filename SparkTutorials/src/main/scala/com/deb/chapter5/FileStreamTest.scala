package com.deb.chapter5

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds

object FileStreamTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("FileStreamTest")
   // var sparkContext = new SparkContext(sparkConfig)
    //sparkContext.setLogLevel("info")

    var streamingContext = new StreamingContext(sparkConfig, Seconds(20))
    //Hdfs Location "hdfs://localhost:9000/user/root/input/b2c.txt"
    var result = streamingContext.textFileStream("hdfs://localhost:9000/user/root/spark/input/")
    var words = result.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)

    words.print()
    //  result.saveAsTextFiles("file:///home/debdutta/HadoopEnviornment/data/spark/output/result.txt")
    streamingContext.start
    streamingContext.awaitTermination
  }
}