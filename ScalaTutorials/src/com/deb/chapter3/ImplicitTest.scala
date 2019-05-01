package com.deb.chapter3

object ImplicitTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Implicit Class Example")

    case class Fruits(name: String, price: Int)
    var fruits = Fruits("Water Melon", 10)

    object FruitsImplicit {
      implicit class Apple(fruits: Fruits) {
        def print = s"${fruits.name}${fruits.price}"
      }
    }

    import FruitsImplicit._

    println(s"${fruits.print}")
  }
}
