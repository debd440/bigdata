package com.deb.chapter4

class MultipleTraitDAOImpl extends IStudentDAO with IDepartmentDAO {

  override def add(name: String, id: Int): Long = {

    println(s"Add method Is Called: Name: $name & Id: $id")
    1
  }

  override def update(id: Int): Long = {
    println(s"Update method Is Called:  Id: $id")
    1
  }
}