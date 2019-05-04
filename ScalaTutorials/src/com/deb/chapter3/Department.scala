package com.deb.chapter3

class Department(name: String, noOfStudents: Int) {

  var code = ""

  def this(name: String, noOfStudents: Int, code: String) {
    this(name, noOfStudents)
    this.code = code
  }

  def print = {
    println(s"The Values are- Name: $name & No Of Students: $noOfStudents & Code: $code")
  }
}

object Department {

  def apply(name: String, noOfStudents: Int): Department = {
    new Department(name, noOfStudents)
  }

  def apply(name: String, noOfStudents: Int, code: String): Department = {
    new Department(name, noOfStudents, code)
  }
}