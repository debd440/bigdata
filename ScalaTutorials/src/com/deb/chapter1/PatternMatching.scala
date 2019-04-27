package com.deb.chapter1

object PatternMatching {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Basic Pattern Matching");
    var tech = "Scala"
    tech match {
      case "Scala" => println("Scala")
      case "Java"  => println("Java")
      case _       => println("Nothing Found")
    }

    //Example 2
    println("*****************************")
    println("Example 2: Basic Pattern Matching With Wildcard");
    var item = "HBase"
    item match {
      case "Scala" => println("Scala")
      case "Java"  => println("Java")
      case _       => println("Nothing Found")
    }

    //Example 3
    println("*****************************")
    println("Example 1:  Pattern Matching With Callback");
    var result = tech match {
      case "Scala" => "Scala"
      case "Java"  => "Java"
      case _       => "Nothing Found"
    }
    println(s"The Result Is: $result")

    //Example 4
    println("*****************************")
    println("Example 4: Pattern Matching Without Match");
    var techList = List("Scala", "HBase")
    techList.foreach {
      case "Scala" => println("Scala")
      case "Java"  => println("Java")
      case _       => println("Nothing Found")
    }
  }
}