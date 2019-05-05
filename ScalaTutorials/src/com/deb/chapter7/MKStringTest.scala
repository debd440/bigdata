package com.deb.chapter7

object MKStringTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: MKString Example")
    var techList = List("Java", "Spring", "Spark", "Python", "Go", "C")
    println(s"The Elements Are: ${techList.mkString(";")}")

    //Example 2
    println("*****************************")
    println("Example 2: Determine List Size Example")
    println(s"The length of the list is: ${techList.size}")

    //Example 3
    println("*****************************")
    println("Example 3: Exist Example")
    var isExist = techList.exists(item => item == "Java")
    println(s"The Element Exist: $isExist")

    //Example 4
    println("*****************************")
    println("Example 4: Find Example")
    val isJavaExist = techList.find(item => item == "Java")
    val isHBaseExist = techList.find(item => item == "HBase")
    println(s"Java Exist: ${isJavaExist.getOrElse("NA")}")
    println(s"HBase Exist: ${isHBaseExist.getOrElse("NA")}")

    //Example 5
    println("*****************************")
    println("Example 5: Max/Min Example")
    println(s"The Max Value Is: ${techList.max}")
    println(s"The Min Value Is: ${techList.min}")

    //Example 6
    println("*****************************")
    println("Example 6: Reverse Example")
    println(s"The Reverse List: ${techList.reverse}")
  }
}