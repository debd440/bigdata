package com.deb.chapter7

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Success }

object FutureTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Blocking Future Example")
    val totalPrice = Await.result(calculatePrice(2, 10), 5 seconds)
    println(s"Total Price $totalPrice")

    //Example 2
    println("*****************************")
    println("Example 2: Non Blocking Future Example")
    calculatePrice(2, 10).onComplete {
      case Success(result) => println(s"Final Price = $result")
      case Failure(e)      => println(s"Failed to result, exception = $e")
    }
  }

  def calculatePrice(discount: Int, basePrice: Int): Future[Int] = Future {
    // assume some long running database operation
    println("Calculating Price")
    basePrice - discount
  }
}