package com.deb.chapter1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object EvenOddNumberCountTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("EvenOddNumberCountTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setJobDescription("This is to determine no of odd and even number")
    sparkContext.setLogLevel("info")

    //var data = sparkContext.textFile("file:///home/debdutta/HadoopEnviornment/data/input/number.txt")
     var data = sparkContext.textFile("hdfs://localhost:9000/user/root/input/number.txt")
    var dataRDD = data.flatMap(line => line.split(","))
    var numberRDD = dataRDD.map(item => item.toInt)

    var evenRDD = numberRDD.filter(_ % 2 == 0)
    println("Printing Even No from File")
    evenRDD.collect().foreach(key => {
      println(s"Collected Even Numbers Are: $key")
    })

    var oddRDD = numberRDD.filter(key => key % 2 != 0)
    println("Printing Odd Number")
    oddRDD.collect().foreach(key => {
      println(s"Collected Odd Numbers Are: $key")
    })

    println("Finding Counts")
    var evenMapRDD = evenRDD.map(number => (number, 1))
    var evenCountRDD = evenMapRDD.reduceByKey((sum, b) => sum + b)
    evenCountRDD.collect().foreach(key => {
      println(s"Collected Even Count Are: $key")
    })

    println("Sorting Elements")
    var sortedRDD = evenMapRDD.sortByKey()
    sortedRDD.collect().foreach(key => {
      println(s"Collected Sorted Even Number Are: $key")
    })
  }
}