package com.deb.chapter2

object PassingFunctionTest {
  
   def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Basic Param Group Example")
    println(s"Total cost = ${totalCost("Cake")(10)(0.1)}")

    //Example 2
    println("*****************************")
    println("Example 2: Calling Higher Order Function- Passing a parameter")
    println(s"Total cost of 5 Mango with discount function = ${totalCostWithFunctionParameter("Mango")(5)(applyDiscount(_))}")
  }

  def totalCost(item: String)(quantity: Int)(discount: Double): Double = {
    println(s"Calculating total cost for $quantity $item with ${discount * 100}% discount")
    val totalCost = 2.50 * quantity
    totalCost - (totalCost * discount)
  }

  def totalCostWithFunctionParameter(item: String)(quantity: Int)(f: Double => Double): Double = {
    println(s"Calculating total cost for $quantity $item")
    val totalCost = 2.50 * quantity
    f(totalCost)
  }

  def applyDiscount(totalCost: Double): Double = {
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }
}