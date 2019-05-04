package com.deb.chapter4

object GenericTest {

  def main(args: Array[String]): Unit = {

     //Example 1
    println("*****************************")
    println("Example 1: Generic Test")
    var employeeDAO: IEmployeeDAO[String] = new EmployeeDAOImpl[String]
    println(s"Employee DAO : ${employeeDAO.add("Hello World")}")
    var employeeDAO1: IEmployeeDAO[Long] = new EmployeeDAOImpl[Long]
    println(s"Employee DAO : ${employeeDAO1.add(23)}")
  }
}