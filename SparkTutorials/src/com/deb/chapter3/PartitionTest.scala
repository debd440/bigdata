package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object PartitionTest {

  //Iterates over every partition
  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("PartitionTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(List("Java", "HBase", "Hadoop", "C", "Go"), 3)
    var mapPartitionsRDD = dataRDD.mapPartitions(x => x.map(y => (y, 1)))
    mapPartitionsRDD.glom.collect()
    println("Partition Example with mapPartitions: Iterates over every partition ")
    println(s"Printing Partition Result ${mapPartitionsRDD.foreach(println)}")

    println("Coalesce Example: Reduce Partitions")
    var coalesceRDD = dataRDD.coalesce(2)
    println(s"Updating Partition Result ${coalesceRDD.foreach(println)}")

    println("Repartition Example")
    var repartitionRDD = dataRDD.coalesce(4)
    println(s"Repartition Result ${repartitionRDD.foreach(println)}")
  }
}