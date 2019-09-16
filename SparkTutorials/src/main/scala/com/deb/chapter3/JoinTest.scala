package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object JoinTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("JoinTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(Array(("JA", "Java"), ("HD", "Hadoop"), ("HB", "HBase")))
    var dataRDD1 = sparkContext.parallelize(Array(("SP", "Spark"), ("SC", "Scala"), ("HB", "HBase")))
    println("Join Example: Return Matching Data")
    var resultRDD = dataRDD.join(dataRDD1).collect()
    resultRDD.foreach(println)

    println("Left OuterJoin Example: Return Matching data and First RDD data")
    var resultRDD1 = dataRDD.leftOuterJoin(dataRDD1).collect()
    resultRDD1.foreach(println)

    println("Right OuterJoin Example: Return Matching data and Second RDD data")
    var resultRDD2 = dataRDD.rightOuterJoin(dataRDD1).collect()
    resultRDD2.foreach(println)

    println("Full OuterJoin Example: Return both 1st & 2nd RDD data including matching ones")
    var resultRDD3 = dataRDD.fullOuterJoin(dataRDD1).collect()
    resultRDD3.foreach(println)
  }
}