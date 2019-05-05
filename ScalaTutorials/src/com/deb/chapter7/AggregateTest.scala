package com.deb.chapter7

object AggregateTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Aggregate Example")
    var techSet = Set("Java", "Spring", "Spark")
    val techLengthAccumulator: (Int, String) => Int = (accumulator, techName) => accumulator + techName.length
    val totalLength = techSet.aggregate(0)(techLengthAccumulator, _ + _)
    println(s"Total legth = $totalLength")

    //Example 2
    println("*****************************")
    println("Example 2: Aggregate Example")
    var scalaBatch = Batch("Scala", 10)
    var hadoopBatch = Batch("Scala", 15)
    var hbaseBatch = Batch("Scala", 25)
    var batchSet = Set(scalaBatch, hadoopBatch, hbaseBatch)
    val batchAccumulator: (Int, Batch) => Int = (accumulator, batch) => accumulator + batch.count
    val totalStudent = batchSet.aggregate(0)(batchAccumulator, _ + _)
    println(s"Total Student = $totalStudent")
  }

  case class Batch(name: String, count: Int)
}