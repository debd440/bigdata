package com.deb.b2c.service

import scala.concurrent.Future
import com.deb.b2c.model.StudentTO

trait IStudentService {

  def addStudent(obj: StudentTO): Future[Int]

  def updateStudent(obj: StudentTO): Future[Int]

  def getStudent(id: Int): Future[Option[StudentTO]]

  def getAllStudent(): Future[Seq[StudentTO]]

  def deleteStudent(id: Int): Future[Int]
}