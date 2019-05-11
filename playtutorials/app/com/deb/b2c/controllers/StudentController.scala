package com.deb.b2c.controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import play.api.libs.json.Json
import com.deb.b2c.model.StudentTO
import scala.concurrent.ExecutionContext.Implicits.global
import com.deb.b2c.service.IStudentService
import com.deb.b2c.model.StudentSearchCriteria

@Singleton
class StudentController @Inject() (cc: ControllerComponents, ec: ExecutionContext, iStudentService: IStudentService) extends AbstractController(cc) {

  def addStudent() = Action.async { implicit request =>

    println(s"Request Received-addStudent")
    val jsonBody = request.body.asJson.get
    var student = jsonBody.as[StudentTO]
    var result = iStudentService.addStudent(student)
    result.map({ obj =>
      Ok(Json.toJson(obj))
    })
  }

  def updateStudent() = Action.async { implicit request =>

    println(s"Request Received-updateStudent")
    val jsonBody = request.body.asJson.get
    var student = jsonBody.as[StudentTO]
    var result = iStudentService.updateStudent(student)
    result.map({ obj =>
      Ok(Json.toJson(obj))
    })
  }

  def getStudent(id: Int) = Action.async { implicit request =>

    println("Received Request-getAllStudent")
    var result = iStudentService.getStudent(id)
    result.map({ obj =>
      Ok(Json.toJson(obj))
    })
  }

  def getAllStudent() = Action.async { implicit request =>

    println("Received Request-getAllStudent")
    var result: Future[Seq[StudentTO]] = iStudentService.getAllStudent()
    result.map({ obj =>
      Ok(Json.toJson(obj))
    })
  }

  def deleteStudent(id: Int) = Action.async { implicit request =>

    println("Received Request-deleteStudent")
    var result = iStudentService.deleteStudent(id)
    result.map({ obj =>
      Ok(Json.toJson(obj))
    })
  }

  def searchStudent() = Action.async { implicit request =>

    println("Received Request-searchStudent")
    val jsonBody = request.body.asJson.get
    var seachObj = jsonBody.as[StudentSearchCriteria]
    var result = iStudentService.searchStudent(seachObj)
    result.map({ obj =>
      Ok(Json.toJson(obj))
    })
  }

  def getCustomStudent(id: Int) = Action.async { implicit request =>

    println("Received Request-getCustomStudent")
    var result = iStudentService.getCustomStudent(id)
    result.map({ obj =>
      Ok(Json.toJson(obj))
    })
  }
}