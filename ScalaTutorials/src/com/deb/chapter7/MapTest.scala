package com.deb.chapter7

object MapTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Map Example")
    var techList = List("Java", "Spring", "Spark")
    val result = techList.map(item => item.toUpperCase())
    result.foreach(item => {
      println(s"The Elements Are: $item")
    })
  }
}