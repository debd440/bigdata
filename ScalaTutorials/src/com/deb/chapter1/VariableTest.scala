package com.deb.chapter1

object VariableTest {

  var wItem: String = _
  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Immutable Variable")
    val imItem = 5
    //imItem=7 //Error
    println("The Immutable Variable Value is: " + imItem)
    println(s"The Immutable Variable Value is: $imItem")

    //Example 2
    println("*****************************")
    println("Example 2: Mutable Variable");
    var mItem = "Hello Scala"
    mItem = "My First Mutable Variable"
    println(s"The Mutable Variable Value is: $mItem")

    //Example 3
    println("*****************************")
    println("Example 3: Lazy initialization")
    lazy val lItem = "Lazy Variable"
    //lazy var lItem="Lazy Variable" //Error
    println(s"The Lazy Variable Value is: $lItem")

    //Example 4
    println("*****************************")
    println("Example 4: Different Type Of Variable")
    var type1: Any = "Any"
    var type2: AnyVal = 12
    var type3: AnyRef = "AnyRef"
    //Byte, Short, Int, Long, Float, Double, Char, Boolean, Unit
    var type4: Int = 15
    var type5: Boolean = true
    var type6 = () //Unit
    var ref1: List[String] = List("Scala", "Java")
    var ref2: Option[Int] = Some(10)
    println(s"Printing Any Value Variables Below :")
    println(s"Type1: $type1 \t Type2: $type2 \t Type3: $type3 \t Type4: $type4 \t Type5: $type5 \t Type6: $type6 ")
    println(s"Printing Any Value Variables Below :")
    println(s"Ref1: $ref1 \t Ref2: $ref2")

    //Example 5
    println("*****************************")
    println("Example 5: Wildcard Operator")
    println(s"The Wildcard Variable Value Before Assignment is: $wItem")
    wItem = "Hello Wildcard Operator"
    println(s"The Wildcard Variable Value is: $wItem")
  }
}