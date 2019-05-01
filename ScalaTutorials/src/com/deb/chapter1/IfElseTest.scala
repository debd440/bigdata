package com.deb.chapter1

object IfElseTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Only If Example")
    val data = 10
    if (data == 10) 
      println("Printing Only If Condition")
    

    //Example 2
    println("*****************************")
    println("Example 2:  If Else Example")
    if (data == 15) {
      println("Printing  If Condition")
    } else {
      println("Printing Else Condition")
    }

    //Example 3
    println("*****************************")
    println("Example 3:  If ElseIF Else Example")
    if (data == 15) {
      println("Printing  If Condition")
    } else if (data == 10) {
      println("Printing Else If Condition")
    } else {
      println("Printing Else Condition")
    }

    //Example 4
    println("*****************************")
    println("Example 4:  Assign Value")
    var result = if (data == 10) (data * 10) else (data * 20)
    println(s"Result is: $result")

  }
}