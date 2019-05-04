package com.deb.chapter2

object FunctionTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Basic Function Without Param")
    println(s"Basic Function Without Param Result: ${funcWoParam()}")

    //Example 2
    println("*****************************")
    println("Example 2: Basic Function Without Parenthesis & Like Variable")
    println(s"Basic Function Without Parenthesis & Like Variable Result: ${funcWoParenthesis}")

    //Example 3
    println("*****************************")
    println("Example 3: Basic Function With Unit Return Type")
    println(s"Basic Function Without Return TypeResult: ${funcWoReturn()}")

    //Example 4
    println("*****************************")
    println("Example 4: Basic Function With Param")
    println(s"Basic Function With Param Result: ${funcWParam("BMW", 5000)}")

    //Example 5
    println("*****************************")
    println("Example 5: Basic Function With Default Value")
    println(s"Basic Function With Default Value Result: ${funcWDefaultValue("BMW", 5)}")
    println(s"Basic Function With Default Value Result: ${funcWDefaultValue("BMW", 10, 75)}")

    //Example 6
    println("*****************************")
    println("Example 6: Basic Function With Option Value")
    println(s"Basic Function With Option Value Result: ${funcWOption("BMW", Some(5000))}")
    println(s"Basic Function With Option Value Result: ${funcWOption("BMW", None)}")

    //Example 7
    println("*****************************")
    println("Example 7: Basic Function With Option Default Value")
    println(s"Basic Function With Option Default Value Result: ${funcWOptionDefault("BMW")}")

    //Example 8
    println("*****************************")
    println("Example 8: Basic Function With Option Return Value")
    println(s"Basic Function With Option Return Value Result: ${funcOptionReturn(20).get}")
    
    //Example 9
    println("*****************************")
    println("Example 9: Define Function As Val")
    println(s"Basic Function Def as Val Result: ${applyDiscount(20)}")
  }

  val applyDiscount=(totalCost:Int)=>{
    totalCost-2
  }
  def funcWoParam(): Int = {
    1
  }

  def funcWoParenthesis = "Function Without Parenthesis"

  def funcWoReturn():Unit = {
    println("Does Not Have Any Return Type")
  }

  def funcWParam(model: String, price: Int): Unit = {
    println(s"Model : $model & Price: $price")
  }

  def funcWDefaultValue(model: String, price: Int, tax: Int = 50): Int = {
    tax + price
  }

  def funcWOption(model: String, price: Option[Int]): Unit = {
    println(s"The Param Values Are- Model: $model & Price: ${price.getOrElse("10")}")
  }

  def funcWOptionDefault(model: String, price: Option[Int] = Some(20)): Unit = {
    println(s"The Param Values Are- Model: $model & Price: ${price.get}")
  }
  def funcOptionReturn(price: Int): Option[Int] = {
    Some(price * 10)
  }
}