package com.deb.chapter4

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object BroadcastTest {
  
  
  def main(args: Array[String]): Unit = {
    
    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext= new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")
    
    var itemRDD= sparkContext.parallelize(List(1,2,3))
    var brodcastVal= sparkContext.broadcast(2)
    
    println("Printing Result")
    var resultRDD= itemRDD.map(key=>brodcastVal.value+key)
    resultRDD.collect().foreach(println)
    
  }
}