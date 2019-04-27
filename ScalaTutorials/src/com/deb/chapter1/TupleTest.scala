package com.deb.chapter1

object TupleTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Basic Tuple");
    var tech = Tuple2("Scala", 5000)
    println(s"Tuple2 Values: ${tech._1} \t ${tech._2}")
    var car = Tuple3("BMW", "40", 50000)
    println(s"Tuple3 Values: ${car._1} \t ${car._2} \t ${car._3}")
    var bus = ("Volvo", 50000)
    println(s"Tuple3 Values: ${bus._1} \t ${bus._2}")

    //Example 2
    println("*****************************")
    println("Example 2: Tuple With Pattern Matching");
    var train = ("Electric", 50000)
    val itemList = List(tech, train, bus)
    val result = itemList.foreach { tuple =>
      {
        tuple match {
          case ("Scala", 5000)       => println(s"Tech Tuple Found")
          case flag if flag._1 == "Electric" => println(s"Electric Tuple Found")
          case _                     => None
        }
      }
    }
    println(s"The Result is: $result")
  }
}