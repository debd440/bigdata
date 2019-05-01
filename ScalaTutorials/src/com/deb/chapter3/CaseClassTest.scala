package com.deb.chapter3

object CaseClassTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Case Class Example")
    var bmw = Car("BMW", 1000)
    println(s"Case Class Values Are: Model: ${bmw.model} Price: ${bmw.price}")
    // bmw.model="Audi"  //Compilation Error
    println(s"Case Class Values Are: Model: ${bmw.model} Price: ${bmw.price}")
    println(s"Case Class To String Values: ${bmw.toString()}")
    println(s"Case Class To Hash Code Values: ${bmw.hashCode()}")
  }
}

case class Car(model: String, price: Int)