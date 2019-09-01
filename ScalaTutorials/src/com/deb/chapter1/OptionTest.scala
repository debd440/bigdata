package com.deb.chapter1

object OptionTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Basic Some Logic");
    var item: Option[String] = Some("Scala")
    println(s"Is Value Available: ${item.isDefined}")
    println(s"The Item Is: ${item.get}")

    //Example 2
    println("*****************************")
    println("Example 2: Basic None Logic");
    var item1: Option[String] = None
    println(s"Is Value Available: ${item1.isDefined}")
    println(s"The Item1 Is: ${item1}")

    //Example 3
    println("*****************************")
    println("Example 3: Option With Pattern Matching");
    item match {
      case Some("Scala") => println("Scala")
      case None          => println("Nothing Found")
      case _             => println("NA")
    }
  }
}