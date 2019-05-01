package com.deb.chapter1

object InterpolationTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: String Interpolation");
    var sItem = "Hello Interpolation"
    println(s"The Value is: $sItem")

    //Example 2
    println("*****************************")
    println("Example 2: Evaluate Expression");
    var nItem = 10
    println(s"The Expression is: ${2 + 2}")
    println(s"The Expression is: ${nItem == 10}")
    println(s"The Expression is: ${nItem == 15}")

    //Example 3
    println("*****************************")
    println("Example 3: Format Text");
    var item1 = "Hello"
    var item2 = "World"
    println(s"$item1%20s $item2")
    println(f"$item1%20s $item2")
    val donutPrice: Double = 2.50
    println(s"Donut price = $donutPrice")

    //Example 4
    println("*****************************")
    println("Example 4: Raw Text");
    println(s"Normal Text \t = $item1")
    println(raw"Raw Text \t = $item1")

    //Example 5
    println("*****************************")
    println("Example 5: Case Class")
    var bmw: Car = Car("BMW", 150000)
    println(s"Car Model: ${bmw.model} \t Price: ${bmw.price}")
  }

  case class Car(model: String, price: Int)
}