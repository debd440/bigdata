package com.deb.chapter7

object GroupByTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Group By Example")
    var list = Map(("Apple", "50"), ("Banana", "45"), ("Apple", "90"), ("Banana", "145"))
    var result = list.groupBy(_._1)
    result.foreach(item => {
      println(s"The Elements Are: $item")
    })

    //Example 2
    println("*****************************")
    println("Example 2: Group By Example")
    var techList = List("Java", "Spring", "Spark")
    var response = techList.groupBy(_.charAt(0))
    response.foreach(item => {
      println(s"The Elements Are: $item")
    })
  }

}