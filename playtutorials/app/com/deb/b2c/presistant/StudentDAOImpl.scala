package com.deb.b2c.presistant

import java.sql.Timestamp

import scala.concurrent.Future
import javax.inject.Singleton
import com.deb.b2c.model.StudentTO
import com.google.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import play.api._
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.db.NamedDatabase
import slick.jdbc.JdbcProfile

@Singleton
class StudentDAOImpl @Inject() (@NamedDatabase("play") protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] with IStudentDAO {

  import profile.api._

  class Student(_tabletag: Tag) extends profile.api.Table[StudentTO](_tabletag, Some("play"), "STUDENT") {

    def * = (id, name, city, mobile, dob) <> ((StudentTO.apply _).tupled, StudentTO.unapply)

    var id: Rep[Option[Int]] = column[Option[Int]]("ID", O.PrimaryKey, O.AutoInc)
    var name: Rep[String] = column[String]("NAME")
    var city: Rep[Option[String]] = column[Option[String]]("CITY")
    var mobile: Rep[Option[String]] = column[Option[String]]("MOBILE")
    var dob: Rep[Option[Timestamp]] = column[Option[Timestamp]]("DOB")
  }

  lazy val student = new TableQuery(tag => new Student(tag))

  override def addStudent(obj: StudentTO): Future[Int] = {

    println(s"In DAO Layer: addStudent ")
    //Oracle
    //var query = (student.map(item => (item.name, item.city, item.mobile, item.dob)) returning student) += (obj.name, obj.city, obj.mobile, obj.dob)
    //MySql- Does not support  returning Id
    var query = student += obj
    dbConfig.db.run(query).map { res => (res) }
  }

  override def updateStudent(obj: StudentTO): Future[Int] = {

    println(s"In DAO Layer: updateStudent ")
    var query = student.filter(_.id === obj.id).map(item => (item.mobile, item.city)).update(obj.mobile, obj.city)
    dbConfig.db.run(query)
  }

  override def getStudent(id: Int): Future[Option[StudentTO]] = {

    println(s"In DAO Layer: getStudent - $id")
    val query = student.filter(_.id === id).result
    dbConfig.db.run(query.headOption)
  }

  override def getAllStudent(): Future[Seq[StudentTO]] = {

    println("In DAO Layer: getAllStudent")
    var query = student.sortBy(_.id desc).result
    var list = dbConfig.db.run(query)
    return list
  }

  override def deleteStudent(id: Int): Future[Int] = {

    println(s"In DAO Layer: deleteStudent - $id")
    val query = student.filter(_.id === id).delete
    dbConfig.db.run(query)
  }
}