package com.deb.chapter1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.collection.immutable.Range

object EvenOddFilterTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("OddEventFilterTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")
    sparkContext.setJobDescription("The program design to filter odd and even no")

    var item: Range = 1 to 10
    var data = sparkContext.parallelize(item)

    var evenRDD = data.filter((key)=> key % 2 == 0)
    println("Printing Even nuber")
    evenRDD.collect().foreach(key=>{
      println(s"Collected Even Numbers Are: $key")
    })
    

    var oddRDD= data.filter(key=>key%2!=0)
    println("Printing Odd Number")
    oddRDD.collect().foreach(key=>{
       println(s"Collected Odd Numbers Are: $key")
    })
    
  }
}