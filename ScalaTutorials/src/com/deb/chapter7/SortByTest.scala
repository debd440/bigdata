package com.deb.chapter7

object SortByTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Sort By Example")
    var bmw = Car("BMW", 500)
    var audi = Car("Audi", 300)
    var safari = Car("Safari", 100)
    var wagonR = Car("WagonR", 400)
    var carList = List(bmw, audi, safari, wagonR)
    var result = carList.sortBy(_.model)
    result.foreach(data => {
      println(s"The Elements Are: $data")
    })

    //Example 2
    println("*****************************")
    println("Example 2: Sort With Example")
    var res = carList.sortWith(_.price < _.price)
    res.foreach(data => {
      println(s"The Elements Are: $data")
    })

  }
}

case class Car(model: String, price: Int)