package com.deb.chapter1

object EscapeTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Triple Quote Charecter");
    val car: String = """{"model":"BMW","price":"15000"}"""
    println(s"Car  = $car")

    //Example 2
    println("*****************************")
    println("Example 2: BackSlash Charecter");
    val bus: String = "{\"model\":\"Volvo\",\"price\":\"35000\"}"
    println(s"Bus  = $bus")

  }
}