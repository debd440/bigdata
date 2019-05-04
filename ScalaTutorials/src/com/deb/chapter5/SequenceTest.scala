package com.deb.chapter5

object SequenceTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Seq Example")
    var techList = Seq("Java", "Spring", "Spark", "HBase", "Hadoop")
    println("Print Elements")
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })
    println(s"Element at index 0 = ${techList(0)}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two Seq Example")
    var dbList = Seq("Oracle", "Mysql")
    var result = techList ++ dbList
    result.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add Single Element Example")
    techList = "C" +: techList
    techList = techList :+ "Java"
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 4
    println("*****************************")
    println("Example 4: Empty Seq Example")
    val emptyList: Seq[String] = Seq.empty[String]
    println(s"Empty list = $emptyList")
  }
}