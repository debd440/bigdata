package com.deb.chapter7

object FlatmapTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Flatmap Example")
    var list = List("Java Spring Spark")
    println("Before Operation")
    list.foreach(data => {
      println(s"The Elements Are: $data")
    })
    var result = list.flatMap(item => item.split(" "))
    println("After Operation in FlatMap")
    result.foreach(data => {
      println(s"The Elements Are: $data")
    })

  }
}