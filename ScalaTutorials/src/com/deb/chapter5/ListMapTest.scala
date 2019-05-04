package com.deb.chapter5

import scala.collection.immutable.ListMap

object ListMapTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: ListMap Example")
    var techList = ListMap("J" -> "Java", "S" -> "Spring", "SP" -> "Spark")
    println("Print Elements")
    techList.foreach(item => {
      println(s"The Item Is: ${item._1} \t ${item._2}")
    })
    println(s"J Param Values is = ${techList("J")}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two ListMap Example")
    var dbList = List("O" -> "Oracle")
    var result = techList ++ dbList
    result.foreach(item => {
      println(s"The Item Is: ${item._1} \t ${item._2}")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add/Remove/Duplicate Single Element Example")
    techList = techList + ("Z" -> "Zing")
    techList = techList - ("J")
    techList = techList + ("SP" -> "Scala")
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })
    
    //Example 5
    println("*****************************")
    println("Example 5: Empty ListMaap Example")
    val emptyList: ListMap[String,String] = ListMap.empty[String,String]
    println(s"Empty list = $emptyList")
  }
}