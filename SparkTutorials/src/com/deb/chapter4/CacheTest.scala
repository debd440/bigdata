package com.deb.chapter4

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object CacheTest {
  
  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")
    
     var itemRDD= sparkContext.parallelize(1 to 10)
     itemRDD.cache()
     itemRDD.persist()
     println(s"Result: ${itemRDD.count()}")
  }
}