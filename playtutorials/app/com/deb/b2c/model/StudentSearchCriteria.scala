package com.deb.b2c.model

import java.sql.Timestamp
import java.text.SimpleDateFormat

import play.api.libs.json.Format
import play.api.libs.json.JsString
import play.api.libs.json.JsSuccess
import play.api.libs.json.JsValue
import play.api.libs.json.Json

case class StudentSearchCriteria(name: Option[String], city: Option[String], mobile: Option[String])

object StudentSearchCriteria {

  implicit object timestampFormat extends Format[Timestamp] {

    var format = new SimpleDateFormat("yyyy-MM-dd")

    def reads(json: JsValue) = {
      val str = json.as[String]
      JsSuccess(new Timestamp(format.parse(str).getTime))
    }

    def writes(ts: Timestamp) = JsString(format.format(ts))
  }

  implicit val jsonFormat = Json.format[StudentSearchCriteria]
}