package com.deb.chapter4

class EmployeeDAOImpl[A] extends IEmployeeDAO[A] {

  override def add(obj: A): Long = {

    println(s"Add method Is Called: Name: $obj")
    1
  }
}