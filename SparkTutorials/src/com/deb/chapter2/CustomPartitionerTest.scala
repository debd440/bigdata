package com.deb.chapter2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object CustomPartitionerTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("HashPartionerTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(1 to 10).map((_, 1)).partitionBy(new CustomPartitioner(3))
    dataRDD.partitioner
    dataRDD.glom().collect()
    dataRDD.saveAsTextFile("file:///home/debdutta/HadoopEnviornment/data/output/custom")
  }
}