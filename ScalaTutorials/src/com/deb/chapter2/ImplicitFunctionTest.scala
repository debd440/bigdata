package com.deb.chapter2

object ImplicitFunctionTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Implecit Param")
    implicit val discount: Double = 0.1
    println(s"Total cost with discount of 5  Item = ${totalCost("Biscuit", 5)}")
  }

  def totalCost(item: String, quantity: Int)(implicit discount: Double): Double = {

    println(s"Calculating the price for $quantity item")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }
}