package com.deb.chapter5

import scala.collection.immutable.HashMap

object HashMapTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: HashMap Example")
    var techMap: HashMap[String, String] = HashMap(("JAVA", "Java"), ("SCALA", "Scala"), ("SPARK", "Spark"))
    var dbMap: HashMap[String, String] = HashMap("ORACLE" -> "Oracle", "MYSQL" -> "MySql", ("HBASE", "HBase"))
    println(s"The Tech HashMap Element IS: ${techMap("JAVA")}")
    println(s"The DB HashMap Element IS: ${dbMap("HBASE")}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two HashMap Example")
    var result = techMap ++ dbMap
    result.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add/Remove Single Element Example")
    techMap = techMap + ("GO" -> "Go")
    techMap = techMap - ("JAVA")
    techMap.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 4
    println("*****************************")
    println("Example 4: Empty HashMap Example")
    val emptyHashMap: HashMap[String, String] = HashMap.empty[String, String]
    println(s"Empty list = $emptyHashMap")
  }
}