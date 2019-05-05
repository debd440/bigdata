package com.deb.chapter8

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

    //Example 3
    println("*****************************")
    println("Example 3: Chaining Using Flatmap Example")
    var volvo = Bus("Volvo", 1000)
    val result: Future[Int] = calculateTax(volvo).flatMap(qty => totalCost(qty))
    Await.result(result, 5 seconds)
    println(s"The Result Is: $result")

    //Example 4
    println("*****************************")
    println("Example 4: Chaining Using For Example")
    for {
      stock <- calculateTax(volvo)
      value <- totalCost(stock)
    } yield println(s"Tnx Result = $value")

  }

  def calculatePrice(discount: Int, basePrice: Int): Future[Int] = Future {
    // assume some long running database operation
    println("Calculating Price")
    basePrice - discount
  }

  def calculateTax(bus: Bus): Future[Int] = Future {
    // assume some long running database operation
    println("Calculating Tax")
    bus.price + 3
  }
  def totalCost(price: Int): Future[Int] = Future {
    // assume some long running database operation
    println("Calculating Total Cost")
    price + 5
  }
  case class Bus(model: String, price: Int)
}