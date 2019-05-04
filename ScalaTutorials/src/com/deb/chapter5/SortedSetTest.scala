package com.deb.chapter5

import scala.collection.immutable.SortedSet

object SortedSetTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1:  SortedSet Example")
    var techSet = SortedSet("Java", "Spring", "Spark")
    println("Print Elements")
    techSet.foreach(item => {
      println(s"The Item Is: $item")
    })
    println(s"Is Java Element Exist = ${techSet("Java")}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two  SortedSet Example")
    var dbSet = SortedSet("Oracle", "Mysql")
    var result = techSet ++ dbSet
    result.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add/Remove Single Element Example")
    techSet = techSet + ("C")
    techSet = techSet + ("Oracle")
    techSet = techSet - "Java"
    techSet.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 4
    println("*****************************")
    println("Example 4: Empty  SortedSet Example")
    val emptySet: SortedSet[String] = SortedSet.empty[String]
    println(s"Empty  SortedSet = $emptySet")

    //Example 5
    println("*****************************")
    println("Example 5: Find Difference Between two  SortedSet")
    println(s"Difference between Tech Set and DB Set = ${techSet &~ dbSet}")

    //Example 6
    println("*****************************")
    println("Example 6: Find Similarities Between two  SortedSet")
    println(s"Difference between Tech Set and DB Set = ${techSet & dbSet}")
  }
}