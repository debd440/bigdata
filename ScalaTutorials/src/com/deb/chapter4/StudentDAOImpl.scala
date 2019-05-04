package com.deb.chapter4

class StudentDAOImpl extends IStudentDAO {

  override def add(name: String, id: Int): Long = {

    println(s"Add method Is Called: Name: $name & Id: $id")
    id
  }

  override def update(id: Int): Long = {

    println(s"Update Method Called.Id: $id")
    id
  }
}