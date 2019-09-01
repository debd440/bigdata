package com.deb.chapter3

class Student {

  def print() = {
    println("Inside Student Class Print Method: Default Constructor")
  }

  def this(name: String, city: String) {
    this()
    println(s"Received Values Are - Name: $name & City: $city")
  }
}

object Student {

  def apply: Student = {
    new Student
  }
}
