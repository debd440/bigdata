package com.deb.chapter2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.RangePartitioner

object RangePartitionerTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("HashPartionerTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var dataRDD = sparkContext.parallelize(1 to 10).map((_, 1))
    var resultRDD = dataRDD.partitionBy(new RangePartitioner(3, dataRDD))
    resultRDD.glom().collect()
    resultRDD.saveAsTextFile("file:///home/debdutta/HadoopEnviornment/data/output/rangepartitoner")
  }
}