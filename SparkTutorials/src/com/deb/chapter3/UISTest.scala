package com.deb.chapter3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object UISTest {

  def main(args: Array[String]): Unit = {

    var sparkConfig = new SparkConf().setMaster("local").setAppName("BroadcastTest")
    var sparkContext = new SparkContext(sparkConfig)
    sparkContext.setLogLevel("info")

    var rdd1 = sparkContext.parallelize(List(15, 8, 10, 2, 4))
    var rdd2 = sparkContext.parallelize(List(15, 25, 8, 19, 11))

    //Example 1
    println("*****************************")
    println("Example 1: Union Example: Add both RDD")
    var unionRDD = rdd1.union(rdd2)
    println("Union Result")
    unionRDD.foreach(println)

    //Example 2
    println("*****************************")
    println("Example 2: Intersection Example: Return Common RDD")
    var intersectionRDD = rdd1.intersection(rdd2)
    println("Intersection Result")
    intersectionRDD.foreach(println)

    //Example 3
    println("*****************************")
    println("Example 3: Subtract Example: Return value which are not present in 2nd RDD")
    var subtractRDD = rdd1.subtract(rdd2)
    println("Subtract Result")
    subtractRDD.foreach(println)

    //Example 4
    println("*****************************")
    println("Example 4: Subtract By Key Example:Return value which are not present in 2nd RDD Based on Key")
    var techRDD = sparkContext.parallelize(List(("Java", 30), ("Spring", 30), ("Scala", 10)))
    var dbRDD = sparkContext.parallelize(List(("Java", 20), ("Oracle", 30), ("Mysql", 10)))
    var subtractByKeyRDD = techRDD.subtractByKey(dbRDD)
    println("Subtract By Key Result")
    subtractByKeyRDD.foreach(println)
  }
}