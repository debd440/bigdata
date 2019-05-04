package com.deb.chapter5

object MapTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Map Example")
    var techMap: Map[String, String] = Map(("JAVA", "Java"), ("SCALA", "Scala"), ("SPARK", "Spark"))
    var dbMap: Map[String, String] = Map("ORACLE" -> "Oracle", "MYSQL" -> "MySql", ("HBASE", "HBase"))
    println(s"The Tech Map Element IS: ${techMap("JAVA")}")
    println(s"The DB Map Element IS: ${dbMap("HBASE")}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two Map Example")
    var result = techMap ++ dbMap
    result.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add/Remove Single Element Example")
    techMap = techMap + ("HIVE" -> "Hive")
    techMap = techMap - ("JAVA")
    techMap.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 4
    println("*****************************")
    println("Example 4: Empty Map Example")
    val emptyMap: Map[String, String] = Map.empty[String, String]
    println(s"Empty list = $emptyMap")
  }
}