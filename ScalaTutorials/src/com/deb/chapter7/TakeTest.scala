package com.deb.chapter7

object TakeTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Take Method Example")
    var techList = List("Java", "Spring", "Spark", "HBase", "Hive", "Flume")
    var result = techList.take(3)
    result.foreach(item => {
      println(s"The Elements Are: $item")
    })
  }
}