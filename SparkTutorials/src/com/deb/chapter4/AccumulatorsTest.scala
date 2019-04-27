package com.deb.chapter4

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object AccumulatorsTest {
  
  def main(args: Array[String]): Unit = {
    
    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext= new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")
    
    var accum= sparkContext.accumulator(0, "TestAccume")
    var dataRDD= sparkContext.parallelize(List(1,2,3))
    dataRDD.foreach(x=>accum+=x)
    println(s"The result is: ${accum.value}")
  }
}