package com.deb.chapter6

import scala.collection.mutable.TreeSet

object TreeSetTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: TreeSet Example")
    var techSet = TreeSet("Java", "Spring", "Spark")
    println("Print Elements")
    techSet.foreach(item => {
      println(s"The Item Is: $item")
    })
    println(s"Is Java Element Exist = ${techSet("Java")}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two TreeSet Example")
    var dbSet = TreeSet("Oracle", "Mysql")
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
    println("Example 4: Empty TreeSet Example")
    val emptySet: TreeSet[String] = TreeSet.empty[String]
    println(s"Empty Set = $emptySet")

    //Example 5
    println("*****************************")
    println("Example 5: Find Difference Between two tree sets")
    println(s"Difference between Tech Set and DB Set = ${techSet &~ dbSet}")

    //Example 6
    println("*****************************")
    println("Example 6: Find Similarities Between two tree sets")
    println(s"Difference between Tech Set and DB Set = ${techSet & dbSet}")

    //Example 7
    println("*****************************")
    println("Example 7: Initializing Sorted Tree Set")
    val sortedTreeSet = TreeSet("Oracle", "Mysql", "Java")(AlphabetOrdering)
    sortedTreeSet.foreach(item => {
      println(s"The Item Is: $item")
    })
  }
}

object AlphabetOrdering extends Ordering[String] {
  def compare(element1: String, element2: String) = element1.compareTo(element2)
}
