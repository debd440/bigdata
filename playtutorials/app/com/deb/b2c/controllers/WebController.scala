package com.deb.b2c.controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import com.deb.b2c.model.Employee

@Singleton
class WebController @Inject() (cc: ControllerComponents, ec: ExecutionContext) extends AbstractController(cc) {

  def pathParam(id: Long, name: String) = Action {
    Ok(s"Path Param Values Are: Id: $id and Name: $name ")
  }

  def queryParam(id: Long, name: String) = Action { 
    Ok(s"Query Param Values Are: Id: $id and Name: $name ")
  }

  def postRequest() = Action.async { implicit request =>

    println(s"Request Received")
    val jsonBody = request.body.asJson.get
    println(s"Json Received: $jsonBody")
    var name = jsonBody \ "name"
    var id = jsonBody \ "id"
    print(s"The Values Are Namme: ${name.as[String]} Id: ${id.as[Long]}")
    //Alternative Example
    var emp = jsonBody.as[Employee]
    Future { Ok(s"Post Param Values Are: Id: ${emp.id} and Name: ${emp.name} ") }(ec)
  }

  def jsonResponse() = Action.async { implicit request =>

    var employee = Employee(12, "Rahul")
    var employee1 = Employee(15, "Sunil")
    var employeeList = List(employee, employee1)
    var jsonObject = Json.toJson(employeeList)
    Future { Ok(jsonObject) }(ec)
  }

  def responseWithHeader(id: Long, name: String) = Action.async {
    var result = s"Response With Header Param Values Are: Id: $id and Name: $name "
    Future { Ok(result).withHeaders(("x-response", "success"), ("x-system-id", "14198812")) }(ec)
  }
}

