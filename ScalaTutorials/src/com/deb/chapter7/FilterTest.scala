package com.deb.chapter7

object FilterTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Filter Example")
    var techList = List("Java", "Spring", "Spark")
    var result = techList.filter(item => {
      item.contains("Java") || item.contains("Spark")
    })
    result.foreach(data => {
      println(s"The Elements Are: $data")
    })

    //Example 2
    println("*****************************")
    println("Example 2: Filter Not Example")
    result = techList.filterNot(item => {
      item.contains("Java")
    })
    result.foreach(data => {
      println(s"The Elements Are: $data")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Filter Example")
    var marks = List(30, 46, 99, 27, 48, 65, 83, 23)
    var res = marks.filter(k => if (k > 45) true else false)
    res.foreach(data => {
      println(s"The Passing Marks Are: $data")
    })
  }
}