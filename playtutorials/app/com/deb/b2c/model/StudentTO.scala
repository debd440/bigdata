package com.deb.b2c.model

import java.sql.Timestamp
import java.text.SimpleDateFormat
import play.api.libs.json.{ Json, _ }

case class StudentTO(id: Option[Int], name: String, city: Option[String], mobile: Option[String], dob: Option[Timestamp])

object StudentTO {

  implicit object timestampFormat extends Format[Timestamp] {

    var format = new SimpleDateFormat("yyyy-MM-dd")

    def reads(json: JsValue) = {
      val str = json.as[String]
      JsSuccess(new Timestamp(format.parse(str).getTime))
    }

    def writes(ts: Timestamp) = JsString(format.format(ts))
  }

  implicit val jsonFormat = Json.format[StudentTO]
}