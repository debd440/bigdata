package com.deb.chapter1

object EnumTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Basic Enum Test");
    println(s"Get Hadoop Value ${TechEnum.HADOOP}")
    println(s"Get Scala Value ${TechEnum.SCALA}")
    println(s"Get Hadoop Id ${TechEnum.HADOOP.id}")
    println(s"Get Scala Id ${TechEnum.SCALA.id}")
    println(s"Print All Enum Values: ${TechEnum.values}")

    //Example 2
    println("*****************************")
    println("Example 2: Enum With Pattern Matching Test");
    TechEnum.values.foreach {
      case d if (d == TechEnum.SCALA) => println("Scala Found")
      case _                          => println("Nothing Found")
    }
  }
}