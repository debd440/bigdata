package com.deb.chapter5

object ListTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: List Example")
    var techList = List("Java", "Spring", "Spark", "HBase", "Hadoop")
    println("Print Elements")
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })
    println(s"Element at index 0 = ${techList(0)}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two List Example")
    var dbList = List("Oracle", "Mysql")
    var result = techList ::: dbList
    //    result = techList :: dbList //Correct
    result.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add Single Element Example")
    techList = "C" +: techList
    techList = techList :+ "Java"
    //techList = techList.drop(3) //Drops First 3 Elements
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 4
    println("*****************************")
    println("Example 4: Empty List Example")
    val emptyList: List[String] = List.empty[String]
    println(s"Empty list = $emptyList")
  }
}