package com.deb.chapter2

object PassingFunctionTest {
  
   def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Basic Param Group Example")
    println(s"Total cost = ${totalCost1("Cake")(10)(0.1)}")

    //Example 2
    println("*****************************")
    println("Example 2: Calling Higher Order Function- Passing a parameter")
    println(s"Total cost of 5 Mango with discount function = ${totalCostWithFunctionParameter("Mango")(5)(applyDiscount(_))}")
     println(s"Total cost of 5 Mango with tax function = ${totalCostWithFunctionParameter("Mango")(5)(applyTax(_))}")
  }

  def totalCost1(item: String)(quantity: Int)(discount: Double): Double = {
    println(s"Calculating total cost for $quantity $item with ${discount * 100}% discount")
    val totalCost = 2.50 * quantity
    totalCost - (totalCost * discount)
  }

  def totalCostWithFunctionParameter(item: String)(quantity: Int)(f: Double => Double): Double = {
    println(s"Calculating total cost for $quantity $item")
    val totalCost = 2.50 * quantity
   // applyDiscount(totalCost)
     f(totalCost)
  }

  def applyDiscount(totalCost: Double): Double = {
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }
  
  def applyDiscount(totalCost: Double,name:String): Double = {
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }
  def applyTax(totalCost: Double): Double = {
    val tax = 2 // assume you fetch discount from database
    totalCost + tax
  }
}