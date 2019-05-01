package com.deb.chapter3

object ClassTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Default & Primary Constructor")
    var student = new Student()
    var department = new Department("Math", 50)
    student.print
    department.print

    //Example 2
    println("*****************************")
    println("Example 2: Secondary Constructor")
    var student2 = new Student("Sunil", "Bangalore")
    var department2 = new Department("English", 50, "ENG")
    student2.print
    department2.print
  }
}