package com.deb.chapter6

import scala.collection.mutable.Set

object SetTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Set Example")
    var techSet = Set("Java", "Spring", "Spark")
    println("Print Elements")
    techSet.foreach(item => {
      println(s"The Item Is: $item")
    })
    println(s"Is Java Element Exist = ${techSet("Java")}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two Set Example")
    var dbSet = Set("Oracle", "Mysql")
    var result = techSet ++= dbSet
    result.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add/Remove Single Element Example")
    techSet = techSet += ("C")
    techSet = techSet += ("Oracle")
    techSet = techSet -= "Java"
    techSet.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 4
    println("*****************************")
    println("Example 4: Empty Set Example")
    val emptySet: Set[String] = Set.empty[String]
    println(s"Empty Set = $emptySet")

    //Example 5
    println("*****************************")
    println("Example 5: Find Difference Between two sets")
    println(s"Difference between Tech Set and DB Set = ${techSet &~ dbSet}")

    //Example 6
    println("*****************************")
    println("Example 6: Find Similarities Between two sets")
    println(s"Difference between Tech Set and DB Set = ${techSet & dbSet}")
  }
}