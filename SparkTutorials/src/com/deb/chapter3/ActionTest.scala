package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object ActionTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("ActionTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop", "C", "Go", "Scala", "Spark", "Android", "J2ME"), 4)
    var techRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop", "C", "Go", "Scala", "Spark", "Android", "J2ME"))
    var digitRDD = sparkContext.parallelize(List(10, 20, 90, 55, 1, 77))
    var pairedData = techRDD.keyBy(_.charAt(0))

    println(s"No Of Partition: ${dataRDD.getNumPartitions}")
    println(s"Partition Size: ${dataRDD.partitions.size}")

    println(s"Collect Example: ${dataRDD.collect().foreach(println)}")
    println(s"Glom Collect TO Show Partition Data Example: ${dataRDD.glom.collect().foreach(println)}")
    println(s"Collect As Map: Convert Paired RDD into Map: ${pairedData.collectAsMap()}")
    
    println(s"Printing First 2 Elements using take ${techRDD.take(2).foreach(println)}")
    println(s"Printing Top 2 Elements using top ${techRDD.top(2).foreach(println)}")

    println(s"Reduce Using Action: ${digitRDD.reduce(_ + _)}")
    println(s"Max Element: ${digitRDD.max}")
    println(s"Min Element: ${digitRDD.min}")
    println(s"Sum Element: ${digitRDD.sum}")
    println(s"Mean Element: ${digitRDD.mean}")
    println(s"Count Element: ${digitRDD.count}")

    println(s"Count By Key Example: ${pairedData.countByKey()}")
    println(s"Count By Value Example: ${pairedData.countByValue()}")

    //Others foreach & SaveAsTextFile
    pairedData.saveAsTextFile("file:///home/debdutta/HadoopEnviornment/data/spark/output/result.txt")
  }
}