package com.deb.chapter3

object TypeDataTest {

  def main(args: Array[String]): Unit = {
    //Example 1
    println("*****************************")
    println("Example 1: Type Example")
    var bmw = Car("BMW", 5000)
    type CarList = Tuple2[Car, Int]

    var carDetais = new CarList(bmw, 4)
    println(s"carDetais = carDetais")
    println(s"carDetais first value = ${carDetais._1}")
    println(s"carDetais second value = ${carDetais._2}")
  }
}