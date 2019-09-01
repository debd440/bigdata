package com.deb.chapter2

object ParameterGroupTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Basic Param Group Example")
    println(s"Total cost = ${totalCost("Cake")(10)(0.1)}")

    //Example 2
    println("*****************************")
    println("Example 2: Partial Param Group Example")
    println(s"Total cost = ${totalCost("Cake")_}")

    //Example 3
    println("*****************************")
    println("Example 3: Partial Param Group Example")
    val partialCost = totalCost("Mango") _
    println(s"Total cost for Mango in Karnataka ${partialCost(10)(0.1)}")
    println(s"Total cost for Mango in Goa ${partialCost(10)(0.2)}")
  }

  def totalCost(item: String)(quantity: Int)(discount: Double=5): Double = {

    println(s"Calculating total cost for $quantity $item with ${discount * 100}% discount")
    val totalCost = 2.50 * quantity
    totalCost - (totalCost * discount)
  }
}