package com.deb.chapter5

import scala.collection.immutable.TreeMap

object TreeMapTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: TreeMap Example")
    var techMap: TreeMap[String, String] = TreeMap(("JAVA", "Java"), ("SCALA", "Scala"), ("SPARK", "Spark"))
    var dbMap: TreeMap[String, String] = TreeMap("ORACLE" -> "Oracle", "MYSQL" -> "MySql", ("HBASE", "HBase"))
    println(s"The Tech HashMap Element IS: ${techMap("JAVA")}")
    println(s"The DB HashMap Element IS: ${dbMap("HBASE")}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two TreeMap Example")
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
    println("Example 4: Empty TreeMap Example")
    val emptyHashMap: TreeMap[String, String] = TreeMap.empty[String, String]
    println(s"Empty list = $emptyHashMap")
  }
}