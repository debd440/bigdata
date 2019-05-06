package com.deb.b2c.model

import play.api.libs.json.Reads
import play.api.libs.json.Writes
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json

case class Employee(id: Long, name: String)

object Employee {

  implicit val reader: Reads[Employee] = new Reads[Employee] {
    def reads(json: JsValue): JsResult[Employee] = {
      for {
        id <- (json \ "id").validate[Long]
        name <- (json \ "name").validate[String]
      } yield Employee(id, name)
    }
  }

  implicit val writer: Writes[Employee] = new Writes[Employee] {
    def writes(t: Employee): JsValue = {
      Json.obj (
        "id" -> t.id,
        "name" -> t.name
      )
    }
  }
}