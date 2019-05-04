package com.deb.chapter3

object ImplicitTest {

  def main(args: Array[String]): Unit = {

    //TODO
    //Example 1
    println("*****************************")
    println("Example 1: Implicit Class Example")

    case class Fruits(name: String, price: Int)
    case class Car(name: String, price: Int)
    var fruits = Fruits("Water Melon", 10)

    object FruitsImplicit {
      implicit class Apple(fru: Fruits) {
        def print = s"${fru.name}${fru.price}"
        def draw = s"${fru.name}${fru.price}"
      }

      implicit class Banana(fru: Car) {
        def print1 = s"${fru.name}${fru.price}"
        def draw1 = s"${fru.name}${fru.price}"
      }
    }

    import FruitsImplicit._

    println(s"${fruits.print}")
    println(s"${fruits.draw}")
  }
}
