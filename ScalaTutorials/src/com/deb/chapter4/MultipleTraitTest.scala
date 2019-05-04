package com.deb.chapter4

object MultipleTraitTest {

  def main(args: Array[String]): Unit = {

    println("*****************************")
    println("Example 1: Multiple Test")
    var traitObj: IStudentDAO = new MultipleTraitDAOImpl()
    println(s"Result : ${traitObj.add("Raul", 1)}")
    println(s"Result : ${traitObj.update(1)}")

    var traitObj1: IDepartmentDAO = new MultipleTraitDAOImpl()
    println(s"Result : ${traitObj1.add("Raul", 1)}")
    //  println(s"Result : ${traitObj1.update(1)}")
  }
}