package com.deb.b2c.service

import javax.inject.Singleton
import com.deb.b2c.presistant.IStudentDAO
import scala.concurrent.Future
import com.deb.b2c.model.StudentTO
import com.google.inject.Inject

@Singleton
class StudentServiceImpl @Inject() (iStudentDAO: IStudentDAO) extends IStudentService {

  def addStudent(obj: StudentTO): Future[Int] = {

    println("In Service Layer: addStudent")
    iStudentDAO.addStudent(obj)
  }

  def updateStudent(obj: StudentTO): Future[Int] = {

    println("In Service Layer: updateStudent")
    iStudentDAO.updateStudent(obj)
  }

  def getStudent(id: Int): Future[Option[StudentTO]] = {

    println("In Service Layer: getStudent")
    iStudentDAO.getStudent(id)
  }

  def getAllStudent(): Future[Seq[StudentTO]] = {

    println("In Service Layer: getAllStudent")
    iStudentDAO.getAllStudent()
  }

  def deleteStudent(id: Int): Future[Int] = {

    println("In Service Layer: deleteStudent")
    iStudentDAO.deleteStudent(id)
  }
}