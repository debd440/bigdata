package com.deb.chapter4

object TraitTest {

  def main(args: Array[String]): Unit = {

    //Example 1
    println("*****************************")
    println("Example 1: Trait Test")
    var studentDAO: IStudentDAO = new StudentDAOImpl()
    println(s"The Student Add Method:  ${studentDAO.add("Rahul", 1)}")
    println(s"The Student Update Method:  ${studentDAO.update(4)}")
  }
}