package com.deb.chapter5

import scala.collection.immutable.ListSet

object ListSetTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: ListSet Example")
    var techList = ListSet("Java", "Spring")
    println("Print Elements")
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })
    println(s"Is Java Available = ${techList("Java")}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two List Example")
    var dbList = List("Oracle", "Mysql")
    var result = techList ++ dbList
    result.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add Single Duplicate Element Example")
      techList = techList + "Go"
    techList = techList + "Java"
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 4
    println("*****************************")
    println("Example 4: Remove Single Element Example")
    techList = techList - "Java"
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 5
    println("*****************************")
    println("Example 5: Empty ListSet Example")
    val emptyList: ListSet[String] = ListSet.empty[String]
    println(s"Empty list = $emptyList")
  }
}