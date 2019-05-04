package com.deb.chapter5

import scala.collection.immutable.Queue

object QueueTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Queue Example")
    var techList = Queue("Java", "Spring", "Spark", "HBase", "Hadoop")
    println("Print Elements")
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })
    println(s"Element at index 0 = ${techList(0)}")

    //Example 2
    println("*****************************")
    println("Example 2: Concat Two Queue Example")
    var dbList = List("Oracle", "Mysql")
    var result = techList ++ dbList
    result.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 3
    println("*****************************")
    println("Example 3: Add Single Element Example")
    techList = "C" +: techList
    techList = techList :+ "Java"
    techList = techList.enqueue("Go")
    techList.foreach(item => {
      println(s"The Item Is: $item")
    })

    //Example 4
    println("*****************************")
    println("Example 4: Empty Queue Example")
    val emptyQueue: Queue[String] = Queue.empty[String]
    println(s"Empty Queue = $emptyQueue")

    //Example 5
    println("*****************************")
    println("Example 5: DeQueue Example")
    val dequeue: (String, Queue[String]) = techList.dequeue
    println(s"First element dequeue = ${dequeue._1}")
    println(s"Remaining elements after dequeue = ${dequeue._2}")

  }
}