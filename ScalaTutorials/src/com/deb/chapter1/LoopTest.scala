package com.deb.chapter1

object LoopTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Normal Loop");
    for (item <- 1 to 3) {
      println(s"Printing Loop Values: $item")
    }

    //Example 2
    println("*****************************")
    println("Example 2: Normal Loop To Command Using Range");
    var range1: Range = 1 to 3
    for (item <- range1) {
      println(s"Printing Loop Values: $item")
    }

    //Example 3
    println("*****************************")
    println("Example 3: Normal Loop Until Command Using Range");
    var range2: Range = 1 until 3
    for (item <- range2) {
      println(s"Printing Loop Values: $item")
    }

    //Example 4
    println("*****************************")
    println("Example 4: Normal Loop with to and by Command Using Range");
    var range3: Range = 1 to 4 by 2
    for (item <- range3) {
      println(s"Printing Loop Values: $item")
    }

    //Example 5
    println("*****************************")
    println("Example 5: Normal Loop with If Statement");
    var tech: List[String] = List("Java", "Hadoop", "HBase", "Scala", "Spark")
    for (item <- tech if item == "Java" || item == "HBase") {
      println(s"Selecte Item Found. $item")
    }

    //Example 6
    println("*****************************")
    println("Example 6: Loop With Callback");
    var result = for {
      item <- tech
      if (item == "Java" || item == "HBase")
    } yield item
    println(s"Result Is: $result")

    //Example 7
    println("*****************************")
    println("Example 7: While Loop");
    var value = 10
    while (value < 11) {
      println(s"Execute While Loop With Value: $value")
      value = value + 1
    }

    //Example 8
    println("*****************************")
    println("Example 8: Do While Loop");
    var count = 5
    do {
      println(s"Executing Do While Loop For Count: $count")
    } while (count > 5)

  }
}