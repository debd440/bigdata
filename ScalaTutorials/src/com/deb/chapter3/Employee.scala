package com.deb.chapter3

class Employee(name: String, code: Option[String] = None) {

  println(s"The Name Is: $name")

}

class PermanentEmployee(name: String) extends Employee(name) {
  println("Permanent Employee Called")
}

class ContractEmployee(name: String) extends Employee(name) {
  println("Contract Employee Called")
}

object Employee {

  def apply(name: String, code: Option[String]) = {

    code match {
      case Some("P") => new PermanentEmployee(name)
      case Some("C") => new ContractEmployee(name)
      case _         => new ContractEmployee(name)
    }
  }
}