package com.deb.chapter3

object CompanionTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Companion Class Constructor")
    var department = Department("Java", 60)
    department.print
    var department2 = Department("Scala", 30, "SCA")
    department2.print
    println(s"Department Code: ${department.code}")
    println(s"Department2 Code: ${department2.code}")

    //Example 2
    println("*****************************")
    println("Example 2: Companion Class With Inheritance")
    var employee = Employee("Deb", Some("P"))
    var employee1 = Employee("Rahul", Some("C"))
    var employee2 = Employee("Mukul", None)

  }
}