package com.deb.b2c.presistant

import scala.concurrent.Future
import com.deb.b2c.model.StudentTO

trait IStudentDAO {

  def addStudent(obj: StudentTO): Future[Int]

  def updateStudent(obj: StudentTO): Future[Int]

  def getStudent(id: Int): Future[Option[StudentTO]]

  def getAllStudent(): Future[Seq[StudentTO]]

  def deleteStudent(id: Int): Future[Int]
}