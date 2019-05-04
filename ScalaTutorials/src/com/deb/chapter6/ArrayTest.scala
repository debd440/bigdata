package com.deb.chapter6

object ArrayTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Array Example")
    val tech: Array[String] = Array("Java", "Scala", "Spark")
    println(s"Elements of Tech Array = ${tech.mkString(", ")}")
    println(s"Element at index 0 = ${tech(0)}")
    println(s"Element at index 1 = ${tech(1)}")

    //Example 2
    println("*****************************")
    println("Example 2: Array Example")
    val db: Array[String] = new Array(2)
    db(0) = "Oraclet"
    db(1) = "DB2"
    println(s"Elements of DB Array = ${db.mkString(", ")}")

    //Example 3
    println("*****************************")
    println("Example 3: 2D Array Example")
    val rows = 2
    val columns = 2
    val stackDetails: Array[Array[String]] = Array.ofDim[String](rows, columns)
    stackDetails(0)(0) = "Java"
    stackDetails(0)(1) = "Scala"
    stackDetails(1)(0) = "Kafka"
    stackDetails(1)(1) = "RabbitMQ"
    println(s"Elements of 2 dimensional array = ${stackDetails.deep.toList}")

  }
}