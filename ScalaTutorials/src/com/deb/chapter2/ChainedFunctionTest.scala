package com.deb.chapter2

object ChainedFunctionTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Chained Function Example: And Then")
    val totalCost: Double = 10
    println(s"Total cost of 5 Mango = ${(applyDiscount andThen applyTax)(totalCost)}")

    //Example 2
    println("*****************************")
    println("Example 2: Chained Function Example- Compose")
    println(s"Total cost of 5 Apple = ${(applyDiscount compose applyTax)(totalCost)}")

    //Ordering using andThen: f(x) andThen g(x) = g(f(x))
    //Ordering using compose: f(x) compose g(x) = f(g(x))
  }

  val applyDiscount = (amount: Double) => {
    println("Apply discount function")
    val discount = 2
    amount - discount
  }

  val applyTax = (amount: Double) => {
    println("Apply tax function")
    val tax = 1
    amount + tax
  }
}