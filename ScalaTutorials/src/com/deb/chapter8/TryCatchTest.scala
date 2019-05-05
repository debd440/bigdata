package com.deb.chapter8

object TryCatchTest {

  def main(args: Array[String]): Unit = {

    try {
      println("If Block Executed")
      var result = 25 / 0
    } catch {
      case e: ArithmeticException => println("ArithmeticException Received")
      case e: Exception => {
        println("Catch Block Executed.")
        e.printStackTrace()
      }
    } finally {
      println("Finally Block Executed")
    }
  }
}