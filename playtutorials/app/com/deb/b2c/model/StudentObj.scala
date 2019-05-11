package com.deb.b2c.model

import java.sql.Timestamp
import java.text.SimpleDateFormat
import play.api.libs.json.{ Json, _ }

case class StudentObj(name: String, city: Option[String])

object StudentObj {

  implicit object timestampFormat extends Format[Timestamp] {

    var format = new SimpleDateFormat("yyyy-MM-dd")

    def reads(json: JsValue) = {
      val str = json.as[String]
      JsSuccess(new Timestamp(format.parse(str).getTime))
    }

    def writes(ts: Timestamp) = JsString(format.format(ts))
  }

  implicit val jsonFormat = Json.format[StudentObj]
}